package de.yanwittmann.j2chartjs;

import de.yanwittmann.j2chartjs.chart.BarChart;
import de.yanwittmann.j2chartjs.chart.Chart;
import de.yanwittmann.j2chartjs.chart.LineChart;
import de.yanwittmann.j2chartjs.chart.RadarChart;
import de.yanwittmann.j2chartjs.data.BarChartData;
import de.yanwittmann.j2chartjs.data.LineChartData;
import de.yanwittmann.j2chartjs.data.RadarChartData;
import de.yanwittmann.j2chartjs.dataset.BarChartDataset;
import de.yanwittmann.j2chartjs.dataset.LineChartDataset;
import de.yanwittmann.j2chartjs.dataset.RadarChartDataset;
import de.yanwittmann.j2chartjs.options.ChartOptions;
import de.yanwittmann.j2chartjs.options.animation.AnimationEasingType;
import de.yanwittmann.j2chartjs.options.animation.AnimationProperty;
import de.yanwittmann.j2chartjs.options.animation.ChartAnimationOption;
import de.yanwittmann.j2chartjs.options.animation.PropertyAnimationOption;
import de.yanwittmann.j2chartjs.options.interaction.InteractionOption;
import de.yanwittmann.j2chartjs.options.layout.LayoutOption;
import de.yanwittmann.j2chartjs.options.plugins.legend.LegendOption;
import de.yanwittmann.j2chartjs.options.plugins.legend.LegendTitleOption;
import de.yanwittmann.j2chartjs.options.plugins.title.TitleOption;
import de.yanwittmann.j2chartjs.options.plugins.tooltip.TooltipOption;
import de.yanwittmann.j2chartjs.options.scale.*;
import de.yanwittmann.j2chartjs.type.ChartFont;
import de.yanwittmann.j2chartjs.type.ChartPadding;
import j2html.tags.specialized.HtmlTag;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static j2html.TagCreator.*;

public class GenerateTest {

    @Test
    public void radarChartTest() throws IOException {
        RadarChartDataset chartDataset = new RadarChartDataset()
                .addData(23, 33, 4.5, 27)
                .setTension(0.4)
                .setBackgroundColor(new Color(255, 120, 120, 92))
                .setBorderColor(new Color(255, 120, 120));

        RadarChartData chartData = new RadarChartData()
                .addDataset(chartDataset)
                .addLabels("1", "2", "3", "4");

        RadialScaleOption scale = new RadialScaleOption()
                .setSuggestedMax(40)
                .setAngleLines(new RadialScaleAngleLinesOption()
                        .setColor(Color.RED))
                .setGrid(new ScaleGridOption()
                        .setColor(Color.BLUE))
                .setPointLabels(new RadialScalePointLabelOption()
                        .setBackdropColor(Color.BLUE)
                        .setColor(Color.WHITE)
                        .setBackdropPadding(new ChartPadding().setPadding(15))
                        .setPadding(5));

        ChartOptions options = new ChartOptions();
        options.setInteraction(new InteractionOption()
                        .setMode("index"))
                .addScale("r", scale);

        RadarChart lineChart = new RadarChart()
                .setChartOptions(options)
                .setChartData(chartData);

        writePageWithChart(lineChart);
    }

    @Test
    public void lineChartTest() throws IOException {
        LineChartDataset datasetY = new LineChartDataset()
                .setData(10, 20, 15)
                .setIndexAxis("x")
                .setLabel("Day 1");
        LineChartDataset datasetX = new LineChartDataset()
                .setData(17, 23, 5)
                .addPointBackgroundColor(Color.ORANGE)
                .setTension(0.3)
                .setBorderColor(Color.ORANGE)
                .addPointHoverBorderColor(Color.GREEN)
                .addPointRadius(5)
                .addPointHoverBorderWidth(8)
                .addPointStyle("triangle")
                .setIndexAxis("x")
                .setLabel("Day 2");

        LineChartData barChartData = new LineChartData()
                .addLabels("Shoes", "T-Shirts", "Pants")
                .addDataset(datasetY)
                .addDataset(datasetX);

        ChartOptions chartOptions = new ChartOptions()
                .setInteraction(new InteractionOption()
                        .setMode("index"))
                .setTitle(new TitleOption()
                        .setText("# Items sold")
                        .setDisplay(true));

        LineChart lineChart = new LineChart()
                .setChartOptions(chartOptions)
                .setChartData(barChartData);

        writePageWithChart(lineChart);
    }

    @Test
    public void largeBarChartTest() throws IOException {
        BarChartDataset dataset1 = new BarChartDataset()
                .setLabel("Week 1")
                .setData(65, 59, 80, 81, 56, 55, 40)
                .addBackgroundColor(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.GRAY, Color.BLACK)
                .addBorderRadius(10, 15, 20, 0, 0, 0, 40)
                .addHoverBorderRadius(0)
                .addHoverBorderWidth(4)
                .addBorderWidth(2)
                .addHoverBorderColor(new Color(0, 0, 0, 100))
                .setyAxisID("A")
                .setBase(4)
                .setBarPercentage(0.5)
                .setMinBarLength(10);
        BarChartDataset dataset2 = new BarChartDataset()
                .setLabel("Week 2")
                .setData(40, 65, 59, 72, 81, 56, 55)
                .addBackgroundColor(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.GRAY, Color.BLACK)
                .addBorderRadius(10, 15, 20, 0, 0, 0, 40)
                .addHoverBorderRadius(0)
                .addHoverBorderWidth(4)
                .addBorderWidth(2)
                .addHoverBorderColor(new Color(0, 0, 0, 100))
                .setyAxisID("B")
                .setBase(10)
                .setBarPercentage(0.8);

        BarChartData barChartData = new BarChartData()
                .addLabels("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
                .addDataset(dataset1)
                .addDataset(dataset2);


        ChartOptions options = new ChartOptions()
                .setResponsive(false)
                .setAspectRatio(1.5);

        LinearScaleOption linearScaleOptionA = new LinearScaleOption()
                .setType("linear")
                .setPosition("left")
                .setSuggestedMax(100)
                .setGrid(new ScaleGridOption()
                        .setDisplay(true)
                        .setColor(Color.RED)
                        .setTickColor(Color.PINK)
                        .setZ(1));
        LinearScaleOption linearScaleOptionB = new LinearScaleOption()
                .setType("linear")
                .setPosition("right")
                .setBeginAtZero(false)
                .setTicks(new LinearScaleTicksOption()
                        .setColor(Color.BLUE))
                .setGrid(new ScaleGridOption()
                        .setDisplay(false));
        options.addScale("A", linearScaleOptionA);
        options.addScale("B", linearScaleOptionB);
        LinearScaleOption linearScaleOptionX = new LinearScaleOption()
                .setGrid(new ScaleGridOption()
                        .setColor(Color.GREEN)
                        .setZ(1))
                .setTitle(new ScaleTitleOption()
                        .setText("Weekday")
                        .setDisplay(true)
                        .setFont(new ChartFont()
                                .setStyle("italic")
                                .setSize(24)))
                .setPosition("center");
        options.addScale("x", linearScaleOptionX);

        InteractionOption interactionOption = new InteractionOption()
                .setMode("index");
        options.setOption(interactionOption);

        LayoutOption layoutOption = new LayoutOption();
        layoutOption.setPadding(15);
        options.setOption(layoutOption);

        LegendOption legendOption = new LegendOption()
                .setAlign("start")
                .setTitleOption(new LegendTitleOption()
                        .setText("This is a title")
                        .setDisplay(true)
                        .setPadding(10));
        options.setOption(legendOption);

        TooltipOption tooltipOption = new TooltipOption()
                .setBodyColor(Color.WHITE)
                .setBackgroundColor(Color.BLUE)
                .setBodySpacing(10)
                .setCornerRadius(0)
                .setTitleColor(Color.CYAN)
                .setTitleMarginBottom(30);
        options.setOption(tooltipOption);

        TitleOption titleOption = new TitleOption()
                .setAlign("end")
                .setText("Demo Chart")
                .setColor(Color.BLUE)
                .setDisplay(true)
                .setFont(new ChartFont().setFamily("Monaco").setSize(25));
        options.setOption(titleOption);

        TitleOption subtitleOption = new TitleOption()
                .setAlign("end")
                .setText("Ugly as hell but", "it's automatically generated!")
                .setColor(Color.ORANGE)
                .setDisplay(true)
                .setFont(new ChartFont().setFamily("Monaco").setSize(20));
        options.setSubtitle(subtitleOption);

        ChartAnimationOption chartAnimationOption = new ChartAnimationOption()
                .setDuration(1000)
                .setDelay(500);
        options.setOption(chartAnimationOption);

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

        writePageWithChart(barChart);
    }

    private void writePageWithChart(Chart chart) throws IOException {
        System.out.println(chart.toJson().toString(2));

        HtmlTag page = html().attr("lang", "en").with(
                head().with(
                        meta().withCharset("UTF-8"),
                        title("ChartJs Builder Test"),
                        meta().withName("viewport").withContent("width=device-width, initial-scale=1.0"),
                        script().withSrc("https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js")
                ),
                body(
                        canvas().withId("testChart").withStyle("border: gray 2px solid;").withWidth("1000"),//.withHeight("400"),
                        script(join("",
                                "var ctx = document.getElementById('testChart').getContext('2d');",
                                "var myChart = new Chart(ctx,",
                                String.valueOf(chart.toJson()),
                                ");"
                        ))
                )
        );
        FileUtils.write(new File("src/test/resources/chart_output.html"), page.renderFormatted(), StandardCharsets.UTF_8);
    }
}
