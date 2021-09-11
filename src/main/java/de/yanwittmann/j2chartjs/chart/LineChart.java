package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.LineChartData;
import de.yanwittmann.j2chartjs.dataset.LineChartDataset;
import org.json.JSONObject;

import java.math.BigDecimal;

public class LineChart extends Chart<LineChart, LineChartData, LineChartDataset, BigDecimal> {

    public LineChart() {
        super("line");
    }

    @Override
    public JSONObject toJson() {
        JSONObject chartDefinition = new JSONObject();
        chartDefinition.put("type", typeIdentifier);
        if (chartData != null) chartDefinition.put("data", chartData.toJson());
        if (chartOptions != null) chartDefinition.put("options", chartOptions.toJson());
        return chartDefinition;
    }
}
