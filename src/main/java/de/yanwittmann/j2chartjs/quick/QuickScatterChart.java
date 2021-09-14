package de.yanwittmann.j2chartjs.quick;

import de.yanwittmann.j2chartjs.chart.ScatterChart;
import de.yanwittmann.j2chartjs.data.ScatterChartData;
import de.yanwittmann.j2chartjs.datapoint.ScatterChartDatapoint;
import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import de.yanwittmann.j2chartjs.dataset.ScatterChartDataset;
import org.json.JSONObject;

import java.util.Collection;

public class QuickScatterChart extends QuickChart<QuickScatterChart, ScatterChartData> {

    public QuickScatterChart() {
        super(new ScatterChartData());
    }

    public QuickScatterChart addDatasets(String label, QuickScatterChartDataset... datasets) {
        for (QuickScatterChartDataset dataset : datasets) {
            chartData.addDataset(new ScatterChartDataset().addData(dataset.toDatapoints()).setLabel(label));
        }
        return this;
    }

    public QuickScatterChart addDatasets(String label, Collection<QuickScatterChartDataset> datasets) {
        for (QuickScatterChartDataset dataset : datasets) {
            chartData.addDataset(new ScatterChartDataset().addData(dataset.toDatapoints()).setLabel(label));
        }
        return this;
    }

    public QuickScatterChart addDatasets(QuickScatterChartDataset... datasets) {
        for (QuickScatterChartDataset dataset : datasets) {
            chartData.addDataset(new ScatterChartDataset().addData(dataset.toDatapoints()));
        }
        return this;
    }

    public QuickScatterChart addDatasets(Collection<QuickScatterChartDataset> datasets) {
        for (QuickScatterChartDataset dataset : datasets) {
            chartData.addDataset(new ScatterChartDataset().addData(dataset.toDatapoints()));
        }
        return this;
    }

    public QuickScatterChart setPointWidth(int width) {
        for (ChartDataset<ScatterChartDataset, ScatterChartDatapoint> dataset : chartData.getDatasets()) {
            ((ScatterChartDataset) dataset).addBorderRadius(width);
        }
        return this;
    }

    public QuickScatterChart setShowLine(Boolean showLine) {
        for (ChartDataset<ScatterChartDataset, ScatterChartDatapoint> dataset : chartData.getDatasets()) {
            ((ScatterChartDataset) dataset).setShowLine(showLine);
        }
        return this;
    }

    @Override
    public JSONObject toJson() {
        return new ScatterChart()
                .setChartOptions(chartOptions)
                .setChartData(chartData.applyDefaultStylePerDataset())
                .toJson();
    }
}
