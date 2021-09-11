package de.yanwittmann.j2chartjs;

import de.yanwittmann.j2chartjs.chart.BarChart;
import de.yanwittmann.j2chartjs.data.BarChartData;
import de.yanwittmann.j2chartjs.dataset.BarChartDataset;
import de.yanwittmann.j2chartjs.options.ChartOption;
import de.yanwittmann.j2chartjs.options.animation.AnimationEasingType;
import de.yanwittmann.j2chartjs.options.animation.AnimationProperty;
import de.yanwittmann.j2chartjs.options.animation.ChartAnimationOption;
import de.yanwittmann.j2chartjs.options.animation.PropertyAnimationOption;
import de.yanwittmann.j2chartjs.options.interaction.InteractionOptions;
import de.yanwittmann.j2chartjs.options.scale.ScaleOption;
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
        BarChartDataset dataset1 = new BarChartDataset()
                .setLabel("Week 1")
                .setData(65, 59, 80, 81, 56, 55, 40)
                .addBackgroundColor(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.GRAY, Color.BLACK)
                .addBorderRadius(10, 15, 20, 0, 0, 0, 40)
                .addHoverBorderRadius(0)
                .addHoverBorderWidth(4)
                .addBorderWidth(2)
                .addHoverBorderColor(new Color(0, 0, 0, 100))
                .setYAxisID("yaxisid")
                .setBase(10)
                .setBarPercentage(0.5)
                .setMinBarLength(400);
        BarChartDataset dataset2 = new BarChartDataset()
                .setLabel("Week 1")
                .setData(40, 65, 59, 80, 81, 56, 55)
                .addBackgroundColor(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.GRAY, Color.BLACK)
                .addBorderRadius(10, 15, 20, 0, 0, 0, 40)
                .addHoverBorderRadius(0)
                .addHoverBorderWidth(4)
                .addBorderWidth(2)
                .addHoverBorderColor(new Color(0, 0, 0, 100))
                .setYAxisID("yaxisid")
                .setBase(10)
                .setBarPercentage(0.5)
                .setMinBarLength(400);

        BarChartData barChartData = new BarChartData()
                .addLabels("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
                .addDataset(dataset1)
                .addDataset(dataset2);


        ChartOption options = new ChartOption()
                .setResponsive(false)
                .setAspectRatio(1.5);

        InteractionOptions interactionOptions = new InteractionOptions()
                .setMode("point");
        options.setInteraction(interactionOptions);

        ScaleOption scaleOption = new ScaleOption();
        options.setScales(scaleOption);

        ChartAnimationOption chartAnimationOption = new ChartAnimationOption()
                .setDuration(1000)
                .setDelay(500);
        options.setChartAnimation(chartAnimationOption);

        PropertyAnimationOption<Integer> propertyAnimationOption = new PropertyAnimationOption<Integer>()
                .setFrom(10)
                .setTo(3)
                .setDuration(1000)
                .setDelay(1000)
                .setEasing(AnimationEasingType.EASE_IN_OUT_QUART)
                .setLoop(false);
        options.addPropertyAnimation(AnimationProperty.BORDER_WIDTH, propertyAnimationOption);


        BarChart barChart = new BarChart()
                .setChartData(barChartData)
                .setChartOptions(options);

        System.out.println(barChart.toJson().toString(2));

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
                        canvas().withId("testChart").withWidth("1000"),//.withHeight("400"),
                        chartInitializer
                )
        );
        FileUtils.write(new File("src/test/resources/chart_output.html"), page.renderFormatted(), StandardCharsets.UTF_8);
    }
}
