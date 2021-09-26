package de.yanwittmann.j2chartjs.data;

import de.yanwittmann.j2chartjs.dataset.ChartDataset;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @param <T>  Supertype of the <code>ChartData</code>
 * @param <DT> Supertype of the <code>ChartDataset</code>
 * @param <D>  Datatype of the <code>ChartDataset</code>
 */
@SuppressWarnings("unchecked")
public abstract class ChartData<T, DT, D> {

    protected List<String> labels = new ArrayList<>();
    protected List<ChartDataset<DT, D>> datasets = new ArrayList<>();

    public T addDataset(ChartDataset<DT, D>... datasets) {
        this.datasets.addAll(Arrays.asList(datasets));
        return (T) this;
    }

    public T removeDataset(ChartDataset<DT, D> dataset) {
        datasets.remove(dataset);
        return (T) this;
    }

    public List<ChartDataset<DT, D>> getDatasets() {
        return datasets;
    }

    public T setLabels(Collection<String> labels) {
        this.labels.clear();
        if (labels != null) this.labels.addAll(labels);
        return (T) this;
    }

    public T setLabels(String... labels) {
        this.labels.clear();
        this.labels.addAll(Arrays.asList(labels));
        return (T) this;
    }

    public T addLabels(Collection<String> labels) {
        this.labels.addAll(labels);
        return (T) this;
    }

    public T addLabels(String... labels) {
        this.labels.addAll(Arrays.asList(labels));
        return (T) this;
    }

    public List<String> getLabels() {
        return labels;
    }

    public JSONObject toJson() {
        JSONObject chartData = new JSONObject();
        int requiredLabels = datasets.stream().mapToInt(d -> d.getData().size()).max().orElse(0);
        if (labels.size() >= requiredLabels) {
            chartData.put("labels", labels);
        } else {
            List<String> completeLabels = new ArrayList<>(labels);
            completeLabels.addAll(IntStream.range(labels.size(), requiredLabels).mapToObj(d -> "").collect(Collectors.toList()));
            chartData.put("labels", completeLabels);
        }
        if (datasets != null) {
            JSONArray chartDatasets = new JSONArray();
            for (ChartDataset<DT, D> genericDataset : datasets) {
                chartDatasets.put(genericDataset.toJson());
            }
            chartData.put("datasets", chartDatasets);
        }
        return chartData;
    }

    public abstract T applyDefaultStylePerDatapoint();

    public abstract T applyDefaultStylePerDataset();
}
