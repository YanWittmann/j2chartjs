package de.yanwittmann.j2chartjs.dataset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class ChartDataset<T, D> {

    protected final List<D> data = new ArrayList<>();

    public T addData(D... data) {
        this.data.addAll(Arrays.asList(data));
        return (T) this;
    }

    public List<D> getData() {
        return data;
    }

    public void clearData() {
        data.clear();
    }
}
