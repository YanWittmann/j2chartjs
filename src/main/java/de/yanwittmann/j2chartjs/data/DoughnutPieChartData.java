package de.yanwittmann.j2chartjs.data;

import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import de.yanwittmann.j2chartjs.dataset.DoughnutPieChartDataset;
import de.yanwittmann.j2chartjs.preset.ChartColors;

public class DoughnutPieChartData extends ChartData<DoughnutPieChartData, DoughnutPieChartDataset, Number> {
    @Override
    public DoughnutPieChartData applyDefaultStylePerDatapoint() {
        for (ChartDataset<DoughnutPieChartDataset, Number> dataset : datasets) {
            if (dataset instanceof DoughnutPieChartDataset) {
                ((DoughnutPieChartDataset) dataset)
                        .setBackgroundColor(ChartColors.BACKGROUNDS)
                        .setBorderColor(ChartColors.BORDERS);
            }
        }
        return this;
    }

    @Override
    public DoughnutPieChartData applyDefaultStylePerDataset() {
        int colorIndex = 0;
        for (ChartDataset<DoughnutPieChartDataset, Number> dataset : datasets) {
            if (dataset instanceof DoughnutPieChartDataset) {
                ((DoughnutPieChartDataset) dataset)
                        .addBackgroundColor(ChartColors.BACKGROUNDS.get(colorIndex % ChartColors.BACKGROUNDS.size()))
                        .addBorderColor(ChartColors.BORDERS.get(colorIndex % ChartColors.BORDERS.size()));
                colorIndex++;
            }
        }
        return this;
    }
}
