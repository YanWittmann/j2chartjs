package de.yanwittmann.j2chartjs.options.plugins.title;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.j2chartjs.type.ChartFont;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class TitleOption extends AbstractChartOption {

    /**
     * Alignment of the title.<ul>
     * <li>center (default)</li>
     * <li>start</li>
     * <li>end</li>
     * </ul>
     */
    private String align;
    /**
     * Position of the title.<ul>
     * <li>top</li>
     * <li>left</li>
     * <li>bottom</li>
     * <li>right</li>
     * </ul>
     */
    private String position;
    /**
     * Color of text.
     */
    private Color color;
    /**
     * Whether the title should be displayed.
     */
    private Boolean display;
    /**
     * Marks that this box should take the full width/height of the canvas. If false, the box is sized and placed above/beside the chart area.
     */
    private Boolean fullSize;
    /**
     * The label font. See <a href="https://www.chartjs.org/docs/next/general/fonts.html">fonts</a>.
     */
    private ChartFont font;
    /**
     * Padding between rows of colored boxes.
     */
    private Integer padding;
    /**
     * The title text.
     */
    private List<String> text;

    public String getAlign() {
        return align;
    }

    public TitleOption setAlign(String align) {
        this.align = align;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public TitleOption setPosition(String position) {
        this.position = position;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public TitleOption setColor(Color color) {
        this.color = color;
        return this;
    }

    public Boolean getDisplay() {
        return display;
    }

    public TitleOption setDisplay(Boolean display) {
        this.display = display;
        return this;
    }

    public Boolean getFullSize() {
        return fullSize;
    }

    public TitleOption setFullSize(Boolean fullSize) {
        this.fullSize = fullSize;
        return this;
    }

    public ChartFont getFont() {
        return font;
    }

    public TitleOption setFont(ChartFont font) {
        this.font = font;
        return this;
    }

    public Integer getPadding() {
        return padding;
    }

    public TitleOption setPadding(Integer padding) {
        this.padding = padding;
        return this;
    }

    public List<String> getText() {
        return text;
    }

    public TitleOption setText(List<String> text) {
        this.text = text;
        return this;
    }

    public TitleOption setText(String... text) {
        this.text = Arrays.stream(text).collect(Collectors.toList());
        return this;
    }

    public TitleOption setText(String text) {
        this.text = Collections.singletonList(text);
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject optionsJson = new JSONObject();
        if (align != null) optionsJson.put("align", align);
        if (position != null) optionsJson.put("position", position);
        if (color != null) optionsJson.put("color", Util.convertColorToJs(color));
        if (display != null) optionsJson.put("display", display);
        if (fullSize != null) optionsJson.put("fullSize", fullSize);
        if (font != null) optionsJson.put("font", font.toJson());
        if (padding != null) optionsJson.put("padding", padding);
        if (text != null) optionsJson.put("text", text);
        return optionsJson;
    }
}
