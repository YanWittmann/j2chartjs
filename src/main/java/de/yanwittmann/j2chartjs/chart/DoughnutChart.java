package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.DoughnutPieChartData;
import de.yanwittmann.j2chartjs.dataset.DoughnutPieChartDataset;

import java.math.BigDecimal;

public class DoughnutChart extends Chart<DoughnutChart, DoughnutPieChartData, DoughnutPieChartDataset, BigDecimal> {
    public DoughnutChart() {
        super("doughnut");
    }
}
