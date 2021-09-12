package de.yanwittmann.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static void smartAddToJsonObject(JSONObject json, String key, List list) {
        if (json == null || list == null || list.size() == 0) return;
        if (list.size() == 1) json.put(key, convertColorToJs(list.get(0)));
        else json.put(key, convertColorToJs(list));
    }

    public static void smartAddToJsonObject(JSONObject json, String key, Object element) {
        if (json == null || element == null) return;
        json.put(key, convertColorToJs(element));
    }

    private static Object convertColorToJs(Object color) {
        if (color != null) {
            if (color instanceof Color) {
                return convertColorToJs((Color) color);
            }
        }
        return color;
    }

    private static List convertColorToJs(List color) {
        if (color != null && color.size() > 0) {
            if (color.get(0) instanceof Color) {
                return (List<String>) color.stream().map(c -> convertColorToJs((Color) c)).collect(Collectors.toList());
            }
        }
        return color;
    }

    public static String convertColorToJs(Color color) {
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
