package de.yanwittmann.j2chartjs.data;

import de.yanwittmann.j2chartjs.dataset.BarChartDataset;
import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import de.yanwittmann.j2chartjs.preset.ChartColors;

public class BarChartData extends ChartData<BarChartData, BarChartDataset, Number> {
    @Override
    public BarChartData applyDefaultStylePerDatapoint() {
        for (ChartDataset<BarChartDataset, Number> dataset : datasets) {
            if (dataset instanceof BarChartDataset) {
                ((BarChartDataset) dataset)
                        .setBackgroundColor(ChartColors.BACKGROUNDS)
                        .setBorderColor(ChartColors.BORDERS)
                        .addHoverBorderWidth(2)
                        .addBorderWidth(1);
            }
        }
        return this;
    }

    @Override
    public BarChartData applyDefaultStylePerDataset() {
        int colorIndex = 0;
        for (ChartDataset<BarChartDataset, Number> dataset : datasets) {
            if (dataset instanceof BarChartDataset) {
                ((BarChartDataset) dataset)
                        .addBackgroundColor(ChartColors.BACKGROUNDS.get(colorIndex % ChartColors.BACKGROUNDS.size()))
                        .addBorderColor(ChartColors.BORDERS.get(colorIndex % ChartColors.BORDERS.size()))
                        .addHoverBorderWidth(2)
                        .addBorderWidth(1);
                colorIndex++;
            }
        }
        return this;
    }
}
