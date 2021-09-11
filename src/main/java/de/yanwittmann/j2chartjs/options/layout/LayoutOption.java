package de.yanwittmann.j2chartjs.options.layout;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import org.json.JSONObject;

public class LayoutOption extends AbstractChartOption {

    private Integer paddingTop;
    private Integer paddingBottom;
    private Integer paddingRight;
    private Integer paddingLeft;

    public LayoutOption setPadding(Integer padding) {
        setPaddingTop(padding);
        setPaddingBottom(padding);
        setPaddingRight(padding);
        return setPaddingLeft(padding);
    }

    public LayoutOption setPaddingTop(Integer paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    public LayoutOption setPaddingBottom(Integer paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    public LayoutOption setPaddingRight(Integer paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    public LayoutOption setPaddingLeft(Integer paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject optionsJson = new JSONObject();
        if (paddingTop != null && paddingTop.equals(paddingBottom) && paddingTop.equals(paddingRight) && paddingTop.equals(paddingLeft)) {
            optionsJson.put("padding", paddingTop);
        } else if (paddingTop != null || paddingBottom != null || paddingRight != null || paddingLeft != null) {
            JSONObject paddingJson = new JSONObject();
            if (paddingTop != null) paddingJson.put("top", paddingTop);
            if (paddingBottom != null) paddingJson.put("bottom", paddingBottom);
            if (paddingRight != null) paddingJson.put("right", paddingRight);
            if (paddingLeft != null) paddingJson.put("left", paddingLeft);
            optionsJson.put("padding", paddingJson);
        }
        return optionsJson;
    }
}
