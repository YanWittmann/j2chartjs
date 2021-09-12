package de.yanwittmann.j2chartjs;

import de.yanwittmann.j2chartjs.chart.*;
import de.yanwittmann.j2chartjs.data.*;
import de.yanwittmann.j2chartjs.datapoint.BubbleChartDatapoint;
import de.yanwittmann.j2chartjs.datapoint.ScatterChartDatapoint;
import de.yanwittmann.j2chartjs.dataset.*;
import de.yanwittmann.j2chartjs.options.ChartOptions;
import de.yanwittmann.j2chartjs.options.animation.*;
import de.yanwittmann.j2chartjs.options.interaction.InteractionOption;
import de.yanwittmann.j2chartjs.options.layout.LayoutOption;
import de.yanwittmann.j2chartjs.options.plugins.legend.LegendOption;
import de.yanwittmann.j2chartjs.options.plugins.legend.LegendTitleOption;
import de.yanwittmann.j2chartjs.options.plugins.title.TitleOption;
import de.yanwittmann.j2chartjs.options.plugins.tooltip.TooltipOption;
import de.yanwittmann.j2chartjs.options.scale.*;
import de.yanwittmann.j2chartjs.preset.ChartColors;
import de.yanwittmann.j2chartjs.type.ChartFont;
import de.yanwittmann.j2chartjs.type.ChartPadding;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class GenerateTest {

    @Test
    public void simpleTest() throws IOException {
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
                .setTitle(new TitleOption().setText("Sample Chart").setDisplay(true))
                .addTransition(TransitionAnimationType.HIDE, new TransitionAnimationOption()
                        .addPropertyAnimation(AnimationPropertyOption.X, new PropertyAnimationOption<Integer>().setTo(0))
                        .addPropertyAnimation(AnimationPropertyOption.Y, new PropertyAnimationOption<Integer>().setTo(0)));

        BarChart chart = new BarChart()
                .setChartOptions(options)
                .setChartData(data);
    }

    @Test
    public void scatterTest() throws IOException {
        Random random = new Random();
        ScatterChartDataset dataset = new ScatterChartDataset()
                .setLabel("Points everywhere")
                .setBackgroundColor(ChartColors.BACKGROUNDS)
                .setBorderColor(ChartColors.BORDERS)
                .addPointStyle("star");
        for (int i = 0; i < 500; i++)
            dataset.addData(new ScatterChartDatapoint(random.nextInt(100), random.nextInt(100)));

        ScatterChartData data = new ScatterChartData()
                .addDataset(dataset);

        ChartOptions options = new ChartOptions()
                .addScale("y", new LinearScaleOption().setSuggestedMin(0))
                .addScale("x", new LinearScaleOption().setSuggestedMin(0));

        ScatterChart chart = new ScatterChart()
                .setChartOptions(options)
                .setChartData(data);
    }

    @Test
    public void bubbleTest() throws IOException {
        Random random = new Random();
        BubbleChartDataset dataset = new BubbleChartDataset()
                .setLabel("Points in time and space")
                .setBackgroundColor(ChartColors.BACKGROUNDS)
                .setBorderColor(ChartColors.BORDERS)
                .addPointStyle("star");
        for (int i = 0; i < 500; i++)
            dataset.addData(new BubbleChartDatapoint(random.nextInt(100), random.nextInt(100), random.nextInt(30) + 10));

        BubbleChartData data = new BubbleChartData()
                .addDataset(dataset);

        ChartOptions options = new ChartOptions()
                .addScale("y", new LinearScaleOption().setSuggestedMin(0))
                .addScale("x", new LinearScaleOption().setSuggestedMin(0));

        BubbleChart chart = new BubbleChart()
                .setChartOptions(options)
                .setChartData(data);
    }

    @Test
    public void polarAreaTest() throws IOException {
        PolarAreaChartDataset dataset = new PolarAreaChartDataset()
                .addData(10, 34, 23)
                .setBackgroundColor(ChartColors.BACKGROUNDS)
                .setBorderColor(ChartColors.BORDERS)
                .addOffset(10)
                .addSpacing(30)
                .addBorderAlign("center", "inner", "center");

        PolarAreaChartData data = new PolarAreaChartData()
                .addDataset(dataset)
                .addLabels("First", "Second", "Third");

        ChartOptions options = new ChartOptions()
                .setInteraction(new InteractionOption()
                        .setMode("index"));

        PolarAreaChart polarAreaChart = new PolarAreaChart()
                .setChartOptions(options)
                .setChartData(data);
    }

    @Test
    public void doughnutPieTest() throws IOException {
        DoughnutPieChartDataset dataset1 = new DoughnutPieChartDataset()
                .addData(10, 34, 23)
                .setBackgroundColor(ChartColors.BACKGROUNDS)
                .setBorderColor(ChartColors.BORDERS)
                .setCutout("20%")
                .addHoverOffset(10);
        DoughnutPieChartDataset dataset2 = new DoughnutPieChartDataset()
                .addData(18, 45, 35)
                .setBackgroundColor(ChartColors.BACKGROUNDS)
                .setBorderColor(ChartColors.BORDERS)
                .setCutout("10%")
                .addHoverOffset(10)
                .addSpacing(10);

        DoughnutPieChartData data = new DoughnutPieChartData()
                .addDataset(dataset1)
                .addDataset(dataset2)
                .addLabels("First", "Second", "Third");

        ChartOptions options = new ChartOptions()
                .setInteraction(new InteractionOption()
                        .setMode("index"));

        DoughnutChart doughnutChart = new DoughnutChart()
                .setChartOptions(options)
                .setChartData(data);

        PieChart pieChart = new PieChart()
                .setChartOptions(options)
                .setChartData(data);
    }

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

        RadarChart radarChart = new RadarChart()
                .setChartOptions(options)
                .setChartData(chartData);
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
    }
}
