package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.DoughnutPieChartData;
import de.yanwittmann.j2chartjs.dataset.DoughnutPieChartDataset;

public class PieChart extends Chart<PieChart, DoughnutPieChartData, DoughnutPieChartDataset, Number> {
    public PieChart() {
        super("pie");
    }
}
