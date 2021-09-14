package de.yanwittmann.j2chartjs.quick;

import de.yanwittmann.j2chartjs.chart.BubbleChart;
import de.yanwittmann.j2chartjs.data.BubbleChartData;
import de.yanwittmann.j2chartjs.dataset.BubbleChartDataset;
import org.json.JSONObject;

import java.util.Collection;

public class QuickBubbleChart extends QuickChart<QuickBubbleChart, BubbleChartData> {

    public QuickBubbleChart() {
        super(new BubbleChartData());
    }

    public QuickBubbleChart addDatasets(String label, QuickBubbleChartDataset... datasets) {
        for (QuickBubbleChartDataset dataset : datasets) {
            chartData.addDataset(new BubbleChartDataset().addData(dataset.toDatapoints()).setLabel(label));
        }
        return this;
    }

    public QuickBubbleChart addDatasets(String label, Collection<QuickBubbleChartDataset> datasets) {
        for (QuickBubbleChartDataset dataset : datasets) {
            chartData.addDataset(new BubbleChartDataset().addData(dataset.toDatapoints()).setLabel(label));
        }
        return this;
    }

    public QuickBubbleChart addDatasets(QuickBubbleChartDataset... datasets) {
        for (QuickBubbleChartDataset dataset : datasets) {
            chartData.addDataset(new BubbleChartDataset().addData(dataset.toDatapoints()));
        }
        return this;
    }

    public QuickBubbleChart addDatasets(Collection<QuickBubbleChartDataset> datasets) {
        for (QuickBubbleChartDataset dataset : datasets) {
            chartData.addDataset(new BubbleChartDataset().addData(dataset.toDatapoints()));
        }
        return this;
    }

    @Override
    public JSONObject toJson() {
        return new BubbleChart()
                .setChartOptions(chartOptions)
                .setChartData(chartData.applyDefaultStylePerDataset())
                .toJson();
    }
}
