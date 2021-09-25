package de.yanwittmann.j2chartjs.quick;

import de.yanwittmann.j2chartjs.chart.LineChart;
import de.yanwittmann.j2chartjs.data.LineChartData;
import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import de.yanwittmann.j2chartjs.dataset.LineChartDataset;

import java.util.Collection;

public class QuickLineChart extends QuickChart<QuickLineChart, LineChartData> {

    public QuickLineChart() {
        super(new LineChartData());
    }

    public QuickLineChart addDataset(String label, Collection<? extends Number> data) {
        chartData.addDataset(new LineChartDataset().addData(data).setLabel(label));
        return this;
    }

    public QuickLineChart addDataset(String label, Number... data) {
        chartData.addDataset(new LineChartDataset().addData(data).setLabel(label));
        return this;
    }

    public QuickLineChart addDataset(Collection<? extends Number> data) {
        chartData.addDataset(new LineChartDataset().addData(data));
        return this;
    }

    public QuickLineChart addDataset(Number... data) {
        chartData.addDataset(new LineChartDataset().addData(data));
        return this;
    }

    public QuickLineChart setTension(Number tension) {
        for (ChartDataset<LineChartDataset, Number> dataset : chartData.getDatasets()) {
            ((LineChartDataset) dataset).setTension(tension.doubleValue());
        }
        return this;
    }

    public QuickLineChart setShowLine(Boolean showLine) {
        for (ChartDataset<LineChartDataset, Number> dataset : chartData.getDatasets()) {
            ((LineChartDataset) dataset).setShowLine(showLine);
        }
        return this;
    }

    @Override
    public String build() {
        return new LineChart()
                .setChartOptions(chartOptions)
                .setChartData(chartData.applyDefaultStylePerDataset())
                .build();
    }
}
