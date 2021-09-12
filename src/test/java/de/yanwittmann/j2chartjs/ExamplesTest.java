package de.yanwittmann.j2chartjs;

import de.yanwittmann.j2chartjs.chart.BarChart;
import de.yanwittmann.j2chartjs.data.BarChartData;
import de.yanwittmann.j2chartjs.dataset.BarChartDataset;
import de.yanwittmann.j2chartjs.options.ChartOptions;
import de.yanwittmann.j2chartjs.options.animation.AnimationEasingType;
import de.yanwittmann.j2chartjs.options.animation.AnimationPropertyOption;
import de.yanwittmann.j2chartjs.options.animation.ChartAnimationOption;
import de.yanwittmann.j2chartjs.options.animation.PropertyAnimationOption;
import de.yanwittmann.j2chartjs.options.interaction.InteractionOption;
import de.yanwittmann.j2chartjs.options.layout.LayoutOption;
import de.yanwittmann.j2chartjs.options.plugins.legend.LegendOption;
import de.yanwittmann.j2chartjs.options.plugins.legend.LegendTitleOption;
import de.yanwittmann.j2chartjs.options.plugins.title.TitleOption;
import de.yanwittmann.j2chartjs.options.plugins.tooltip.TooltipOption;
import de.yanwittmann.j2chartjs.options.scale.LinearScaleOption;
import de.yanwittmann.j2chartjs.options.scale.LinearScaleTicksOption;
import de.yanwittmann.j2chartjs.options.scale.ScaleGridOption;
import de.yanwittmann.j2chartjs.options.scale.ScaleTitleOption;
import de.yanwittmann.j2chartjs.preset.ChartColors;
import de.yanwittmann.j2chartjs.type.ChartFont;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.awt.*;

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

    @Test
    public void largeBarChartTest() {
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
                .addDataset(dataset1, dataset2);


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
                .setType("logarithmic")
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
        options.addPropertyAnimation(AnimationPropertyOption.BORDER_WIDTH, propertyAnimationOption);


        BarChart barChart = new BarChart()
                .setChartData(barChartData)
                .setChartOptions(options);

        JSONObject chartConfiguration = barChart.toJson();
    }
}
