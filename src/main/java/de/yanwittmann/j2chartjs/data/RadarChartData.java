package de.yanwittmann.j2chartjs.data;

import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import de.yanwittmann.j2chartjs.dataset.RadarChartDataset;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;

public class RadarChartData extends ChartData<RadarChartData, RadarChartDataset, BigDecimal> {

    @Override
    public JSONObject toJson() {
        JSONObject chartData = new JSONObject();
        chartData.put("labels", getLabels());
        if (datasets != null) {
            JSONArray chartDatasets = new JSONArray();
            for (ChartDataset<RadarChartDataset, BigDecimal> genericDataset : datasets) {
                chartDatasets.put(genericDataset.toJson());
            }
            chartData.put("datasets", chartDatasets);
        }
        return chartData;
    }
}
