package de.yanwittmann.j2chartjs.options.scale;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;

public class ScaleOption extends AbstractChartOption {

    /**
     * Options regarding the scale ticks.
     */
    private ScaleTicksOption ticks;
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
     * Example: <code>linear</code>
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

    public ScaleTicksOption getTicks() {
        return ticks;
    }

    public ScaleOption setTicks(ScaleTicksOption ticks) {
        this.ticks = ticks;
        return this;
    }

    public ScaleGridOption getGrid() {
        return grid;
    }

    public ScaleOption setGrid(ScaleGridOption grid) {
        this.grid = grid;
        return this;
    }

    public ScaleTitleOption getTitle() {
        return title;
    }

    public ScaleOption setTitle(ScaleTitleOption title) {
        this.title = title;
        return this;
    }

    public String getType() {
        return type;
    }

    public ScaleOption setType(String type) {
        this.type = type;
        return this;
    }

    public Boolean getAlignToPixels() {
        return alignToPixels;
    }

    public ScaleOption setAlignToPixels(Boolean alignToPixels) {
        this.alignToPixels = alignToPixels;
        return this;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public ScaleOption setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Boolean getDisplay() {
        return display;
    }

    public ScaleOption setDisplay(Boolean display) {
        this.display = display;
        return this;
    }

    public Integer getMin() {
        return min;
    }

    public ScaleOption setMin(Integer min) {
        this.min = min;
        return this;
    }

    public Integer getMax() {
        return max;
    }

    public ScaleOption setMax(Integer max) {
        this.max = max;
        return this;
    }

    public Integer getSuggestedMin() {
        return suggestedMin;
    }

    public ScaleOption setSuggestedMin(Integer suggestedMin) {
        this.suggestedMin = suggestedMin;
        return this;
    }

    public Integer getSuggestedMax() {
        return suggestedMax;
    }

    public ScaleOption setSuggestedMax(Integer suggestedMax) {
        this.suggestedMax = suggestedMax;
        return this;
    }

    public Boolean getReverse() {
        return reverse;
    }

    public ScaleOption setReverse(Boolean reverse) {
        this.reverse = reverse;
        return this;
    }

    public Boolean getStacked() {
        return stacked;
    }

    public ScaleOption setStacked(Boolean stacked) {
        this.stacked = stacked;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public ScaleOption setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public ScaleOption setPosition(String position) {
        this.position = position;
        return this;
    }

    public Boolean getBeginAtZero() {
        return beginAtZero;
    }

    public ScaleOption setBeginAtZero(Boolean beginAtZero) {
        this.beginAtZero = beginAtZero;
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject optionsJson = new JSONObject();
        if (ticks != null) optionsJson.put("ticks", ticks.toJson());
        if (grid != null) optionsJson.put("grid", grid.toJson());
        if (title != null) optionsJson.put("title", title.toJson());
        if (type != null) optionsJson.put("type", type);
        if (alignToPixels != null) optionsJson.put("alignToPixels", alignToPixels);
        if (backgroundColor != null) optionsJson.put("backgroundColor", Util.convertColorToJs(backgroundColor));
        if (display != null) optionsJson.put("display", display);
        if (min != null) optionsJson.put("min", min);
        if (max != null) optionsJson.put("max", max);
        if (suggestedMin != null) optionsJson.put("suggestedMin", suggestedMin);
        if (suggestedMax != null) optionsJson.put("suggestedMax", suggestedMax);
        if (reverse != null) optionsJson.put("reverse", reverse);
        if (stacked != null) optionsJson.put("stacked", stacked);
        if (weight != null) optionsJson.put("weight", weight);
        if (position != null) optionsJson.put("position", position);
        if (beginAtZero != null) optionsJson.put("beginAtZero", beginAtZero);
        return optionsJson;
    }
}
