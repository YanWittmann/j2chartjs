package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.DoughnutPieChartData;
import de.yanwittmann.j2chartjs.dataset.DoughnutPieChartDataset;

import java.math.BigDecimal;

public class PieChart extends Chart<PieChart, DoughnutPieChartData, DoughnutPieChartDataset, BigDecimal> {
    public PieChart() {
        super("pie");
    }
}
