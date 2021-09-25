package de.yanwittmann.j2chartjs.quick;

import de.yanwittmann.j2chartjs.chart.RadarChart;
import de.yanwittmann.j2chartjs.data.RadarChartData;
import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import de.yanwittmann.j2chartjs.dataset.RadarChartDataset;

import java.util.Collection;

public class QuickRadarChart extends QuickChart<QuickRadarChart, RadarChartData> {

    public QuickRadarChart() {
        super(new RadarChartData());
    }

    public QuickRadarChart addDataset(String label, Collection<? extends Number> data) {
        chartData.addDataset(new RadarChartDataset().addData(data).setLabel(label));
        return this;
    }

    public QuickRadarChart addDataset(String label, Number... data) {
        chartData.addDataset(new RadarChartDataset().addData(data).setLabel(label));
        return this;
    }

    public QuickRadarChart addDataset(Collection<? extends Number> data) {
        chartData.addDataset(new RadarChartDataset().addData(data));
        return this;
    }

    public QuickRadarChart addDataset(Number... data) {
        chartData.addDataset(new RadarChartDataset().addData(data));
        return this;
    }

    public QuickRadarChart setTension(Number tension) {
        for (ChartDataset<RadarChartDataset, Number> dataset : chartData.getDatasets()) {
            ((RadarChartDataset) dataset).setTension(tension.doubleValue());
        }
        return this;
    }

    @Override
    public String build() {
        return new RadarChart()
                .setChartOptions(chartOptions)
                .setChartData(chartData.applyDefaultStylePerDatapoint())
                .build();
    }
}
