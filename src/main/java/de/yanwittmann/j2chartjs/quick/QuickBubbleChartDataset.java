package de.yanwittmann.j2chartjs.quick;

import de.yanwittmann.j2chartjs.datapoint.BubbleChartDatapoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class QuickBubbleChartDataset {

    private final List<Number> x = new ArrayList<>();
    private final List<Number> y = new ArrayList<>();
    private final List<Number> r = new ArrayList<>();

    public QuickBubbleChartDataset addX(Number... data) {
        x.addAll(Arrays.asList(data));
        return this;
    }

    public QuickBubbleChartDataset addY(Number... data) {
        y.addAll(Arrays.asList(data));
        return this;
    }

    public QuickBubbleChartDataset addR(Number... data) {
        r.addAll(Arrays.asList(data));
        return this;
    }

    public QuickBubbleChartDataset addXYR(Number x, Number y, Number r) {
        this.x.add(x);
        this.y.add(y);
        this.r.add(r);
        return this;
    }

    public QuickBubbleChartDataset addX(Collection<Number> data) {
        x.addAll(data);
        return this;
    }

    public QuickBubbleChartDataset addY(Collection<Number> data) {
        y.addAll(data);
        return this;
    }

    public QuickBubbleChartDataset addR(Collection<Number> data) {
        r.addAll(data);
        return this;
    }

    public List<BubbleChartDatapoint> toDatapoints() {
        List<BubbleChartDatapoint> datapoints = new ArrayList<>();
        for (int i = 0; i < x.size() || i < y.size() || i < r.size(); i++) {
            datapoints.add(new BubbleChartDatapoint(
                    i < x.size() ? x.get(i) : 0,
                    i < y.size() ? y.get(i) : 0,
                    i < r.size() ? r.get(i) : 0
            ));
        }
        return datapoints;
    }
}
