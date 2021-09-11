package de.yanwittmann.j2chartjs.type;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
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

    @Override
    public JSONObject toJson() {
        JSONObject mainPaddingJson = new JSONObject();
        if (paddingTop != null && paddingTop.equals(paddingBottom) && paddingTop.equals(paddingRight) && paddingTop.equals(paddingLeft)) {
            mainPaddingJson.put("padding", paddingTop);
        } else if (paddingTop != null || paddingBottom != null || paddingRight != null || paddingLeft != null) {
            JSONObject paddingJson = new JSONObject();
            if (paddingTop != null) paddingJson.put("top", paddingTop);
            if (paddingBottom != null) paddingJson.put("bottom", paddingBottom);
            if (paddingRight != null) paddingJson.put("right", paddingRight);
            if (paddingLeft != null) paddingJson.put("left", paddingLeft);
            mainPaddingJson.put("padding", paddingJson);
        }
        return mainPaddingJson;
    }
}
