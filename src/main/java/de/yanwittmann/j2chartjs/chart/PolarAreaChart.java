package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.PolarAreaChartData;
import de.yanwittmann.j2chartjs.dataset.PolarAreaChartDataset;

import java.math.BigDecimal;

public class PolarAreaChart extends Chart<PolarAreaChart, PolarAreaChartData, PolarAreaChartDataset, BigDecimal> {
    public PolarAreaChart() {
        super("polarArea");
    }
}
