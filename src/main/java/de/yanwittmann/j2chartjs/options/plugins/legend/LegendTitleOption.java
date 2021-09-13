package de.yanwittmann.j2chartjs.options.plugins.legend;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.j2chartjs.type.ChartFont;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;

public class LegendTitleOption extends AbstractChartOption {

    /**
     * Whether the title should be displayed.
     */
    private Boolean display;
    /**
     * Color of text.
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
     * The title text
     */
    private String text;

    public Boolean getDisplay() {
        return display;
    }

    public LegendTitleOption setDisplay(Boolean display) {
        this.display = display;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public LegendTitleOption setColor(Color color) {
        this.color = color;
        return this;
    }

    public ChartFont getFont() {
        return font;
    }

    public LegendTitleOption setFont(ChartFont font) {
        this.font = font;
        return this;
    }

    public Integer getPadding() {
        return padding;
    }

    public LegendTitleOption setPadding(Integer padding) {
        this.padding = padding;
        return this;
    }

    public String getText() {
        return text;
    }

    public LegendTitleOption setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject optionsJson = new JSONObject();
        Util.addToJson(optionsJson, "display", display);
        Util.addToJson(optionsJson, "color", color);
        Util.addToJson(optionsJson, "font", font);
        Util.addToJson(optionsJson, "padding", padding);
        Util.addToJson(optionsJson, "text", text);
        return optionsJson;
    }
}
