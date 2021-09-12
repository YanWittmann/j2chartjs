package de.yanwittmann.j2chartjs.dataset;

import de.yanwittmann.j2chartjs.type.ChartFill;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unchecked")
public class RadarChartDataset extends ChartDataset<RadarChartDataset, BigDecimal> {

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
    private List<Integer> pointBorderWidth = null;
    /**
     * The pixel size of the non-displayed point that reacts to mouse events.
     */
    private List<Integer> pointHitRadius = null;
    /**
     * The radius of the point shape. If set to 0, the point is not rendered.
     */
    private List<Integer> pointRadius = null;
    /**
     * The rotation of the point in degrees.
     */
    private List<Integer> pointRotation = null;
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
    private List<Integer> pointHoverBorderWidth = null;
    /**
     * The radius of the point when hovered.
     */
    private List<Integer> pointHoverRadius = null;

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
    private Integer borderWidth;
    /**
     * Bézier curve tension of the line. Set to 0 to draw straightlines. This option is ignored if monotone cubic interpolation is used.<br>
     * 0 - 1
     */
    private BigDecimal tension;
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

    public RadarChartDataset addPointBorderWidth(Integer... widths) {
        pointBorderWidth = Util.initializeListIfNull(pointBorderWidth);
        pointBorderWidth.addAll(Arrays.asList(widths));
        return this;
    }

    public RadarChartDataset addPointHitRadius(Integer... radiuses) {
        pointHitRadius = Util.initializeListIfNull(pointHitRadius);
        pointHitRadius.addAll(Arrays.asList(radiuses));
        return this;
    }

    public RadarChartDataset addPointRadius(Integer... radiuses) {
        pointRadius = Util.initializeListIfNull(pointRadius);
        pointRadius.addAll(Arrays.asList(radiuses));
        return this;
    }

    public RadarChartDataset addPointRotation(Integer... rotations) {
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

    public RadarChartDataset addPointHoverBorderWidth(Integer... widths) {
        pointHoverBorderWidth = Util.initializeListIfNull(pointHoverBorderWidth);
        pointHoverBorderWidth.addAll(Arrays.asList(widths));
        return this;
    }

    public RadarChartDataset addPointHoverRadius(Integer... radiuses) {
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

    public Integer getBorderWidth() {
        return borderWidth;
    }

    public RadarChartDataset setBorderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public BigDecimal getTension() {
        return tension;
    }

    public RadarChartDataset setTension(double tension) {
        this.tension = new BigDecimal(tension);
        return this;
    }

    public RadarChartDataset setTension(int tension) {
        this.tension = new BigDecimal(tension);
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

    public RadarChartDataset setData(int... data) {
        clearData();
        for (int d : data) this.data.add(new BigDecimal(d));
        return this;
    }

    public RadarChartDataset setData(double... data) {
        clearData();
        return addData(data);
    }

    public RadarChartDataset addData(double... data) {
        for (double d : data) this.data.add(new BigDecimal(d));
        return this;
    }

    public RadarChartDataset addData(int... data) {
        for (int d : data) this.data.add(new BigDecimal(d));
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject datasetJson = new JSONObject();
        datasetJson.put("data", data);
        if (label != null) datasetJson.put("label", label);
        if (order != null) datasetJson.put("order", order);
        Util.smartAddToJsonObject(datasetJson, "pointBackgroundColor", pointBackgroundColor);
        Util.smartAddToJsonObject(datasetJson, "pointBorderColor", pointBorderColor);
        Util.smartAddToJsonObject(datasetJson, "pointBorderWidth", pointBorderWidth);
        Util.smartAddToJsonObject(datasetJson, "pointHitRadius", pointHitRadius);
        Util.smartAddToJsonObject(datasetJson, "pointRadius", pointRadius);
        Util.smartAddToJsonObject(datasetJson, "pointRotation", pointRotation);
        Util.smartAddToJsonObject(datasetJson, "pointStyle", pointStyle);
        Util.smartAddToJsonObject(datasetJson, "pointHoverBackgroundColor", pointHoverBackgroundColor);
        Util.smartAddToJsonObject(datasetJson, "pointHoverBorderColor", pointHoverBorderColor);
        Util.smartAddToJsonObject(datasetJson, "pointHoverBorderWidth", pointHoverBorderWidth);
        Util.smartAddToJsonObject(datasetJson, "pointHoverRadius", pointHoverRadius);
        if (backgroundColor != null) datasetJson.put("backgroundColor", Util.convertColorToJs(backgroundColor));
        if (borderCapStyle != null) datasetJson.put("borderCapStyle", borderCapStyle);
        if (borderColor != null) datasetJson.put("borderColor", Util.convertColorToJs(borderColor));
        if (borderDash != null) datasetJson.put("borderDash", borderDash);
        if (borderWidth != null) datasetJson.put("borderWidth", borderWidth);
        if (tension != null) datasetJson.put("tension", Util.roundToDecimals(tension.doubleValue(), 3));
        if (showLine != null) datasetJson.put("showLine", showLine);
        if (spanGaps != null) datasetJson.put("spanGaps", spanGaps);
        if (fill != null) datasetJson.put("fill", fill.toJson());
        return datasetJson;
    }
}
