package de.yanwittmann.j2chartjs.quick;

import de.yanwittmann.j2chartjs.chart.DoughnutChart;
import de.yanwittmann.j2chartjs.data.DoughnutPieChartData;
import de.yanwittmann.j2chartjs.dataset.DoughnutPieChartDataset;
import org.json.JSONObject;

import java.util.Collection;

public class QuickDoughnutChart extends QuickChart<QuickDoughnutChart, DoughnutPieChartData> {

    public QuickDoughnutChart() {
        super(new DoughnutPieChartData());
    }

    public QuickDoughnutChart addDataset(String label, Collection<? extends Number> data) {
        chartData.addDataset(new DoughnutPieChartDataset().addData(data).setLabel(label));
        return this;
    }

    public QuickDoughnutChart addDataset(String label, Number... data) {
        chartData.addDataset(new DoughnutPieChartDataset().addData(data).setLabel(label));
        return this;
    }

    public QuickDoughnutChart addDataset(Collection<? extends Number> data) {
        chartData.addDataset(new DoughnutPieChartDataset().addData(data));
        return this;
    }

    public QuickDoughnutChart addDataset(Number... data) {
        chartData.addDataset(new DoughnutPieChartDataset().addData(data));
        return this;
    }

    @Override
    public JSONObject toJson() {
        return new DoughnutChart()
                .setChartOptions(chartOptions)
                .setChartData(chartData.applyDefaultStylePerDatapoint())
                .toJson();
    }
}
