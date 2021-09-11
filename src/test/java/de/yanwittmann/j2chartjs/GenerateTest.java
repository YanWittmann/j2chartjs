package de.yanwittmann.j2chartjs;

import de.yanwittmann.j2chartjs.chart.BarChart;
import de.yanwittmann.j2chartjs.data.BarChartData;
import de.yanwittmann.j2chartjs.dataset.BarChartDataset;
import de.yanwittmann.j2chartjs.options.ChartOption;
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
import de.yanwittmann.j2chartjs.options.scale.ScaleGridOption;
import de.yanwittmann.j2chartjs.options.scale.ScaleOption;
import de.yanwittmann.j2chartjs.options.scale.ScaleTicksOption;
import de.yanwittmann.j2chartjs.options.scale.ScaleTitleOption;
import de.yanwittmann.j2chartjs.type.ChartFont;
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
                .setYAxisID("A")
                .setBase(4)
                .setBarPercentage(0.5);
        BarChartDataset dataset2 = new BarChartDataset()
                .setLabel("Week 2")
                .setData(40, 65, 59, 72, 81, 56, 55)
                .addBackgroundColor(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.GRAY, Color.BLACK)
                .addBorderRadius(10, 15, 20, 0, 0, 0, 40)
                .addHoverBorderRadius(0)
                .addHoverBorderWidth(4)
                .addBorderWidth(2)
                .addHoverBorderColor(new Color(0, 0, 0, 100))
                .setYAxisID("B")
                .setBase(10)
                .setBarPercentage(0.8);

        BarChartData barChartData = new BarChartData()
                .addLabels("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
                .addDataset(dataset1)
                .addDataset(dataset2);


        ChartOption options = new ChartOption()
                .setResponsive(false)
                .setAspectRatio(1.5);

        ScaleOption scaleOptionA = new ScaleOption()
                .setType("linear")
                .setPosition("left")
                .setSuggestedMax(100)
                .setGrid(new ScaleGridOption()
                        .setDisplay(true)
                        .setColor(Color.RED)
                        .setTickColor(Color.PINK)
                        .setZ(1));
        ScaleOption scaleOptionB = new ScaleOption()
                .setType("linear")
                .setPosition("right")
                .setBeginAtZero(false)
                .setTicks(new ScaleTicksOption()
                        .setColor(Color.BLUE))
                .setGrid(new ScaleGridOption()
                        .setDisplay(false));
        options.addScale("A", scaleOptionA);
        options.addScale("B", scaleOptionB);
        ScaleOption scaleOptionX = new ScaleOption()
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
        options.addScale("x", scaleOptionX);

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
                .setText("Main Title")
                .setColor(Color.ORANGE)
                .setDisplay(true)
                .setFont(new ChartFont().setFamily("Monaco").setSize(25));
        options.setOption(titleOption);

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
                        canvas().withId("testChart").withStyle("border: gray 2px solid;").withWidth("1000"),//.withHeight("400"),
                        chartInitializer
                )
        );
        FileUtils.write(new File("src/test/resources/chart_output.html"), page.renderFormatted(), StandardCharsets.UTF_8);
    }
}
