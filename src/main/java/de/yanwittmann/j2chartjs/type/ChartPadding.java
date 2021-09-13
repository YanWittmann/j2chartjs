package de.yanwittmann.j2chartjs.type;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

@SuppressWarnings("unchecked")
public class ChartPadding extends AbstractChartOption {

    private Integer paddingTop;
    private Integer paddingBottom;
    private Integer paddingRight;
    private Integer paddingLeft;

    public ChartPadding setPadding(Integer padding) {
        setPaddingTop(padding);
        setPaddingBottom(padding);
        setPaddingRight(padding);
        return setPaddingLeft(padding);
    }

    public ChartPadding setPaddingTop(Integer paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    public ChartPadding setPaddingBottom(Integer paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    public ChartPadding setPaddingRight(Integer paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    public ChartPadding setPaddingLeft(Integer paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    public boolean isIdentical() {
        return paddingTop != null && paddingTop.equals(paddingBottom) && paddingTop.equals(paddingRight) && paddingTop.equals(paddingLeft);
    }

    public Integer getPaddingBottom() {
        return paddingBottom;
    }

    @Override
    public JSONObject toJson() {
        JSONObject mainPaddingJson = new JSONObject();
        if (isIdentical()) {
            mainPaddingJson.put("padding", paddingTop);
        } else if (paddingTop != null || paddingBottom != null || paddingRight != null || paddingLeft != null) {
            JSONObject paddingJson = new JSONObject();
            Util.addToJson(paddingJson, "top", paddingTop);
            Util.addToJson(paddingJson, "bottom", paddingBottom);
            Util.addToJson(paddingJson, "right", paddingRight);
            Util.addToJson(paddingJson, "left", paddingLeft);
            mainPaddingJson.put("padding", paddingJson);
        }
        return mainPaddingJson;
    }
}
