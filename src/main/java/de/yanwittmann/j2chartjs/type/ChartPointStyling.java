package de.yanwittmann.j2chartjs.type;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;

public class ChartPointStyling extends AbstractChartOption {

    /**
     * The fill color for points.
     */
    private Color pointBackgroundColor;
    /**
     * The border color for points.
     */
    private Color pointBorderColor;
    /**
     * The width of the point border in pixels.
     */
    private Integer pointBorderWidth;
    /**
     * The pixel size of the non-displayed point that reacts to mouse events.
     */
    private Integer pointHitRadius;
    /**
     * The radius of the point shape. If set to 0, the point is not rendered.
     */
    private Integer pointRadius;
    /**
     * The rotation of the point in degrees.
     */
    private Integer pointRotation;
    /**
     * Style of the point.<ul>
     * <li>circle</li>
     * <li>cross</li>
     * <li>crossRot</li>
     * <li>dash</li>
     * <li>line</li>
     * <li>rect</li>
     * <li>rectRounded</li>
     * <li>rectRot</li>
     * <li>star</li>
     * <li>triangle</li>
     * </ul>
     */
    private String pointStyle;

    @Override
    public JSONObject toJson() {
        JSONObject pointsJson = new JSONObject();
        Util.addToJson(pointsJson, "pointBackgroundColor", pointBackgroundColor);
        Util.addToJson(pointsJson, "pointBorderColor", pointBorderColor);
        Util.addToJson(pointsJson, "pointBorderWidth", pointBorderWidth);
        Util.addToJson(pointsJson, "pointHitRadius", pointHitRadius);
        Util.addToJson(pointsJson, "pointRadius", pointRadius);
        Util.addToJson(pointsJson, "pointRotation", pointRotation);
        Util.addToJson(pointsJson, "pointStyle", pointStyle);
        return pointsJson;
    }
}
