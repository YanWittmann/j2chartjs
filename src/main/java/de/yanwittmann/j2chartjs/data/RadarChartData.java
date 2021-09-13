package de.yanwittmann.j2chartjs.data;

import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import de.yanwittmann.j2chartjs.dataset.RadarChartDataset;
import de.yanwittmann.j2chartjs.preset.ChartColors;

import java.math.BigDecimal;

public class RadarChartData extends ChartData<RadarChartData, RadarChartDataset, BigDecimal> {
    @Override
    public RadarChartData applyDefaultStyle() {
        int colorIndex = 0;
        for (ChartDataset<RadarChartDataset, BigDecimal> dataset : datasets) {
            if (dataset instanceof RadarChartDataset) {
                ((RadarChartDataset) dataset)
                        .setBackgroundColor(ChartColors.BACKGROUNDS.get(colorIndex % ChartColors.BACKGROUNDS.size()))
                        .setBorderColor(ChartColors.BORDERS.get(colorIndex % ChartColors.BORDERS.size()));
                colorIndex++;
            }
        }
        return this;
    }
}
