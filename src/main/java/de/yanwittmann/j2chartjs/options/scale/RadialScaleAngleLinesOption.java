package de.yanwittmann.j2chartjs.options.scale;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;
import java.util.List;

public class RadialScaleAngleLinesOption extends AbstractChartOption {

    /**
     * If true, show angle lines.
     */
    private Boolean display;
    /**
     * Color of angled lines.
     */
    private Color color;
    /**
     * Width of angled lines.
     */
    private Integer lineWidth;
    /**
     * Length and spacing of dashes on angle lines. See <a href="https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/setLineDash">MDN</a>.
     */
    private List<Integer> borderDash;
    /**
     * Offset for line dashes.
     */
    private Integer borderDashOffset;

    public Boolean getDisplay() {
        return display;
    }

    public RadialScaleAngleLinesOption setDisplay(Boolean display) {
        this.display = display;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public RadialScaleAngleLinesOption setColor(Color color) {
        this.color = color;
        return this;
    }

    public Integer getLineWidth() {
        return lineWidth;
    }

    public RadialScaleAngleLinesOption setLineWidth(Integer lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    public List<Integer> getBorderDash() {
        return borderDash;
    }

    public RadialScaleAngleLinesOption setBorderDash(List<Integer> borderDash) {
        this.borderDash = borderDash;
        return this;
    }

    public Integer getBorderDashOffset() {
        return borderDashOffset;
    }

    public RadialScaleAngleLinesOption setBorderDashOffset(Integer borderDashOffset) {
        this.borderDashOffset = borderDashOffset;
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject optionsJson = new JSONObject();
        Util.addToJson(optionsJson, "display", display);
        Util.addToJson(optionsJson, "color", color);
        Util.addToJson(optionsJson, "lineWidth", lineWidth);
        Util.addToJson(optionsJson, "borderDash", borderDash);
        Util.addToJson(optionsJson, "borderDashOffset", borderDashOffset);
        return optionsJson;
    }
}
