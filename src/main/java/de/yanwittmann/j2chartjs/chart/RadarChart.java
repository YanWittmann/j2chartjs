package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.RadarChartData;
import de.yanwittmann.j2chartjs.dataset.RadarChartDataset;

import java.math.BigDecimal;

public class RadarChart extends Chart<RadarChart, RadarChartData, RadarChartDataset, BigDecimal> {
    public RadarChart() {
        super("radar");
    }
}
