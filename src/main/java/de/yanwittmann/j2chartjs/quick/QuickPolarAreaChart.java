package de.yanwittmann.j2chartjs.quick;

import de.yanwittmann.j2chartjs.chart.PolarAreaChart;
import de.yanwittmann.j2chartjs.data.PolarAreaChartData;
import de.yanwittmann.j2chartjs.dataset.PolarAreaChartDataset;

import java.util.Collection;

public class QuickPolarAreaChart extends QuickChart<QuickPolarAreaChart, PolarAreaChartData> {

    public QuickPolarAreaChart() {
        super(new PolarAreaChartData());
    }

    public QuickPolarAreaChart addDataset(String label, Collection<? extends Number> data) {
        chartData.addDataset(new PolarAreaChartDataset().addData(data).setLabel(label));
        return this;
    }

    public QuickPolarAreaChart addDataset(String label, Number... data) {
        chartData.addDataset(new PolarAreaChartDataset().addData(data).setLabel(label));
        return this;
    }

    public QuickPolarAreaChart addDataset(Collection<? extends Number> data) {
        chartData.addDataset(new PolarAreaChartDataset().addData(data));
        return this;
    }

    public QuickPolarAreaChart addDataset(Number... data) {
        chartData.addDataset(new PolarAreaChartDataset().addData(data));
        return this;
    }

    @Override
    public String build() {
        return new PolarAreaChart()
                .setChartOptions(chartOptions)
                .setChartData(chartData.applyDefaultStylePerDatapoint())
                .build();
    }
}
