package de.yanwittmann.j2chartjs.options.plugins.tooltip;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import org.json.JSONObject;

public class TooltipOption extends AbstractChartOption {
    @Override
    public JSONObject toJson() {
        JSONObject optionsJson = new JSONObject();
        //if (family != null) optionsJson.put("family", family);
        return optionsJson;
    }
}
