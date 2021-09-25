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
    private Number pointBorderWidth;
    /**
     * The pixel size of the non-displayed point that reacts to mouse events.
     */
    private Number pointHitRadius;
    /**
     * The radius of the point shape. If set to 0, the point is not rendered.
     */
    private Number pointRadius;
    /**
     * The rotation of the point in degrees.
     */
    private Number pointRotation;
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

    public Color getPointBackgroundColor() {
        return pointBackgroundColor;
    }

    public ChartPointStyling setPointBackgroundColor(Color pointBackgroundColor) {
        this.pointBackgroundColor = pointBackgroundColor;
        return this;
    }

    public Color getPointBorderColor() {
        return pointBorderColor;
    }

    public ChartPointStyling setPointBorderColor(Color pointBorderColor) {
        this.pointBorderColor = pointBorderColor;
        return this;
    }

    public Number getPointBorderWidth() {
        return pointBorderWidth;
    }

    public ChartPointStyling setPointBorderWidth(Number pointBorderWidth) {
        this.pointBorderWidth = pointBorderWidth;
        return this;
    }

    public Number getPointHitRadius() {
        return pointHitRadius;
    }

    public ChartPointStyling setPointHitRadius(Number pointHitRadius) {
        this.pointHitRadius = pointHitRadius;
        return this;
    }

    public Number getPointRadius() {
        return pointRadius;
    }

    public ChartPointStyling setPointRadius(Number pointRadius) {
        this.pointRadius = pointRadius;
        return this;
    }

    public Number getPointRotation() {
        return pointRotation;
    }

    public ChartPointStyling setPointRotation(Number pointRotation) {
        this.pointRotation = pointRotation;
        return this;
    }

    public String getPointStyle() {
        return pointStyle;
    }

    public ChartPointStyling setPointStyle(String pointStyle) {
        this.pointStyle = pointStyle;
        return this;
    }

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
