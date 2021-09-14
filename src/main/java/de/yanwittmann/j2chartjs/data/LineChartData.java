package de.yanwittmann.j2chartjs.data;

import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import de.yanwittmann.j2chartjs.dataset.LineChartDataset;
import de.yanwittmann.j2chartjs.preset.ChartColors;

public class LineChartData extends ChartData<LineChartData, LineChartDataset, Number> {
    @Override
    public LineChartData applyDefaultStylePerDatapoint() {
        return applyDefaultStylePerDataset();
    }

    @Override
    public LineChartData applyDefaultStylePerDataset() {
        int colorIndex = 0;
        for (ChartDataset<LineChartDataset, Number> dataset : datasets) {
            if (dataset instanceof LineChartDataset) {
                ((LineChartDataset) dataset)
                        .setBackgroundColor(ChartColors.BACKGROUNDS.get(colorIndex % ChartColors.BACKGROUNDS.size()))
                        .setBorderColor(ChartColors.BORDERS.get(colorIndex % ChartColors.BORDERS.size()));
                colorIndex++;
            }
        }
        return this;
    }
}
