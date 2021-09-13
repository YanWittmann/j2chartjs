package de.yanwittmann.j2chartjs.options.plugins.legend;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

public class LegendOption extends AbstractChartOption {

    /**
     * Whether the legend is shown or not.
     */
    private Boolean display;
    /**
     * Position of the legend.<ul>
     * <li><code>top</code></li>
     * <li><code>left</code></li>
     * <li><code>bottom</code></li>
     * <li><code>right</code></li>
     * <li><code>chartArea</code> (the legend position is at the moment not configurable, it will always be on the left side of the chart in the middle)</li>
     * </ul>
     */
    private String position;
    /**
     * Alignment of the legend.<ul>
     * <li><code>center</code> (default)</li>
     * <li><code>start</code></li>
     * <li><code>end</code></li>
     * </ul>
     */
    private String align;
    /**
     * Maximum height of the legend, in pixels.
     */
    private Integer maxHeight;
    /**
     * Maximum width of the legend, in pixels.
     */
    private Integer maxWidth;
    /**
     * Marks that this box should take the full width/height of the canvas (moving other boxes). This is unlikely to need to be changed in day-to-day use.
     */
    private Boolean fullSize;
    /**
     * Legend will show datasets in reverse order.
     */
    private Boolean reverse;
    /**
     * <code>true</code> for rendering the legends from right to left.
     */
    private Boolean rtl;
    /**
     * This will force the text direction 'rtl' or 'ltr' on the canvas for rendering the legend, regardless of the css specified on the canvas.
     */
    private String textDirection;
    /**
     * Settings for the labels.
     */
    private LegendLabelsOption labelsOption;
    /**
     * Settings for the title.
     */
    private LegendTitleOption titleOption;

    public Boolean getDisplay() {
        return display;
    }

    public LegendOption setDisplay(Boolean display) {
        this.display = display;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public LegendOption setPosition(String position) {
        this.position = position;
        return this;
    }

    public String getAlign() {
        return align;
    }

    public LegendOption setAlign(String align) {
        this.align = align;
        return this;
    }

    public Integer getMaxHeight() {
        return maxHeight;
    }

    public LegendOption setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
        return this;
    }

    public Integer getMaxWidth() {
        return maxWidth;
    }

    public LegendOption setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
        return this;
    }

    public Boolean getFullSize() {
        return fullSize;
    }

    public LegendOption setFullSize(Boolean fullSize) {
        this.fullSize = fullSize;
        return this;
    }

    public Boolean getReverse() {
        return reverse;
    }

    public LegendOption setReverse(Boolean reverse) {
        this.reverse = reverse;
        return this;
    }

    public Boolean getRtl() {
        return rtl;
    }

    public LegendOption setRtl(Boolean rtl) {
        this.rtl = rtl;
        return this;
    }

    public String getTextDirection() {
        return textDirection;
    }

    public LegendOption setTextDirection(String textDirection) {
        this.textDirection = textDirection;
        return this;
    }

    public LegendLabelsOption getLabelsOption() {
        return labelsOption;
    }

    public LegendOption setLabelsOption(LegendLabelsOption labelsOption) {
        this.labelsOption = labelsOption;
        return this;
    }

    public LegendTitleOption getTitleOption() {
        return titleOption;
    }

    public LegendOption setTitleOption(LegendTitleOption titleOption) {
        this.titleOption = titleOption;
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject optionsJson = new JSONObject();
        Util.addToJson(optionsJson, "display", display);
        Util.addToJson(optionsJson, "position", position);
        Util.addToJson(optionsJson, "align", align);
        Util.addToJson(optionsJson, "maxHeight", maxHeight);
        Util.addToJson(optionsJson, "display", maxWidth);
        Util.addToJson(optionsJson, "fullSize", fullSize);
        Util.addToJson(optionsJson, "reverse", reverse);
        Util.addToJson(optionsJson, "rtl", rtl);
        Util.addToJson(optionsJson, "textDirection", textDirection);
        Util.addToJson(optionsJson, "labels", labelsOption);
        Util.addToJson(optionsJson, "title", titleOption);
        return optionsJson;
    }
}
