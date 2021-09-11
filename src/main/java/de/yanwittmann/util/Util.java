package de.yanwittmann.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public abstract class Util {

    /**
     * Merge "source" into "target". If fields have equal name, merge them recursively.
     *
     * @return the merged object (target).
     * @author <a href="https://stackoverflow.com/users/827927/erel-segal-halevi">erel-segal-halevi</a> from this <a href="https://stackoverflow.com/a/15070484/15925251">Stack Overflow answer</a>
     */
    public static JSONObject deepMerge(JSONObject source, JSONObject target) throws JSONException {
        for (String key : JSONObject.getNames(source)) {
            Object value = source.get(key);
            if (!target.has(key)) {
                // new value for "key":
                target.put(key, value);
            } else {
                // existing value for "key" - recursively deep merge:
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
}
