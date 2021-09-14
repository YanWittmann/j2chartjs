package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.BarChartData;
import de.yanwittmann.j2chartjs.dataset.BarChartDataset;

public class BarChart extends Chart<BarChart, BarChartData, BarChartDataset, Number> {
    public BarChart() {
        super("bar");
    }
}
