package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.BarChartData;
import de.yanwittmann.j2chartjs.dataset.BarChartDataset;

import java.math.BigDecimal;

public class BarChart extends Chart<BarChart, BarChartData, BarChartDataset, BigDecimal> {
    public BarChart() {
        super("bar");
    }
}
