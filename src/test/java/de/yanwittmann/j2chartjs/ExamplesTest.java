package de.yanwittmann.j2chartjs;

import de.yanwittmann.j2chartjs.chart.BarChart;
import de.yanwittmann.j2chartjs.data.BarChartData;
import de.yanwittmann.j2chartjs.dataset.BarChartDataset;
import de.yanwittmann.j2chartjs.options.ChartOptions;
import de.yanwittmann.j2chartjs.options.plugins.title.TitleOption;
import de.yanwittmann.j2chartjs.preset.ChartColors;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class ExamplesTest {

    @Test
    public void readmeTest() {
        BarChartDataset dataset = new BarChartDataset()
                .setData(12, 32, 8, 45, 27, 23)
                .setLabel("Sample Dataset")
                .setBackgroundColor(ChartColors.BACKGROUNDS)
                .setBorderColor(ChartColors.BORDERS)
                .addBorderWidth(1);

        BarChartData data = new BarChartData()
                .addDataset(dataset)
                .addLabels("Entry 1", "Entry 2", "Entry 3", "Entry 4", "Entry 5", "Entry 6");

        ChartOptions options = new ChartOptions()
                .setTitle(new TitleOption().setText("Sample Chart").setDisplay(true));

        BarChart chart = new BarChart()
                .setChartOptions(options)
                .setChartData(data);

        JSONObject chartConfiguration = chart.toJson();
    }
}
