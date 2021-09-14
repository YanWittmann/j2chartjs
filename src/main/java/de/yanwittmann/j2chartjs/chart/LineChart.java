package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.LineChartData;
import de.yanwittmann.j2chartjs.dataset.LineChartDataset;

public class LineChart extends Chart<LineChart, LineChartData, LineChartDataset, Number> {
    public LineChart() {
        super("line");
    }
}
