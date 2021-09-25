package de.yanwittmann.j2chartjs.quick;

import de.yanwittmann.j2chartjs.chart.BarChart;
import de.yanwittmann.j2chartjs.data.BarChartData;
import de.yanwittmann.j2chartjs.dataset.BarChartDataset;

import java.util.Collection;

public class QuickBarChart extends QuickChart<QuickBarChart, BarChartData> {

    public QuickBarChart() {
        super(new BarChartData());
    }

    public QuickBarChart addDataset(String label, Collection<? extends Number> data) {
        chartData.addDataset(new BarChartDataset().addData(data).setLabel(label));
        return this;
    }

    public QuickBarChart addDataset(String label, Number... data) {
        chartData.addDataset(new BarChartDataset().addData(data).setLabel(label));
        return this;
    }

    public QuickBarChart addDataset(Collection<? extends Number> data) {
        chartData.addDataset(new BarChartDataset().addData(data));
        return this;
    }

    public QuickBarChart addDataset(Number... data) {
        chartData.addDataset(new BarChartDataset().addData(data));
        return this;
    }

    @Override
    public String build() {
        return new BarChart()
                .setChartOptions(chartOptions)
                .setChartData(chartData.applyDefaultStylePerDataset())
                .build();
    }
}
