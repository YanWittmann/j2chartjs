package de.yanwittmann.j2chartjs.data;

import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import de.yanwittmann.j2chartjs.dataset.LineChartDataset;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;

public class LineChartData extends ChartData<LineChartData, LineChartDataset, BigDecimal> {

    @Override
    public JSONObject toJson() {
        JSONObject chartData = new JSONObject();
        chartData.put("labels", getLabels());
        if (datasets != null) {
            JSONArray chartDatasets = new JSONArray();
            for (ChartDataset<LineChartDataset, BigDecimal> genericDataset : datasets) {
                chartDatasets.put(genericDataset.toJson());
            }
            chartData.put("datasets", chartDatasets);
        }
        return chartData;
    }
}
