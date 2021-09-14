package de.yanwittmann.j2chartjs.quick;

import de.yanwittmann.j2chartjs.chart.PieChart;
import de.yanwittmann.j2chartjs.data.DoughnutPieChartData;
import de.yanwittmann.j2chartjs.dataset.DoughnutPieChartDataset;
import org.json.JSONObject;

import java.util.Collection;

public class QuickPieChart extends QuickChart<QuickPieChart, DoughnutPieChartData> {

    public QuickPieChart() {
        super(new DoughnutPieChartData());
    }

    public QuickPieChart addDataset(String label, Collection<? extends Number> data) {
        chartData.addDataset(new DoughnutPieChartDataset().addData(data).setLabel(label));
        return this;
    }

    public QuickPieChart addDataset(String label, Number... data) {
        chartData.addDataset(new DoughnutPieChartDataset().addData(data).setLabel(label));
        return this;
    }

    public QuickPieChart addDataset(Collection<? extends Number> data) {
        chartData.addDataset(new DoughnutPieChartDataset().addData(data));
        return this;
    }

    public QuickPieChart addDataset(Number... data) {
        chartData.addDataset(new DoughnutPieChartDataset().addData(data));
        return this;
    }

    @Override
    public JSONObject toJson() {
        return new PieChart()
                .setChartOptions(chartOptions)
                .setChartData(chartData.applyDefaultStylePerDatapoint())
                .toJson();
    }
}
