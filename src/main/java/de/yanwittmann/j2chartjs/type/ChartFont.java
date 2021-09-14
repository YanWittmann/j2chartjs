package de.yanwittmann.j2chartjs.type;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

public class ChartFont extends AbstractChartOption {

    /**
     * Default font family for all text, follows CSS font-family options.
     */
    private String family;
    /**
     * Default font size (in px) for text. Does not apply to radialLinear scale point labels.
     */
    private Integer size;
    /**
     * Default font style. (default: <code>normal</code>)<br>
     * Does not apply to tooltip title or footer. Does not apply to chart title.<br>
     * Follows CSS font-style options (i.e. normal, italic, oblique, initial, inherit).
     */
    private String style;
    /**
     * Default font weight (boldness). Can either be <code>0-1000</code> or strings such as <code>normal</code>.
     */
    private String weight;
    /**
     * Height of an individual line of text.
     */
    private Number lineHeight;

    public String getFamily() {
        return family;
    }

    public ChartFont setFamily(String family) {
        this.family = family;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public ChartFont setSize(Integer size) {
        this.size = size;
        return this;
    }

    public String getStyle() {
        return style;
    }

    public ChartFont setStyle(String style) {
        this.style = style;
        return this;
    }

    public String getWeight() {
        return weight;
    }

    public ChartFont setWeight(String weight) {
        this.weight = weight;
        return this;
    }

    public Number getLineHeight() {
        return lineHeight;
    }

    public ChartFont setLineHeight(int lineHeight) {
        this.lineHeight = lineHeight;
        return this;
    }

    public ChartFont setLineHeight(double lineHeight) {
        this.lineHeight = lineHeight;
        return this;
    }

    public ChartFont setLineHeight(Number lineHeight) {
        this.lineHeight = lineHeight;
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject fontJson = new JSONObject();
        Util.addToJson(fontJson, "family", family);
        Util.addToJson(fontJson, "size", size);
        Util.addToJson(fontJson, "style", style);
        Util.addToJson(fontJson, "weight", weight);
        Util.addToJson(fontJson, "lineHeight", lineHeight);
        return fontJson;
    }
}
