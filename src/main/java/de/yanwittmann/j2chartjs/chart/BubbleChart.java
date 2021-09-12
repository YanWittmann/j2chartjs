package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.BubbleChartData;
import de.yanwittmann.j2chartjs.datapoint.BubbleChartDatapoint;
import de.yanwittmann.j2chartjs.dataset.BubbleChartDataset;

public class BubbleChart extends Chart<BubbleChart, BubbleChartData, BubbleChartDataset, BubbleChartDatapoint> {
    public BubbleChart() {
        super("bubble");
    }
}
