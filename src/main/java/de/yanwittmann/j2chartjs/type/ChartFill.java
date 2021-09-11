package de.yanwittmann.j2chartjs.type;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;

public class ChartFill extends AbstractChartOption {

    /**
     * The accepted values are the same as the filling mode values, so you may use absolute and relative dataset indexes and/or boundaries.<br>
     * (<code>origin</code>)
     */
    private String target;
    /**
     * If no color is set, the default color will be the background color of the chart.
     */
    private Color above;
    /**
     * Same as the above.
     */
    private Color below;

    @Override
    public JSONObject toJson() {
        JSONObject fillJson = new JSONObject();
        if (target != null) fillJson.put("target", target);
        if (above != null) fillJson.put("above", Util.convertColorToJs(above));
        if (below != null) fillJson.put("below", Util.convertColorToJs(below));
        return fillJson;
    }
}
