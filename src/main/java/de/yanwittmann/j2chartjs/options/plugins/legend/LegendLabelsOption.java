package de.yanwittmann.j2chartjs.options.plugins.legend;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.j2chartjs.type.ChartFont;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;

public class LegendLabelsOption extends AbstractChartOption {

    /**
     * Width of coloured box.
     */
    private Integer boxWidth;
    /**
     * Height of the coloured box.
     */
    private Integer boxHeight;
    /**
     * Color of label and the strikethrough.
     */
    private Color color;
    /**
     * The label font. See <a href="https://www.chartjs.org/docs/next/general/fonts.html">fonts</a>.
     */
    private ChartFont font;
    /**
     * Padding between rows of colored boxes.
     */
    private Integer padding;
    /**
     * Horizontal alignment of the label text.<ul>
     * <li>left</li>
     * <li>right</li>
     * <li>center</li>
     * </ul>
     */
    private Integer textAlign;

    public Integer getBoxWidth() {
        return boxWidth;
    }

    public LegendLabelsOption setBoxWidth(Integer boxWidth) {
        this.boxWidth = boxWidth;
        return this;
    }

    public Integer getBoxHeight() {
        return boxHeight;
    }

    public LegendLabelsOption setBoxHeight(Integer boxHeight) {
        this.boxHeight = boxHeight;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public LegendLabelsOption setColor(Color color) {
        this.color = color;
        return this;
    }

    public ChartFont getFont() {
        return font;
    }

    public LegendLabelsOption setFont(ChartFont font) {
        this.font = font;
        return this;
    }

    public Integer getPadding() {
        return padding;
    }

    public LegendLabelsOption setPadding(Integer padding) {
        this.padding = padding;
        return this;
    }

    public Integer getTextAlign() {
        return textAlign;
    }

    public LegendLabelsOption setTextAlign(Integer textAlign) {
        this.textAlign = textAlign;
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject optionsJson = new JSONObject();
        Util.addToJson(optionsJson, "boxWidth", boxWidth);
        Util.addToJson(optionsJson, "boxHeight", boxHeight);
        Util.addToJson(optionsJson, "color", color);
        Util.addToJson(optionsJson, "font", font);
        Util.addToJson(optionsJson, "padding", padding);
        Util.addToJson(optionsJson, "textAlign", textAlign);
        return optionsJson;
    }
}
