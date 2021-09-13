package de.yanwittmann.j2chartjs.preset;


import de.yanwittmann.j2chartjs.data.*;
import de.yanwittmann.j2chartjs.dataset.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ChartColors {

    public final static Color BORDER_RED = new Color(255, 99, 132);
    public final static Color BORDER_ORANGE = new Color(255, 159, 64);
    public final static Color BORDER_YELLOW = new Color(255, 205, 86);
    public final static Color BORDER_GREEN = new Color(173, 255, 86);
    public final static Color BORDER_AQUA = new Color(75, 192, 192);
    public final static Color BORDER_BLUE = new Color(54, 162, 235);
    public final static Color BORDER_PURPLE = new Color(153, 102, 255);
    public final static Color BORDER_PINK = new Color(245, 102, 255);
    public final static Color BORDER_GRAY = new Color(201, 203, 207);

    public final static Color BACKGROUND_RED = makeBackgroundColor(BORDER_RED);
    public final static Color BACKGROUND_ORANGE = makeBackgroundColor(BORDER_ORANGE);
    public final static Color BACKGROUND_YELLOW = makeBackgroundColor(BORDER_YELLOW);
    public final static Color BACKGROUND_GREEN = makeBackgroundColor(BORDER_GREEN);
    public final static Color BACKGROUND_AQUA = makeBackgroundColor(BORDER_AQUA);
    public final static Color BACKGROUND_BLUE = makeBackgroundColor(BORDER_BLUE);
    public final static Color BACKGROUND_PURPLE = makeBackgroundColor(BORDER_PURPLE);
    public final static Color BACKGROUND_PINK = makeBackgroundColor(BORDER_PINK);
    public final static Color BACKGROUND_GRAY = makeBackgroundColor(BORDER_GRAY);

    public final static List<Color> BORDERS;

    static {
        List<Color> list = new ArrayList<>();
        list.add(BORDER_RED);
        list.add(BORDER_ORANGE);
        list.add(BORDER_YELLOW);
        list.add(BORDER_GREEN);
        list.add(BORDER_AQUA);
        list.add(BORDER_BLUE);
        list.add(BORDER_PURPLE);
        list.add(BORDER_PINK);
        list.add(BORDER_GRAY);
        BORDERS = Collections.unmodifiableList(list);
    }

    public final static List<Color> BACKGROUNDS;

    static {
        List<Color> list = new ArrayList<>();
        list.add(BACKGROUND_RED);
        list.add(BACKGROUND_ORANGE);
        list.add(BACKGROUND_YELLOW);
        list.add(BACKGROUND_GREEN);
        list.add(BACKGROUND_AQUA);
        list.add(BACKGROUND_BLUE);
        list.add(BACKGROUND_PURPLE);
        list.add(BACKGROUND_PINK);
        list.add(BACKGROUND_GRAY);
        BACKGROUNDS = Collections.unmodifiableList(list);
    }

    private final static Color makeBackgroundColor(Color color) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), a(0.2));
    }

    private final static int a(double a) {
        return (int) (a * 255.0);
    }

    public static void applyDefaultStylePerDatapoint(ChartDataset dataset) {
        if (dataset instanceof BarChartDataset) {
            new BarChartData().addDataset(dataset).applyDefaultStylePerDatapoint();
        } else if (dataset instanceof BubbleChartDataset) {
            new BubbleChartData().addDataset(dataset).applyDefaultStylePerDatapoint();
        } else if (dataset instanceof DoughnutPieChartDataset) {
            new DoughnutPieChartData().addDataset(dataset).applyDefaultStylePerDatapoint();
        } else if (dataset instanceof LineChartDataset) {
            new LineChartData().addDataset(dataset).applyDefaultStylePerDatapoint();
        } else if (dataset instanceof PolarAreaChartDataset) {
            new PolarAreaChartData().addDataset(dataset).applyDefaultStylePerDatapoint();
        } else if (dataset instanceof RadarChartDataset) {
            new RadarChartData().addDataset(dataset).applyDefaultStylePerDatapoint();
        } else if (dataset instanceof ScatterChartDataset) {
            new ScatterChartData().addDataset(dataset).applyDefaultStylePerDatapoint();
        }
    }

    public static void applyDefaultStylePerDataset(ChartDataset dataset) {
        if (dataset instanceof BarChartDataset) {
            new BarChartData().addDataset(dataset).applyDefaultStylePerDataset();
        } else if (dataset instanceof BubbleChartDataset) {
            new BubbleChartData().addDataset(dataset).applyDefaultStylePerDataset();
        } else if (dataset instanceof DoughnutPieChartDataset) {
            new DoughnutPieChartData().addDataset(dataset).applyDefaultStylePerDataset();
        } else if (dataset instanceof LineChartDataset) {
            new LineChartData().addDataset(dataset).applyDefaultStylePerDataset();
        } else if (dataset instanceof PolarAreaChartDataset) {
            new PolarAreaChartData().addDataset(dataset).applyDefaultStylePerDataset();
        } else if (dataset instanceof RadarChartDataset) {
            new RadarChartData().addDataset(dataset).applyDefaultStylePerDataset();
        } else if (dataset instanceof ScatterChartDataset) {
            new ScatterChartData().addDataset(dataset).applyDefaultStylePerDataset();
        }
    }

    public static void applyDefaultStylePerDatapoint(ChartData dataset) {
        dataset.applyDefaultStylePerDatapoint();
    }

    public static void applyDefaultStylePerDataset(ChartData dataset) {
        dataset.applyDefaultStylePerDataset();
    }
}
