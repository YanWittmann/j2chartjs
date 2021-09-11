package de.yanwittmann.j2chartjs;

import de.yanwittmann.j2chartjs.chart.BarChart;
import de.yanwittmann.j2chartjs.data.BarChartData;
import de.yanwittmann.j2chartjs.dataset.BarChartDataset;
import j2html.tags.specialized.HtmlTag;
import j2html.tags.specialized.ScriptTag;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static j2html.TagCreator.*;

public class GenerateTest {

    @Test
    public void basicChartTest() throws IOException {
        BarChartDataset dataset = new BarChartDataset()
                .setLabel("sample chart")
                .setData(65, 59, 80, 81, 56, 55, 40)
                .addBackgroundColor(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.GRAY, Color.BLACK)
                .addBorderWidth(2)
                .setYAxisID("yaxisid");

        BarChartData barChartData = new BarChartData()
                .addLabels("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
                .addDataset(dataset);

        BarChart barChart = new BarChart();
        barChart.setChartData(barChartData);

        writePageWithChart(script(join("",
                "var ctx = document.getElementById('testChart').getContext('2d');",
                "var myChart = new Chart(ctx,",
                String.valueOf(barChart.toJson()),
                ");"
        )));
    }

    private void writePageWithChart(ScriptTag chartInitializer) throws IOException {
        HtmlTag page = html().attr("lang", "en").with(
                head().with(
                        meta().withCharset("UTF-8"),
                        title("ChartJs Builder Test"),
                        meta().withName("viewport").withContent("width=device-width, initial-scale=1.0"),
                        script().withSrc("https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js")
                ),
                body(
                        canvas().withId("testChart"),
                        chartInitializer
                )
        );
        FileUtils.write(new File("src/test/resources/chart_output.html"), page.render(), StandardCharsets.UTF_8);
    }
}
