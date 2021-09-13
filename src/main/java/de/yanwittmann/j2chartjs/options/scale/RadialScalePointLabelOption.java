package de.yanwittmann.j2chartjs.options.scale;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.j2chartjs.type.ChartFont;
import de.yanwittmann.j2chartjs.type.ChartPadding;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;

public class RadialScalePointLabelOption extends AbstractChartOption {

    /**
     * Background color of the point label.
     */
    private Color backdropColor;
    /**
     * Padding of label backdrop.
     */
    private ChartPadding backdropPadding;
    /**
     * If true, point labels are shown.
     */
    private Boolean display;
    /**
     * Color of label.
     */
    private Color color;
    /**
     * Font of label.
     */
    private ChartFont font;
    /**
     * Padding between chart and point labels.
     */
    private Integer padding;

    public Color getBackdropColor() {
        return backdropColor;
    }

    public RadialScalePointLabelOption setBackdropColor(Color backdropColor) {
        this.backdropColor = backdropColor;
        return this;
    }

    public RadialScalePointLabelOption setBackdropPadding(ChartPadding backdropPadding) {
        this.backdropPadding = backdropPadding;
        return this;
    }

    public Boolean getDisplay() {
        return display;
    }

    public RadialScalePointLabelOption setDisplay(Boolean display) {
        this.display = display;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public RadialScalePointLabelOption setColor(Color color) {
        this.color = color;
        return this;
    }

    public ChartFont getFont() {
        return font;
    }

    public RadialScalePointLabelOption setFont(ChartFont font) {
        this.font = font;
        return this;
    }

    public Integer getPadding() {
        return padding;
    }

    public RadialScalePointLabelOption setPadding(Integer padding) {
        this.padding = padding;
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject optionsJson = new JSONObject();
        Util.addToJson(optionsJson, "backdropColor", backdropColor);
        if (backdropPadding != null) {
            if (backdropPadding.isIdentical())
                optionsJson.put("backdropPadding", backdropPadding.getPaddingBottom());
            else Util.addToJson(optionsJson, "backdropPadding", backdropPadding);
        }
        Util.addToJson(optionsJson, "display", display);
        Util.addToJson(optionsJson, "color", color);
        Util.addToJson(optionsJson, "font", font);
        Util.addToJson(optionsJson, "padding", padding);
        return optionsJson;
    }
}
