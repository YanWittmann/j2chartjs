package de.yanwittmann.j2chartjs.data;

import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import de.yanwittmann.j2chartjs.dataset.DoughnutPieChartDataset;
import de.yanwittmann.j2chartjs.preset.ChartColors;

import java.math.BigDecimal;

public class DoughnutPieChartData extends ChartData<DoughnutPieChartData, DoughnutPieChartDataset, BigDecimal> {
    @Override
    public DoughnutPieChartData applyDefaultStyle() {
        for (ChartDataset<DoughnutPieChartDataset, BigDecimal> dataset : datasets) {
            if (dataset instanceof DoughnutPieChartDataset) {
                ((DoughnutPieChartDataset) dataset)
                        .setBackgroundColor(ChartColors.BACKGROUNDS)
                        .setBorderColor(ChartColors.BORDERS);
            }
        }
        return this;
    }
}
