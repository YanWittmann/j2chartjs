package de.yanwittmann.j2chartjs.dataset;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class ChartDataset<T, D> {

    protected final List<D> data = new ArrayList<>();

    public T setData(Collection<? extends D> data) {
        clearData();
        this.data.addAll(data);
        return (T) this;
    }

    public T setData(D... data) {
        clearData();
        this.data.addAll(Arrays.asList(data));
        return (T) this;
    }

    public T addData(Collection<? extends D> data) {
        this.data.addAll(data);
        return (T) this;
    }

    public T addData(D... data) {
        this.data.addAll(Arrays.asList(data));
        return (T) this;
    }

    public List<D> getData() {
        return data;
    }

    public T clearData() {
        data.clear();
        return (T) this;
    }

    public abstract JSONObject toJson();
}
