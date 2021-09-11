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
                JSONObject chartDataset = new JSONObject();
                if (genericDataset instanceof BarChartDataset) {
                    BarChartDataset castedDataset = ((BarChartDataset) genericDataset);
                    if (castedDataset.getLabel() != null) chartDataset.put("label", castedDataset.getLabel());
                    if (castedDataset.getData() != null) chartDataset.put("data", castedDataset.getData());
                    // TODO: Add other attributes
                    // TODO: GitHub Repo
                }
                chartDatasets.put(chartDataset);
            }
            chartData.put("datasets", chartDatasets);
        }
        return chartData;
    }
}
