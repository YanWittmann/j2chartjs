package de.yanwittmann.j2chartjs.data;

import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import de.yanwittmann.j2chartjs.dataset.RadarChartDataset;
import de.yanwittmann.j2chartjs.preset.ChartColors;

public class RadarChartData extends ChartData<RadarChartData, RadarChartDataset, Number> {
    @Override
    public RadarChartData applyDefaultStylePerDatapoint() {
        int colorIndex = 0;
        for (ChartDataset<RadarChartDataset, Number> dataset : datasets) {
            if (dataset instanceof RadarChartDataset) {
                ((RadarChartDataset) dataset)
                        .setBackgroundColor(ChartColors.BACKGROUNDS.get(colorIndex % ChartColors.BACKGROUNDS.size()))
                        .setBorderColor(ChartColors.BORDERS.get(colorIndex % ChartColors.BORDERS.size()));
                colorIndex++;
            }
        }
        return this;
    }

    @Override
    public RadarChartData applyDefaultStylePerDataset() {
        int colorIndex = 0;
        for (ChartDataset<RadarChartDataset, Number> dataset : datasets) {
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
