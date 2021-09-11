package be.ceau;

import be.ceau.chart.BarChart;
import be.ceau.chart.color.Color;
import be.ceau.chart.data.BarData;
import be.ceau.chart.dataset.BarDataset;
import org.junit.jupiter.api.Test;

public class BeCeauGeneratorTest {

    @Test
    public void generateTest() {
        BarDataset dataset = new BarDataset()
                .setLabel("sample chart")
                .setData(65, 59.3, 80, 81, 56, 55, 40)
                .addBackgroundColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.GRAY, Color.BLACK)
                .setBorderWidth(2)
                .setYAxisID("yaxisid");

        BarData data = new BarData()
                .addLabels("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
                .addDataset(dataset);

        System.out.println(new BarChart(data).toJson());
    }
}
