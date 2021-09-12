package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.LineChartData;
import de.yanwittmann.j2chartjs.dataset.LineChartDataset;

import java.math.BigDecimal;

public class LineChart extends Chart<LineChart, LineChartData, LineChartDataset, BigDecimal> {
    public LineChart() {
        super("line");
    }
}
