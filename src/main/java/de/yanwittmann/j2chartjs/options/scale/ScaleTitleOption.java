package de.yanwittmann.j2chartjs.options.scale;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.j2chartjs.type.ChartFont;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;
import java.util.Collections;
import java.util.List;

public class ScaleTitleOption extends AbstractChartOption {

    /**
     * Whether to display the axis title.
     */
    private Boolean display;
    /**
     * Alignment of the axis title. <ul>
     * <li>center (default)</li>
     * <li>start</li>
     * <li>end</li>
     * </ul>
     */
    private String align;
    /**
     * The text for the title. Each entry will be a new line.
     */
    private List<String> text;
    /**
     * Color of the label.
     */
    private Color color;
    /**
     * Font of the label.
     */
    private ChartFont font;
    /**
     * Padding to apply around scale labels. (top and bottom)
     */
    private Integer padding;

    public Boolean getDisplay() {
        return display;
    }

    public ScaleTitleOption setDisplay(Boolean display) {
        this.display = display;
        return this;
    }

    public String getAlign() {
        return align;
    }

    public ScaleTitleOption setAlign(String align) {
        this.align = align;
        return this;
    }

    public List<String> getText() {
        return text;
    }

    public ScaleTitleOption setText(List<String> text) {
        this.text = text;
        return this;
    }

    public ScaleTitleOption setText(String text) {
        this.text = Collections.singletonList(text);
        return this;
    }

    public Color getColor() {
        return color;
    }

    public ScaleTitleOption setColor(Color color) {
        this.color = color;
        return this;
    }

    public ChartFont getFont() {
        return font;
    }

    public ScaleTitleOption setFont(ChartFont font) {
        this.font = font;
        return this;
    }

    public Integer getPadding() {
        return padding;
    }

    public ScaleTitleOption setPadding(Integer padding) {
        this.padding = padding;
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject optionsJson = new JSONObject();
        if (display != null) optionsJson.put("display", display);
        if (align != null) optionsJson.put("align", align);
        if (text != null) optionsJson.put("text", text);
        if (color != null) optionsJson.put("color", Util.convertColorToJs(color));
        if (font != null) optionsJson.put("font", font.toJson());
        if (padding != null) optionsJson.put("padding", padding);
        return optionsJson;
    }
}
