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
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
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
}
