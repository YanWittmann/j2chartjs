package de.yanwittmann.j2chartjs.dataset;

import de.yanwittmann.j2chartjs.type.ChartFill;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unchecked")
public class RadarChartDataset extends ChartDataset<RadarChartDataset, Number> {

    // general data
    private String label;
    private Integer order;

    // point styling
    /**
     * The fill color for points.
     */
    private List<Color> pointBackgroundColor = null;
    /**
     * The border color for points.
     */
    private List<Color> pointBorderColor = null;
    /**
     * The width of the point border in pixels.
     */
    private List<Number> pointBorderWidth = null;
    /**
     * The pixel size of the non-displayed point that reacts to mouse events.
     */
    private List<Number> pointHitRadius = null;
    /**
     * The radius of the point shape. If set to 0, the point is not rendered.
     */
    private List<Number> pointRadius = null;
    /**
     * The rotation of the point in degrees.
     */
    private List<Number> pointRotation = null;
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
    private List<String> pointStyle = null;
    /**
     * Point background color when hovered.
     */
    private List<Color> pointHoverBackgroundColor = null;
    /**
     * Point border color when hovered.
     */
    private List<Color> pointHoverBorderColor = null;
    /**
     * Border width of point when hovered.
     */
    private List<Number> pointHoverBorderWidth = null;
    /**
     * The radius of the point when hovered.
     */
    private List<Number> pointHoverRadius = null;

    // line styling
    /**
     * The line fill color.
     */
    private Color backgroundColor;
    /**
     * Cap style of the line. See <a href="https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/lineCap">MDN</a>.
     */
    private String borderCapStyle;
    /**
     * The line color.
     */
    private Color borderColor;
    /**
     * Length and spacing of dashes. See <a href="https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/setLineDash">MDN</a>.
     */
    private List<Integer> borderDash;
    /**
     * The line width (in pixels).
     */
    private Number borderWidth;
    /**
     * Bézier curve tension of the line. Set to 0 to draw straightlines. This option is ignored if monotone cubic interpolation is used.<br>
     * 0 - 1
     */
    private Number tension;
    /**
     * If false, the line is not drawn for this dataset.
     */
    private Boolean showLine;
    /**
     * If true, lines will be drawn between points with no or null data. If false, points with null data will create a break in the line.
     */
    private Boolean spanGaps;
    /**
     * How to fill the area under the line.
     */
    private ChartFill fill;

    public String getLabel() {
        return label;
    }

    public RadarChartDataset setLabel(String label) {
        this.label = label;
        return this;
    }

    public int getOrder() {
        return order;
    }

    public RadarChartDataset setOrder(int order) {
        this.order = order;
        return this;
    }

    public RadarChartDataset addPointBackgroundColor(Color... colors) {
        pointBackgroundColor = Util.initializeListIfNull(pointBackgroundColor);
        pointBackgroundColor.addAll(Arrays.asList(colors));
        return this;
    }

    public RadarChartDataset addPointBorderColor(Color... colors) {
        pointBorderColor = Util.initializeListIfNull(pointBorderColor);
        pointBorderColor.addAll(Arrays.asList(colors));
        return this;
    }

    public RadarChartDataset addPointBorderWidth(Number... widths) {
        pointBorderWidth = Util.initializeListIfNull(pointBorderWidth);
        pointBorderWidth.addAll(Arrays.asList(widths));
        return this;
    }

    public RadarChartDataset addPointHitRadius(Number... radiuses) {
        pointHitRadius = Util.initializeListIfNull(pointHitRadius);
        pointHitRadius.addAll(Arrays.asList(radiuses));
        return this;
    }

    public RadarChartDataset addPointRadius(Number... radiuses) {
        pointRadius = Util.initializeListIfNull(pointRadius);
        pointRadius.addAll(Arrays.asList(radiuses));
        return this;
    }

    public RadarChartDataset addPointRotation(Number... rotations) {
        pointRotation = Util.initializeListIfNull(pointRotation);
        pointRotation.addAll(Arrays.asList(rotations));
        return this;
    }

    public RadarChartDataset addPointStyle(String... styles) {
        pointStyle = Util.initializeListIfNull(pointStyle);
        pointStyle.addAll(Arrays.asList(styles));
        return this;
    }

    public RadarChartDataset addPointHoverBackgroundColor(Color... colors) {
        pointHoverBackgroundColor = Util.initializeListIfNull(pointHoverBackgroundColor);
        pointHoverBackgroundColor.addAll(Arrays.asList(colors));
        return this;
    }

    public RadarChartDataset addPointHoverBorderColor(Color... colors) {
        pointHoverBorderColor = Util.initializeListIfNull(pointHoverBorderColor);
        pointHoverBorderColor.addAll(Arrays.asList(colors));
        return this;
    }

    public RadarChartDataset addPointHoverBorderWidth(Number... widths) {
        pointHoverBorderWidth = Util.initializeListIfNull(pointHoverBorderWidth);
        pointHoverBorderWidth.addAll(Arrays.asList(widths));
        return this;
    }

    public RadarChartDataset addPointHoverRadius(Number... radiuses) {
        pointHoverRadius = Util.initializeListIfNull(pointHoverRadius);
        pointHoverRadius.addAll(Arrays.asList(radiuses));
        return this;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public RadarChartDataset setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public String getBorderCapStyle() {
        return borderCapStyle;
    }

    public RadarChartDataset setBorderCapStyle(String borderCapStyle) {
        this.borderCapStyle = borderCapStyle;
        return this;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public RadarChartDataset setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public List<Integer> getBorderDash() {
        return borderDash;
    }

    public RadarChartDataset setBorderDash(List<Integer> borderDash) {
        this.borderDash = borderDash;
        return this;
    }

    public Number getBorderWidth() {
        return borderWidth;
    }

    public RadarChartDataset setBorderWidth(Number borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public Number getTension() {
        return tension;
    }

    public RadarChartDataset setTension(double tension) {
        this.tension = tension;
        return this;
    }

    public RadarChartDataset setTension(int tension) {
        this.tension = tension;
        return this;
    }

    public Boolean getShowLine() {
        return showLine;
    }

    public RadarChartDataset setShowLine(Boolean showLine) {
        this.showLine = showLine;
        return this;
    }

    public Boolean getSpanGaps() {
        return spanGaps;
    }

    public RadarChartDataset setSpanGaps(Boolean spanGaps) {
        this.spanGaps = spanGaps;
        return this;
    }

    public ChartFill getFill() {
        return fill;
    }

    public RadarChartDataset setFill(ChartFill fill) {
        this.fill = fill;
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject datasetJson = new JSONObject();
        Util.addToJson(datasetJson, "data", data);
        Util.addToJson(datasetJson, "label", label);
        Util.addToJson(datasetJson, "order", order);
        Util.addToJson(datasetJson, "pointBackgroundColor", pointBackgroundColor);
        Util.addToJson(datasetJson, "pointBorderColor", pointBorderColor);
        Util.addToJson(datasetJson, "pointBorderWidth", pointBorderWidth);
        Util.addToJson(datasetJson, "pointHitRadius", pointHitRadius);
        Util.addToJson(datasetJson, "pointRadius", pointRadius);
        Util.addToJson(datasetJson, "pointRotation", pointRotation);
        Util.addToJson(datasetJson, "pointStyle", pointStyle);
        Util.addToJson(datasetJson, "pointHoverBackgroundColor", pointHoverBackgroundColor);
        Util.addToJson(datasetJson, "pointHoverBorderColor", pointHoverBorderColor);
        Util.addToJson(datasetJson, "pointHoverBorderWidth", pointHoverBorderWidth);
        Util.addToJson(datasetJson, "pointHoverRadius", pointHoverRadius);
        Util.addToJson(datasetJson, "backgroundColor", backgroundColor);
        Util.addToJson(datasetJson, "borderCapStyle", borderCapStyle);
        Util.addToJson(datasetJson, "borderColor", borderColor);
        Util.addToJson(datasetJson, "borderDash", borderDash);
        Util.addToJson(datasetJson, "borderWidth", borderWidth);
        Util.addToJson(datasetJson, "tension", tension);
        Util.addToJson(datasetJson, "showLine", showLine);
        Util.addToJson(datasetJson, "spanGaps", spanGaps);
        Util.addToJson(datasetJson, "fill", fill);
        return datasetJson;
    }
}
