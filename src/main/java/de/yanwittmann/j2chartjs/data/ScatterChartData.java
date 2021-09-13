package de.yanwittmann.j2chartjs.data;

import de.yanwittmann.j2chartjs.datapoint.ScatterChartDatapoint;
import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import de.yanwittmann.j2chartjs.dataset.ScatterChartDataset;
import de.yanwittmann.j2chartjs.preset.ChartColors;

public class ScatterChartData extends ChartData<ScatterChartData, ScatterChartDataset, ScatterChartDatapoint> {
    @Override
    public ScatterChartData applyDefaultStyle() {
        int colorIndex = 0;
        for (ChartDataset<ScatterChartDataset, ScatterChartDatapoint> dataset : datasets) {
            if (dataset instanceof ScatterChartDataset) {
                ((ScatterChartDataset) dataset)
                        .addBackgroundColor(ChartColors.BACKGROUNDS.get(colorIndex % ChartColors.BACKGROUNDS.size()))
                        .addBorderColor(ChartColors.BORDERS.get(colorIndex % ChartColors.BORDERS.size()));
                colorIndex++;
            }
        }
        return this;
    }
}
