package de.yanwittmann.j2chartjs.options.scale;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;

public class LinearScaleOption extends AbstractChartOption {

    /**
     * Options regarding the scale ticks.
     */
    private LinearScaleTicksOption ticks;
    /**
     * Options regarding the scale grid.
     */
    private ScaleGridOption grid;
    /**
     * Options regarding the scale title.
     */
    private ScaleTitleOption title;
    /**
     * Type of scale being employed.<br>Custom scales can be created and registered with a string key. This allows changing the type of axis for a chart.<br>
     * Example: <code>linear</code>, <code>logarithmic</code>, <code>time</code>, <code>radar</code>
     */
    private String type;
    /**
     * Align pixel values to device pixels.
     */
    private Boolean alignToPixels;
    /**
     * Background color of the scale area.
     */
    private Color backgroundColor;
    /**
     * Controls the axis global visibility.
     */
    private Boolean display;
    /**
     * User defined minimum number for the scale, overrides minimum value from data.
     */
    private Integer min;
    /**
     * User defined maximum number for the scale, overrides maximum value from data.
     */
    private Integer max;
    /**
     * Adjustment used when calculating the minimum data value.
     */
    private Integer suggestedMin;
    /**
     * Adjustment used when calculating the maximum data value.
     */
    private Integer suggestedMax;
    /**
     * Reverse the scale.
     */
    private Boolean reverse;
    /**
     * Whether the data should be stacked.
     */
    private Boolean stacked;
    /**
     * The weight used to sort the axis. Higher weights are further away from the chart area.
     */
    private Integer weight;
    /**
     * Where the scale should be placed.<ul>
     * <li><code>left</code></li>
     * <li><code>right</code></li>
     * <li><code>top</code></li>
     * <li><code>bottom</code></li>
     * <li><code>center</code></li>
     * </ul>
     */
    private String position;
    /**
     * Whether the scale should begin at 0 no matter what.
     */
    private Boolean beginAtZero;
    /**
     * User defined fixed step size for the scale.
     */
    private Number stepSize;

    public LinearScaleTicksOption getTicks() {
        return ticks;
    }

    public LinearScaleOption setTicks(LinearScaleTicksOption ticks) {
        this.ticks = ticks;
        return this;
    }

    public ScaleGridOption getGrid() {
        return grid;
    }

    public LinearScaleOption setGrid(ScaleGridOption grid) {
        this.grid = grid;
        return this;
    }

    public ScaleTitleOption getTitle() {
        return title;
    }

    public LinearScaleOption setTitle(ScaleTitleOption title) {
        this.title = title;
        return this;
    }

    public String getType() {
        return type;
    }

    public LinearScaleOption setType(String type) {
        this.type = type;
        return this;
    }

    public Boolean getAlignToPixels() {
        return alignToPixels;
    }

    public LinearScaleOption setAlignToPixels(Boolean alignToPixels) {
        this.alignToPixels = alignToPixels;
        return this;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public LinearScaleOption setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Boolean getDisplay() {
        return display;
    }

    public LinearScaleOption setDisplay(Boolean display) {
        this.display = display;
        return this;
    }

    public Integer getMin() {
        return min;
    }

    public LinearScaleOption setMin(Integer min) {
        this.min = min;
        return this;
    }

    public Integer getMax() {
        return max;
    }

    public LinearScaleOption setMax(Integer max) {
        this.max = max;
        return this;
    }

    public Integer getSuggestedMin() {
        return suggestedMin;
    }

    public LinearScaleOption setSuggestedMin(Integer suggestedMin) {
        this.suggestedMin = suggestedMin;
        return this;
    }

    public Integer getSuggestedMax() {
        return suggestedMax;
    }

    public LinearScaleOption setSuggestedMax(Integer suggestedMax) {
        this.suggestedMax = suggestedMax;
        return this;
    }

    public Boolean getReverse() {
        return reverse;
    }

    public LinearScaleOption setReverse(Boolean reverse) {
        this.reverse = reverse;
        return this;
    }

    public Boolean getStacked() {
        return stacked;
    }

    public LinearScaleOption setStacked(Boolean stacked) {
        this.stacked = stacked;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public LinearScaleOption setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public LinearScaleOption setPosition(String position) {
        this.position = position;
        return this;
    }

    public Boolean getBeginAtZero() {
        return beginAtZero;
    }

    public LinearScaleOption setBeginAtZero(Boolean beginAtZero) {
        this.beginAtZero = beginAtZero;
        return this;
    }

    public Number getStepSize() {
        return stepSize;
    }

    public LinearScaleOption setStepSize(Number stepSize) {
        this.stepSize = stepSize;
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject optionsJson = new JSONObject();
        Util.addToJson(optionsJson, "ticks", ticks);
        Util.addToJson(optionsJson, "grid", grid);
        Util.addToJson(optionsJson, "title", title);
        Util.addToJson(optionsJson, "type", type);
        Util.addToJson(optionsJson, "alignToPixels", alignToPixels);
        Util.addToJson(optionsJson, "backgroundColor", backgroundColor);
        Util.addToJson(optionsJson, "display", display);
        Util.addToJson(optionsJson, "min", min);
        Util.addToJson(optionsJson, "max", max);
        Util.addToJson(optionsJson, "suggestedMin", suggestedMin);
        Util.addToJson(optionsJson, "suggestedMax", suggestedMax);
        Util.addToJson(optionsJson, "reverse", reverse);
        Util.addToJson(optionsJson, "stacked", stacked);
        Util.addToJson(optionsJson, "weight", weight);
        Util.addToJson(optionsJson, "position", position);
        Util.addToJson(optionsJson, "beginAtZero", beginAtZero);
        Util.addToJson(optionsJson, "stepSize", stepSize);
        return optionsJson;
    }
}
