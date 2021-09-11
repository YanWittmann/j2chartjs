package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.BarChartData;
import de.yanwittmann.j2chartjs.dataset.BarChartDataset;
import org.json.JSONObject;

import java.math.BigDecimal;

public class BarChart extends Chart<BarChartData, BarChartDataset, BigDecimal> {

    public BarChart() {
        super("bar");
    }

    @Override
    public JSONObject toJson() {
        JSONObject chartDefinition = new JSONObject();
        chartDefinition.put("type", typeIdentifier);
        if (chartData != null) chartDefinition.put("data", chartData.toJson());
        return chartDefinition;
    }
}
