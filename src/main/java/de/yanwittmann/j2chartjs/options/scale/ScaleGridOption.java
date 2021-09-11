package de.yanwittmann.j2chartjs.options.scale;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;
import java.util.List;


public class ScaleGridOption extends AbstractChartOption {

    /**
     * If set, used as the color of the border line. If unset, the first color option is resolved and used.
     */
    private Color textStrokeColor;
    /**
     * If set, used as the width of the border line. If unset, the first lineWidth option is resolved and used.
     */
    private Integer borderWidth;
    /**
     * Length and spacing of dashes on grid lines. See <a href="https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/setLineDash">MDN</a>.
     */
    private List<Integer> borderDash;
    /**
     * Offset for line dashes. See <a href="https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/lineDashOffset">MDN</a>.
     */
    private Integer borderDashOffset;
    /**
     * If true, gridlines are circular (on radar chart only).
     */
    private Boolean circular;
    /**
     * The color of the grid lines. If specified as an array, the first color applies to the first grid line, the second to the second grid line, and so on.
     */
    private Color color;
    /**
     * If false, do not display grid lines for this axis.
     */
    private Boolean display;
    /**
     * If true, draw a border at the edge between the axis and the chart area.
     */
    private Boolean drawBorder;
    /**
     * If true, draw lines on the chart area inside the axis lines. This is useful when there are multiple axes, and you need to control which grid lines are drawn.
     */
    private Boolean drawOnChartArea;
    /**
     * If true, draw lines beside the ticks in the axis area beside the chart.
     */
    private Boolean drawTicks;
    /**
     * Stroke width of grid lines.
     */
    private Integer lineWidth;
    /**
     * If true, grid lines will be shifted to be between labels. This is set to true for a bar chart by default.
     */
    private Boolean offset;
    /**
     * Length and spacing of the tick mark line. If not set, defaults to the grid line <code>borderDash</code> value.
     */
    private List<Integer> tickBorderDash;
    /**
     * Offset for the line dash of the tick mark. If unset, defaults to the grid line <code>borderDashOffset</code> value.
     */
    private Integer tickBorderDashOffset;
    /**
     * Color of the tick line. If unset, defaults to the grid line color.
     */
    private Color tickColor;
    /**
     * Length in pixels that the grid lines will draw into the axis area.
     */
    private Integer tickLength;
    /**
     * Width of the tick mark in pixels. If unset, defaults to the grid line width.
     */
    private Integer tickWidth;
    /**
     * z-index of gridline layer. Values smaller or equals 0 are drawn under datasets, larger 0 on top.
     */
    private Integer z;

    public Color getTextStrokeColor() {
        return textStrokeColor;
    }

    public ScaleGridOption setTextStrokeColor(Color textStrokeColor) {
        this.textStrokeColor = textStrokeColor;
        return this;
    }

    public Integer getBorderWidth() {
        return borderWidth;
    }

    public ScaleGridOption setBorderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public List<Integer> getBorderDash() {
        return borderDash;
    }

    public ScaleGridOption setBorderDash(List<Integer> borderDash) {
        this.borderDash = borderDash;
        return this;
    }

    public Integer getBorderDashOffset() {
        return borderDashOffset;
    }

    public ScaleGridOption setBorderDashOffset(Integer borderDashOffset) {
        this.borderDashOffset = borderDashOffset;
        return this;
    }

    public Boolean getCircular() {
        return circular;
    }

    public ScaleGridOption setCircular(Boolean circular) {
        this.circular = circular;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public ScaleGridOption setColor(Color color) {
        this.color = color;
        return this;
    }

    public Boolean getDisplay() {
        return display;
    }

    public ScaleGridOption setDisplay(Boolean display) {
        this.display = display;
        return this;
    }

    public Boolean getDrawBorder() {
        return drawBorder;
    }

    public ScaleGridOption setDrawBorder(Boolean drawBorder) {
        this.drawBorder = drawBorder;
        return this;
    }

    public Boolean getDrawOnChartArea() {
        return drawOnChartArea;
    }

    public ScaleGridOption setDrawOnChartArea(Boolean drawOnChartArea) {
        this.drawOnChartArea = drawOnChartArea;
        return this;
    }

    public Boolean getDrawTicks() {
        return drawTicks;
    }

    public ScaleGridOption setDrawTicks(Boolean drawTicks) {
        this.drawTicks = drawTicks;
        return this;
    }

    public Integer getLineWidth() {
        return lineWidth;
    }

    public ScaleGridOption setLineWidth(Integer lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    public Boolean getOffset() {
        return offset;
    }

    public ScaleGridOption setOffset(Boolean offset) {
        this.offset = offset;
        return this;
    }

    public List<Integer> getTickBorderDash() {
        return tickBorderDash;
    }

    public ScaleGridOption setTickBorderDash(List<Integer> tickBorderDash) {
        this.tickBorderDash = tickBorderDash;
        return this;
    }

    public Integer getTickBorderDashOffset() {
        return tickBorderDashOffset;
    }

    public ScaleGridOption setTickBorderDashOffset(Integer tickBorderDashOffset) {
        this.tickBorderDashOffset = tickBorderDashOffset;
        return this;
    }

    public Color getTickColor() {
        return tickColor;
    }

    public ScaleGridOption setTickColor(Color tickColor) {
        this.tickColor = tickColor;
        return this;
    }

    public Integer getTickLength() {
        return tickLength;
    }

    public ScaleGridOption setTickLength(Integer tickLength) {
        this.tickLength = tickLength;
        return this;
    }

    public Integer getTickWidth() {
        return tickWidth;
    }

    public ScaleGridOption setTickWidth(Integer tickWidth) {
        this.tickWidth = tickWidth;
        return this;
    }

    public Integer getZ() {
        return z;
    }

    public ScaleGridOption setZ(Integer z) {
        this.z = z;
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject optionsJson = new JSONObject();
        if (textStrokeColor != null) optionsJson.put("textStrokeColor", Util.convertColorToJs(textStrokeColor));
        if (borderWidth != null) optionsJson.put("borderWidth", borderWidth);
        if (borderDash != null) optionsJson.put("borderDash", borderDash);
        if (borderDashOffset != null) optionsJson.put("borderDashOffset", borderDashOffset);
        if (circular != null) optionsJson.put("circular", circular);
        if (color != null) optionsJson.put("color", Util.convertColorToJs(color));
        if (display != null) optionsJson.put("display", display);
        if (drawBorder != null) optionsJson.put("drawBorder", drawBorder);
        if (drawOnChartArea != null) optionsJson.put("drawOnChartArea", drawOnChartArea);
        if (drawTicks != null) optionsJson.put("drawTicks", drawTicks);
        if (lineWidth != null) optionsJson.put("lineWidth", lineWidth);
        if (offset != null) optionsJson.put("offset", offset);
        if (tickBorderDash != null) optionsJson.put("tickBorderDash", tickBorderDash);
        if (tickBorderDashOffset != null) optionsJson.put("tickBorderDashOffset", tickBorderDashOffset);
        if (tickColor != null) optionsJson.put("tickColor", Util.convertColorToJs(tickColor));
        if (tickLength != null) optionsJson.put("tickLength", tickLength);
        if (tickWidth != null) optionsJson.put("tickWidth", tickWidth);
        if (z != null) optionsJson.put("z", z);
        return optionsJson;
    }
}
