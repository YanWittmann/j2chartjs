package de.yanwittmann.j2chartjs.options.scale;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.j2chartjs.type.ChartFont;
import de.yanwittmann.j2chartjs.type.ChartPadding;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;

public class RadialScaleTicksOption extends AbstractChartOption {

    /**
     * If true, show tick labels.
     */
    private Boolean display;
    /**
     * Color of ticks.
     */
    private Color color;
    /**
     * Font of the tick labels.
     */
    private ChartFont font;
    /**
     * If true, major ticks are generated. A major tick will affect auto-skipping and major will be defined on ticks in the scriptable options context.
     */
    private Boolean major;
    /**
     * Sets the offset of the tick labels from the axis.
     */
    private Integer padding;
    /**
     * The color of the stroke around the text.
     */
    private Color textStrokeColor;
    /**
     * Stroke width around the text.
     */
    private Integer textStrokeWidth;
    /**
     * z-index of tick layer.<br>
     * Useful when ticks are drawn on chart area. Values smaller or equals 0 are drawn under datasets, larger 0 on top.
     */
    private Integer z;
    /**
     * Color of label backdrops.
     */
    private Color backdropColor;
    /**
     * Padding of label backdrop.
     */
    private ChartPadding backdropPadding;
    /**
     * The number of ticks to generate. If specified, this overrides the automatic generation.
     */
    private Integer count;
    /**
     * Maximum number of ticks and gridlines to show.
     */
    private Integer maxTicksLimit;
    /**
     * If defined and stepSize is not specified, the step size will be rounded to this many decimal places.
     */
    private Integer precision;
    /**
     * User defined fixed step size for the scale.
     */
    private Integer stepSize;

    public Boolean getDisplay() {
        return display;
    }

    public RadialScaleTicksOption setDisplay(Boolean display) {
        this.display = display;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public RadialScaleTicksOption setColor(Color color) {
        this.color = color;
        return this;
    }

    public ChartFont getFont() {
        return font;
    }

    public RadialScaleTicksOption setFont(ChartFont font) {
        this.font = font;
        return this;
    }

    public Boolean getMajor() {
        return major;
    }

    public RadialScaleTicksOption setMajor(Boolean major) {
        this.major = major;
        return this;
    }

    public Integer getPadding() {
        return padding;
    }

    public RadialScaleTicksOption setPadding(Integer padding) {
        this.padding = padding;
        return this;
    }

    public Color getTextStrokeColor() {
        return textStrokeColor;
    }

    public RadialScaleTicksOption setTextStrokeColor(Color textStrokeColor) {
        this.textStrokeColor = textStrokeColor;
        return this;
    }

    public Integer getTextStrokeWidth() {
        return textStrokeWidth;
    }

    public RadialScaleTicksOption setTextStrokeWidth(Integer textStrokeWidth) {
        this.textStrokeWidth = textStrokeWidth;
        return this;
    }

    public Integer getZ() {
        return z;
    }

    public RadialScaleTicksOption setZ(Integer z) {
        this.z = z;
        return this;
    }

    public Color getBackdropColor() {
        return backdropColor;
    }

    public RadialScaleTicksOption setBackdropColor(Color backdropColor) {
        this.backdropColor = backdropColor;
        return this;
    }

    public ChartPadding getBackdropPadding() {
        return backdropPadding;
    }

    public RadialScaleTicksOption setBackdropPadding(ChartPadding backdropPadding) {
        this.backdropPadding = backdropPadding;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public RadialScaleTicksOption setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Integer getMaxTicksLimit() {
        return maxTicksLimit;
    }

    public RadialScaleTicksOption setMaxTicksLimit(Integer maxTicksLimit) {
        this.maxTicksLimit = maxTicksLimit;
        return this;
    }

    public Integer getPrecision() {
        return precision;
    }

    public RadialScaleTicksOption setPrecision(Integer precision) {
        this.precision = precision;
        return this;
    }

    public Integer getStepSize() {
        return stepSize;
    }

    public RadialScaleTicksOption setStepSize(Integer stepSize) {
        this.stepSize = stepSize;
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject optionsJson = new JSONObject();
        if (display != null) optionsJson.put("display", display);
        if (color != null) optionsJson.put("color", Util.convertColorToJs(color));
        if (font != null) optionsJson.put("font", font.toJson());
        if (padding != null) optionsJson.put("padding", padding);
        if (textStrokeColor != null) optionsJson.put("textStrokeColor", Util.convertColorToJs(textStrokeColor));
        if (textStrokeWidth != null) optionsJson.put("textStrokeWidth", textStrokeWidth);
        if (z != null) optionsJson.put("z", z);
        if (backdropColor != null) optionsJson.put("backdropColor", Util.convertColorToJs(backdropColor));
        if (backdropPadding != null) {
            if (backdropPadding.isIdentical())
                optionsJson.put("backdropPadding", backdropPadding.getPaddingBottom());
            else optionsJson.put("backdropPadding", backdropPadding.toJson());
        }
        if (count != null) optionsJson.put("count", count);
        if (maxTicksLimit != null) optionsJson.put("maxTicksLimit", maxTicksLimit);
        if (precision != null) optionsJson.put("precision", precision);
        if (stepSize != null) optionsJson.put("stepSize", stepSize);
        if (major != null) {
            JSONObject majorJson = new JSONObject();
            majorJson.put("enabled", major.booleanValue());
            optionsJson.put("major", majorJson);
        }
        return optionsJson;
    }
}
