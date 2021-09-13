package de.yanwittmann.j2chartjs.data;

import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import de.yanwittmann.j2chartjs.dataset.DoughnutPieChartDataset;
import de.yanwittmann.j2chartjs.preset.ChartColors;

import java.math.BigDecimal;

public class DoughnutPieChartData extends ChartData<DoughnutPieChartData, DoughnutPieChartDataset, BigDecimal> {
    @Override
    public DoughnutPieChartData applyDefaultStylePerDatapoint() {
        for (ChartDataset<DoughnutPieChartDataset, BigDecimal> dataset : datasets) {
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
        for (ChartDataset<DoughnutPieChartDataset, BigDecimal> dataset : datasets) {
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
