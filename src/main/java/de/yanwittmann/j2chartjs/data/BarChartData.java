package de.yanwittmann.j2chartjs.data;

import de.yanwittmann.j2chartjs.dataset.BarChartDataset;
import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import de.yanwittmann.j2chartjs.preset.ChartColors;

import java.math.BigDecimal;

public class BarChartData extends ChartData<BarChartData, BarChartDataset, BigDecimal> {
    @Override
    public BarChartData applyDefaultStyle() {
        for (ChartDataset<BarChartDataset, BigDecimal> dataset : datasets) {
            if (dataset instanceof BarChartDataset) {
                ((BarChartDataset) dataset)
                        .setBackgroundColor(ChartColors.BACKGROUNDS)
                        .setBorderColor(ChartColors.BORDERS);
            }
        }
        return this;
    }
}
