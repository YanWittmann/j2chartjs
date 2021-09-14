package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.MixedChartData;
import de.yanwittmann.j2chartjs.options.ChartOptions;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

public class MixedChart {

    protected MixedChartData chartData;
    protected ChartOptions chartOptions;

    public MixedChart setChartData(MixedChartData chartData) {
        this.chartData = chartData;
        return this;
    }

    public MixedChart setChartOptions(ChartOptions chartOptions) {
        this.chartOptions = chartOptions;
        return this;
    }

    public MixedChartData getChartData() {
        return chartData;
    }

    public ChartOptions getChartOptions() {
        return chartOptions;
    }

    public JSONObject toJson() {
        JSONObject chartDefinition = new JSONObject();
        if (chartData != null) Util.addToJson(chartDefinition, "data", chartData);
        if (chartOptions != null) Util.addToJson(chartDefinition, "options", chartOptions);
        return chartDefinition;
    }

    @Override
    public String toString() {
        return toJson().toString();
    }
}
