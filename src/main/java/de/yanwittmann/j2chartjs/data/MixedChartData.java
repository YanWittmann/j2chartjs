package de.yanwittmann.j2chartjs.data;

import de.yanwittmann.j2chartjs.dataset.*;
import de.yanwittmann.j2chartjs.preset.ChartColors;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MixedChartData {

    private List<String> labels = new ArrayList<>();
    private List<ChartDataset> datasets = new ArrayList<>();

    public MixedChartData addDataset(ChartDataset... dataset) {
        datasets.addAll(Arrays.asList(dataset));
        return this;
    }

    public MixedChartData removeDataset(ChartDataset dataset) {
        datasets.remove(dataset);
        return this;
    }

    public List<ChartDataset> getDatasets() {
        return datasets;
    }

    public MixedChartData setLabels(Collection<String> labels) {
        this.labels.clear();
        if (labels != null) this.labels.addAll(labels);
        return this;
    }

    public MixedChartData addLabels(String... label) {
        this.labels.addAll(Arrays.asList(label));
        return this;
    }

    public List<String> getLabels() {
        return labels;
    }

    public MixedChartData applyDefaultStylePerDatapoint() {
        datasets.forEach(ChartColors::applyDefaultStylePerDatapoint);
        return this;
    }

    public MixedChartData applyDefaultStylePerDataset() {
        datasets.forEach(ChartColors::applyDefaultStylePerDataset);
        return this;
    }

    public JSONObject toJson() {
        JSONObject chartData = new JSONObject();
        chartData.put("labels", getLabels());
        if (datasets != null) {
            JSONArray chartDatasets = new JSONArray();
            for (ChartDataset genericDataset : datasets) {
                JSONObject datasetJson = genericDataset.toJson();
                if (genericDataset instanceof BarChartDataset) {
                    datasetJson.put("type", "bar");
                } else if (genericDataset instanceof BubbleChartDataset) {
                    datasetJson.put("type", "bubble");
                } else if (genericDataset instanceof DoughnutPieChartDataset) {
                    datasetJson.put("type", "pie");
                } else if (genericDataset instanceof LineChartDataset) {
                    datasetJson.put("type", "line");
                } else if (genericDataset instanceof PolarAreaChartDataset) {
                    datasetJson.put("type", "polarArea");
                } else if (genericDataset instanceof RadarChartDataset) {
                    datasetJson.put("type", "radar");
                } else if (genericDataset instanceof ScatterChartDataset) {
                    datasetJson.put("type", "scatter");
                }
                chartDatasets.put(datasetJson);
            }
            chartData.put("datasets", chartDatasets);
        }
        return chartData;
    }
}