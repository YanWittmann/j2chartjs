package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.ScatterChartData;
import de.yanwittmann.j2chartjs.dataset.ScatterChartDataset;
import de.yanwittmann.j2chartjs.type.ScatterChartDatapoint;

public class ScatterChart extends Chart<ScatterChart, ScatterChartData, ScatterChartDataset, ScatterChartDatapoint> {
    public ScatterChart() {
        super("scatter");
    }
}
