package de.yanwittmann.j2chartjs.data;

import de.yanwittmann.j2chartjs.dataset.BarChartDataset;
import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;

public class BarChartData extends ChartData<BarChartData, BarChartDataset, BigDecimal> {

    @Override
    public JSONObject toJson() {
        JSONObject chartData = new JSONObject();
        chartData.put("labels", getLabels());
        if (datasets != null) {
            JSONArray chartDatasets = new JSONArray();
            for (ChartDataset<BarChartDataset, BigDecimal> genericDataset : datasets) {
                chartDatasets.put(genericDataset.toJson());
            }
            chartData.put("datasets", chartDatasets);
        }
        return chartData;
    }
}
