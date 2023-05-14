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
import de.yanwittmann.j2chartjs.quick.*;
import de.yanwittmann.j2chartjs.type.ChartFont;
import de.yanwittmann.j2chartjs.type.ChartPadding;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GenerateTest {

    @Test
    public void repetitiveColorsTest() {
        LineChartDataset dataset = new LineChartDataset().setBorderColor(new Color(140, 140, 140, 107)).setLabel("Dataset awesome");
        LineChartData data = new LineChartData().addDataset(dataset);
        for (int i = 0; i < 100; i++) {
            dataset.addData(new Random().nextInt(230512202));
            dataset.addPointBackgroundColor(new Random().nextInt(2) == 1 ? Color.RED : Color.BLUE);
            dataset.addPointRadius(1 + new Random().nextInt(3));
        }
        ChartOptions options = new ChartOptions().setResponsive(false);
        System.out.println(new LineChart().setChartOptions(options).setChartData(data).build());
    }

    @Test
    public void quickChartTest() {
        System.out.println(
                new QuickBarChart()
                        .addDataset("Data 1", 10, 20, 30)
                        .addDataset("Data 2", 34, 22, 14)
                        .addLabels("Point 1", "Point 2", "Point 3")
                        .setTitle("Quick chart")
                        .setGridLinesVisible(false)
                        .setBeginAtZero(true)
                        .build()
        );
        System.out.println(
                new QuickLineChart()
                        .addDataset("Data 1", 10, 20, 10)
                        .addDataset("Data 2", 34, 50, 14)
                        .addLabels("Point 1", "Point 2", "Point 3")
                        .setTitle("Quick chart")
                        .setBeginAtZero(true)
                        .setIndexMode(true)
                        .setTension(0.2)
                        .build()
        );
        System.out.println(
                new QuickBubbleChart()
                        .addDatasets("Data 1", new QuickBubbleChartDataset()
                                .addX(10, 20, 30)
                                .addY(30, 20, 10)
                                .addR(10, 20, 30))
                        .addDatasets("Data 2", new QuickBubbleChartDataset()
                                .addX(43, 24, 14)
                                .addY(5, 32, 23)
                                .addR(10, 30, 20))
                        .addLabels("Point 1", "Point 2", "Point 3")
                        .setTitle("Quick chart")
                        .build()
        );
        System.out.println(
                new QuickScatterChart()
                        .addDatasets("Data 1", new QuickScatterChartDataset()
                                .addX(10, 20, 30)
                                .addY(30, 20, 10))
                        .addDatasets("Data 2", new QuickScatterChartDataset()
                                .addX(43, 24, 14)
                                .addY(5, 32, 23))
                        .addLabels("Point 1", "Point 2", "Point 3")
                        .setTitle("Quick chart")
                        .setShowLine(true)
                        .setPointWidth(5)
                        .build()
        );
        System.out.println(
                new QuickDoughnutChart()
                        .addDataset("Data 1", 10, 20, 30)
                        .addDataset("Data 2", 34, 22, 14)
                        .addLabels("Point 1", "Point 2", "Point 3")
                        .setTitle("Quick chart")
                        .build()
        );
        System.out.println(
                new QuickPolarAreaChart()
                        .addDataset("Data 1", 10, 20, 30)
                        .addDataset("Data 2", 34, 22, 14)
                        .addLabels("Point 1", "Point 2", "Point 3")
                        .setTitle("Quick chart")
                        .setIndexMode(true)
                        .build()
        );
        System.out.println(
                new QuickRadarChart()
                        .addDataset("Data 1", 10, 20, 30)
                        .addDataset("Data 2", 34, 22, 14)
                        .addLabels("Point 1", "Point 2", "Point 3")
                        .setTitle("Quick chart")
                        .setIndexMode(true)
                        .setTension(0.1)
                        .build()
        );
    }

    @Test
    public void mixedChartTest() {
        BarChartDataset barChartDataset = new BarChartDataset()
                .setData(10, 20, 30, 40)
                .setLabel("Bar Dataset")
                .addBorderWidth(2);

        LineChartDataset lineChartDataset = new LineChartDataset()
                .setData(23, 30, 25, 35)
                .setLabel("Line Dataset");

        MixedChartData mixedChartData = new MixedChartData()
                .addDataset(lineChartDataset, barChartDataset)
                .addLabels("January", "February", "March", "April")
                .applyDefaultStylePerDatapoint();

        MixedChart mixedChart = new MixedChart()
                .setChartData(mixedChartData);

        System.out.println(mixedChart);
    }

    @Test
    public void simpleTest() {
        BarChartData data = new BarChartData()
                .addDataset(new BarChartDataset()
                        .setData(12, 32, 8, 45, 27, 23)
                        .setLabel("Sample Dataset 1")
                        .addBorderWidth(1))
                .addDataset(new BarChartDataset()
                        .setData(54, 28, 17, 24, 9, 10)
                        .setLabel("Sample Dataset 2")
                        .addBorderWidth(1))
                .addLabels("Entry 1", "Entry 2", "Entry 3", "Entry 4", "Entry 5", "Entry 6");

        ChartColors.applyDefaultStylePerDataset(data);

        ChartOptions options = new ChartOptions()
                .setTitle(new TitleOption().setText("Sample Chart").setDisplay(true))
                .addTransition(TransitionAnimationType.HIDE, new TransitionAnimationOption()
                        .addPropertyAnimation(AnimationPropertyOption.X, new PropertyAnimationOption<Integer>().setTo(0))
                        .addPropertyAnimation(AnimationPropertyOption.Y, new PropertyAnimationOption<Integer>().setTo(0)));

        BarChart chart = new BarChart()
                .setChartOptions(options)
                .setChartData(data);

        System.out.println(chart);
    }

    @Test
    public void scatterTest() {
        Random random = new Random();
        ScatterChartDataset dataset1 = new ScatterChartDataset()
                .setLabel("Points in time and space p.1");
        for (int i = 0; i < 250; i++)
            dataset1.addData(new ScatterChartDatapoint(random.nextInt(100), random.nextInt(100)));
        ScatterChartDataset dataset2 = new ScatterChartDataset()
                .setLabel("Points in time and space p.2");
        for (int i = 0; i < 250; i++)
            dataset2.addData(new ScatterChartDatapoint(random.nextInt(100), random.nextInt(100)));

        ScatterChartData data = new ScatterChartData()
                .addDataset(dataset1)
                .addDataset(dataset2)
                .applyDefaultStylePerDataset();

        ChartOptions options = new ChartOptions()
                .addScale("y", new LinearScaleOption().setSuggestedMin(0))
                .addScale("x", new LinearScaleOption().setSuggestedMin(0));

        ScatterChart chart = new ScatterChart()
                .setChartOptions(options)
                .setChartData(data);

        System.out.println(chart);
    }

    @Test
    public void bubbleTest() {
        Random random = new Random();
        BubbleChartDataset dataset1 = new BubbleChartDataset()
                .setLabel("Points in time and space p.1");
        for (int i = 0; i < 250; i++)
            dataset1.addData(new BubbleChartDatapoint(random.nextInt(100), random.nextInt(100), random.nextInt(30) + 10));
        BubbleChartDataset dataset2 = new BubbleChartDataset()
                .setLabel("Points in time and space p.2");
        for (int i = 0; i < 250; i++)
            dataset2.addData(new BubbleChartDatapoint(random.nextInt(100), random.nextInt(100), random.nextInt(30) + 10));

        BubbleChartData data = new BubbleChartData()
                .addDataset(dataset1)
                .addDataset(dataset2)
                .applyDefaultStylePerDataset();

        ChartOptions options = new ChartOptions()
                .addScale("y", new LinearScaleOption().setSuggestedMin(0))
                .addScale("x", new LinearScaleOption().setSuggestedMin(0));

        BubbleChart chart = new BubbleChart()
                .setChartOptions(options)
                .setChartData(data);

        System.out.println(chart);
    }

    @Test
    public void polarAreaTest() {
        PolarAreaChartDataset dataset = new PolarAreaChartDataset()
                .addData(new ArrayList<>(Arrays.asList(10, 34, 23)))
                .addOffset(10)
                .addSpacing(30)
                .addBorderAlign("center", "inner", "center");

        PolarAreaChartData data = new PolarAreaChartData()
                .addDataset(dataset)
                .addLabels("First", "Second", "Third")
                .applyDefaultStylePerDatapoint();

        ChartOptions options = new ChartOptions()
                .setInteraction(new InteractionOption()
                        .setMode("index"));

        PolarAreaChart polarAreaChart = new PolarAreaChart()
                .setChartOptions(options)
                .setChartData(data);

        System.out.println(polarAreaChart);
    }

    @Test
    public void doughnutPieTest() {
        DoughnutPieChartDataset dataset1 = new DoughnutPieChartDataset()
                .addData(10, 34, 23)
                .setCutout("20%")
                .addHoverOffset(10);
        DoughnutPieChartDataset dataset2 = new DoughnutPieChartDataset()
                .addData(18, 45, 35)
                .setCutout("10%")
                .addHoverOffset(10)
                .addSpacing(10);

        DoughnutPieChartData data = new DoughnutPieChartData()
                .addDataset(dataset1)
                .addDataset(dataset2)
                .addLabels("First", "Second", "Third")
                .applyDefaultStylePerDatapoint();

        ChartOptions options = new ChartOptions()
                .setInteraction(new InteractionOption()
                        .setMode("index"));

        DoughnutChart doughnutChart = new DoughnutChart()
                .setChartOptions(options)
                .setChartData(data);

        PieChart pieChart = new PieChart()
                .setChartOptions(options)
                .setChartData(data);

        System.out.println(doughnutChart);
    }

    @Test
    public void radarChartTest() {
        RadarChartDataset chartDataset1 = new RadarChartDataset()
                .addData(23, 33, 4.5, 27)
                .setTension(0.4);
        RadarChartDataset chartDataset2 = new RadarChartDataset()
                .addData(19, 25, 47, 32)
                .setTension(0.4);

        RadarChartData chartData = new RadarChartData()
                .addDataset(chartDataset1)
                .addDataset(chartDataset2)
                .addLabels("1", "2", "3", "4")
                .applyDefaultStylePerDatapoint();

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

        System.out.println(radarChart);
    }

    @Test
    public void lineChartTest() {
        Random random = new Random();
        LineChartData barChartData = new LineChartData()
                .addLabels("Shoes", "T-Shirts", "Pants");
        barChartData.addDataset(new LineChartDataset()
                .setData(17, 23, 9)
                .addPointBackgroundColor(Color.ORANGE)
                .setTension(0.3)
                .setBorderColor(Color.ORANGE)
                .addPointHoverBorderColor(Color.GREEN)
                .addPointRadius(5)
                .addPointHoverBorderWidth(8)
                .addPointStyle("triangle")
                .setLabel("Day 1"));
        for (int i = 2; i < 12; i++) {
            barChartData.addDataset(new LineChartDataset()
                    .setData(random.nextInt(30) + 5, random.nextInt(30) + 5, random.nextInt(30) + 5)
                    .setTension(0.3)
                    .setLabel("Day " + i));
        }
        barChartData.applyDefaultStylePerDatapoint();

        ChartOptions chartOptions = new ChartOptions()
                .setInteraction(new InteractionOption()
                        .setMode("index"))
                .setTitle(new TitleOption()
                        .setText("# Items sold")
                        .setDisplay(true));

        LineChart lineChart = new LineChart()
                .setChartOptions(chartOptions)
                .setChartData(barChartData);

        System.out.println(lineChart);
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

        System.out.println(barChart);
    }
}
