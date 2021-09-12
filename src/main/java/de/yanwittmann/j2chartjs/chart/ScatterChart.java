package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.ScatterChartData;
import de.yanwittmann.j2chartjs.datapoint.ScatterChartDatapoint;
import de.yanwittmann.j2chartjs.dataset.ScatterChartDataset;

public class ScatterChart extends Chart<ScatterChart, ScatterChartData, ScatterChartDataset, ScatterChartDatapoint> {
    public ScatterChart() {
        super("scatter");
    }
}
