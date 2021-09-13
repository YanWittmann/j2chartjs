package de.yanwittmann.j2chartjs.data;

import de.yanwittmann.j2chartjs.datapoint.BubbleChartDatapoint;
import de.yanwittmann.j2chartjs.dataset.BubbleChartDataset;
import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import de.yanwittmann.j2chartjs.preset.ChartColors;

public class BubbleChartData extends ChartData<BubbleChartData, BubbleChartDataset, BubbleChartDatapoint> {
    @Override
    public BubbleChartData applyDefaultStyle() {
        int colorIndex = 0;
        for (ChartDataset<BubbleChartDataset, BubbleChartDatapoint> dataset : datasets) {
            if (dataset instanceof BubbleChartDataset) {
                ((BubbleChartDataset) dataset)
                        .addBackgroundColor(ChartColors.BACKGROUNDS.get(colorIndex % ChartColors.BACKGROUNDS.size()))
                        .addBorderColor(ChartColors.BORDERS.get(colorIndex % ChartColors.BORDERS.size()));
                colorIndex++;
            }
        }
        return this;
    }
}
