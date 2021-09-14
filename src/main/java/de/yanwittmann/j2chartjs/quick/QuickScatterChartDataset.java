package de.yanwittmann.j2chartjs.quick;

import de.yanwittmann.j2chartjs.datapoint.ScatterChartDatapoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class QuickScatterChartDataset {

    private final List<Number> x = new ArrayList<>();
    private final List<Number> y = new ArrayList<>();

    public QuickScatterChartDataset addX(Number... data) {
        x.addAll(Arrays.asList(data));
        return this;
    }

    public QuickScatterChartDataset addY(Number... data) {
        y.addAll(Arrays.asList(data));
        return this;
    }

    public QuickScatterChartDataset addX(Collection<Number> data) {
        x.addAll(data);
        return this;
    }

    public QuickScatterChartDataset addY(Collection<Number> data) {
        y.addAll(data);
        return this;
    }

    public List<ScatterChartDatapoint> toDatapoints() {
        List<ScatterChartDatapoint> datapoints = new ArrayList<>();
        for (int i = 0; i < x.size() || i < y.size(); i++) {
            datapoints.add(new ScatterChartDatapoint(
                    i < x.size() ? x.get(i) : 0,
                    i < y.size() ? y.get(i) : 0
            ));
        }
        return datapoints;
    }
}
