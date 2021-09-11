package de.yanwittmann.j2chartjs.options;

import org.json.JSONObject;

public class ChartOptions extends AbstractChartOptions {

    private AbstractChartOptions scales;
    private AbstractChartOptions plugins;

    public void setScales(ScaleOptions scales) {
        this.scales = scales;
    }

    @Override
    public JSONObject toJson() {
        JSONObject optionsJson = new JSONObject();
        if (scales != null) optionsJson.put("scales", scales.toJson());
        if (plugins != null) optionsJson.put("plugins", plugins.toJson());
        return optionsJson;
    }
}
