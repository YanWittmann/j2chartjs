package de.yanwittmann.j2chartjs.data;

import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import de.yanwittmann.j2chartjs.dataset.PolarAreaChartDataset;
import de.yanwittmann.j2chartjs.preset.ChartColors;

import java.math.BigDecimal;

public class PolarAreaChartData extends ChartData<PolarAreaChartData, PolarAreaChartDataset, BigDecimal> {
    @Override
    public PolarAreaChartData applyDefaultStyle() {
        for (ChartDataset<PolarAreaChartDataset, BigDecimal> dataset : datasets) {
            if (dataset instanceof PolarAreaChartDataset) {
                ((PolarAreaChartDataset) dataset)
                        .setBackgroundColor(ChartColors.BACKGROUNDS)
                        .setBorderColor(ChartColors.BORDERS);
            }
        }
        return this;
    }
}
