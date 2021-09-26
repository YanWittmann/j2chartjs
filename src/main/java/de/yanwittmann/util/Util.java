package de.yanwittmann.util;

import de.yanwittmann.j2chartjs.chart.MixedChart;
import de.yanwittmann.j2chartjs.data.ChartData;
import de.yanwittmann.j2chartjs.data.MixedChartData;
import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.j2chartjs.options.animation.AnimationEasingType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.util.List;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class Util {

    /**
     * Written by <a href="https://stackoverflow.com/users/827927/erel-segal-halevi">erel-segal-halevi</a> from this <a href="https://stackoverflow.com/a/15070484/15925251">Stack Overflow answer</a><br>
     * Merge "source" into "target". If fields have equal name, merge them recursively.
     *
     * @return the merged object (target).
     */
    public static JSONObject deepMerge(JSONObject source, JSONObject target) throws JSONException {
        if (source == null || target == null || source.length() == 0) return target;
        for (String key : JSONObject.getNames(source)) {
            Object value = source.get(key);
            if (!target.has(key)) {
                target.put(key, value);
            } else {
                if (value instanceof JSONObject) {
                    JSONObject valueJson = (JSONObject) value;
                    deepMerge(valueJson, target.getJSONObject(key));
                } else {
                    target.put(key, value);
                }
            }
        }
        return target;
    }

    public static List initializeListIfNull(List list) {
        if (list == null) return new ArrayList<>();
        return list;
    }

    /**
     * Will convert the passed data into a configuration-friendly format and add it to the JSON Object under the
     * given key.
     *
     * @param json    The JSON Object to add the data to.
     * @param key     The key under which to add the data.
     * @param element The element to convert and add to the JSON Object.
     */
    public static void addToJson(JSONObject json, String key, Object element) {
        if (json == null || element == null || key == null) return;
        if (element instanceof List) {
            if (((List<?>) element).size() > 0) {
                List<Object> convertedElements = new ArrayList<>();
                for (Object o : (List<?>) element) {
                    convertedElements.add(smartAddToJsonForConfigurationConverter(o));
                }
                json.put(key, convertedElements);
            } else {
                json.put(key, new ArrayList<>());
            }
        } else {
            json.put(key, smartAddToJsonForConfigurationConverter(element));
        }
    }

    private static Object smartAddToJsonForConfigurationConverter(Object object) {
        if (object == null) return null;
        if (object instanceof Color) {
            return convertColorToJs((Color) object);
        } else if (object instanceof Double) {
            return roundToDecimals((Double) object, 3);
        } else if (object instanceof Number) {
            double doubleValue = ((Number) object).doubleValue();
            if (doubleValue >= 2147483) return ((Number) object).longValue();
            return roundToDecimals(((Number) object).doubleValue(), 3);
        } else if (object instanceof JSONObject || object instanceof JSONArray) {
            return object;
        } else if (object instanceof AbstractChartOption) {
            return ((AbstractChartOption) object).toJson();
        } else if (object instanceof ChartData) {
            return ((ChartData) object).toJson();
        } else if (object instanceof MixedChartData) {
            return ((MixedChartData) object).toJson();
        } else if (object instanceof MixedChart) {
            return ((MixedChart) object).toJson();
        } else if (object instanceof AnimationEasingType) {
            return ((AnimationEasingType) object).getKey();
        }
        return object;
    }

    private static String convertColorToJs(Color color) {
        if (color.getAlpha() != 255)
            return "rgba(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "," + roundToDecimals(mapRange(0, 255, 0, 1, color.getAlpha()), 3) + ")";
        return "rgb(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ")";
    }

    /**
     * Written by <a href="https://rosettacode.org/wiki/Map_range#Java">rosettacode.org</a>
     *
     * @param a1 The lower end of the original range.
     * @param a2 The upper end of the original range.
     * @param b1 The lower end of the destination range.
     * @param b2 The upper end of the destination range.
     * @param s  The number to convert from the original range to the destination range.
     * @return The number converted from the original range to the destination range.
     */
    public static double mapRange(double a1, double a2, double b1, double b2, double s) {
        return b1 + ((s - a1) * (b2 - b1)) / (a2 - a1);
    }

    public static double roundToDecimals(double d, int c) {
        return ((double) (int) (d * Math.pow(10, c))) / Math.pow(10, c);
    }

    private final static Set<String> STRING_ARRAY_IDENTIFIERS = new HashSet<String>() {{
        add("pointBackgroundColor");
        add("pointBorderColor");
        add("pointHoverBackgroundColor");
        add("pointHoverBorderColor");
        add("pointStyle");
        add("backgroundColor");
        add("borderColor");
        add("hoverBackgroundColor");
        add("hoverBorderColor");
        add("borderSkipped");
        add("hoverBorderSkipped");
    }};

    private final static Set<String> INTEGER_ARRAY_IDENTIFIERS = new HashSet<String>() {{
        add("pointBorderWidth");
        add("pointHitRadius");
        add("pointRadius");
        add("pointRotation");
        add("pointHoverBorderWidth");
        add("pointHoverRadius");
        add("borderWidth");
        add("borderRadius");
        add("hoverBorderWidth");
        add("hoverBorderRadius");
        add("rotation");
    }};

    public static String finalizeBuildString(String build) {
        for (String identifier : STRING_ARRAY_IDENTIFIERS)
            build = replaceIdentifierWithContextIndexFunction(build, identifier, true);
        for (String identifier : INTEGER_ARRAY_IDENTIFIERS)
            build = replaceIdentifierWithContextIndexFunction(build, identifier, false);
        return build;
    }

    private final static String INSERT_PATTERN = "(\"data\":\\[([^\\]]+)\\][^{}]+)?\"%s\":\\[([^\\]]+)\\]([^{}]+\"data\":\\[([^\\]]+)\\])?";

    private static String replaceIdentifierWithContextIndexFunction(String build, String identifier, boolean valueTypeIsString) {
        Pattern searchPattern = Pattern.compile(String.format(INSERT_PATTERN, identifier));
        Matcher matcher = searchPattern.matcher(build);

        while (matcher.find()) {
            // count how often the individual values appear in the list
            Map<String, List<Integer>> indexedValues = new HashMap<>();
            int index = 0;
            if (valueTypeIsString) {
                for (String value : Arrays.stream(matcher.group(3).replaceAll("^[\"'](.+)[\"']$", "$1").split("[\"'],[\"']")).collect(Collectors.toList())) {
                    indexedValues.computeIfAbsent(value, k -> new ArrayList<>()).add(index);
                    index++;
                }
            } else {
                for (String value : Arrays.stream(matcher.group(3).split(",")).collect(Collectors.toList())) {
                    indexedValues.computeIfAbsent(value, k -> new ArrayList<>()).add(index);
                    index++;
                }
            }

            // find the amount of data the dataset has
            int dataSize;
            String dataString = nonNull(matcher.group(2), matcher.group(5)).replaceAll("[{}]", "");
            if (dataString.contains("\""))
                dataSize = dataString.replaceAll("[{}]", "").split("\"?,\"").length;
            else dataSize = dataString.replaceAll("[{}]", "").split(",").length;
            if (dataString.contains("\"x\"") && dataString.contains("\"y\"")) {
                if (dataString.contains("\"r\"")) dataSize = dataSize / 3;
                else dataSize = dataSize / 2;
            }
            // if there is more or equal data than values in the current attribute, do not change the values.
            if (dataSize > 0 && dataSize > index) continue;

            // if there is only one detected value, simplify it into a simple value. Otherwise, create a function that returns the values based on their index.
            if (indexedValues.size() == 1) {
                build = build.replace(matcher.group(), nonNull(matcher.group(1)) + "\"" + identifier + "\":[" + (valueTypeIsString ? "'" : "") + indexedValues.keySet().stream().findFirst().orElse("") + (valueTypeIsString ? "'" : "") + "]" + nonNull(matcher.group(4)));
            } else {
                String function = makeContextIndexFunctionFromValues(indexedValues, valueTypeIsString);
                function = build.replace(matcher.group(), nonNull(matcher.group(1)) + "\"" + identifier + "\":" + function + nonNull(matcher.group(4)));
                if (function.length() < build.length())
                    build = function;
            }
        }

        return build;
    }

    private static String makeContextIndexFunctionFromValues(Map<String, List<Integer>> indexedValues, boolean valueTypeIsString) {
        StringBuilder function = new StringBuilder();
        function.append("function(c){");
        boolean isFirst = true;
        Iterator<Map.Entry<String, List<Integer>>> i = indexedValues.entrySet().stream().sorted(Comparator.comparing(o -> o.getValue().size())).iterator();
        while (i.hasNext()) {
            Map.Entry<String, List<Integer>> entry = i.next();
            if (i.hasNext()) {
                if (!isFirst) function.append("else ");
                function.append("if([")
                        .append(entry.getValue().stream().map(Object::toString).collect(Collectors.joining(",")))
                        .append("].indexOf(c.dataIndex)>-1)return");
            } else {
                function.append("return");
            }
            if (valueTypeIsString) function.append("'");
            else function.append(" ");
            function.append(entry.getKey());
            if (valueTypeIsString) function.append("'");
            function.append(";");
            isFirst = false;
        }
        function.append("}");
        return function.toString();
    }

    /**
     * Returns the first non-null string or an empty string if none was found.
     *
     * @param s An array of Strings.
     * @return The first non-null String or an empty String if none was found.
     */
    private static String nonNull(String... s) {
        for (String test : s) {
            if (test != null) return test;
        }
        return "";
    }
}
