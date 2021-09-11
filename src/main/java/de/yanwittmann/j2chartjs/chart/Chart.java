package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.ChartData;
import de.yanwittmann.j2chartjs.options.ChartOption;
import org.json.JSONObject;

/**
 * @param <C>  Supertype of this class
 * @param <T>  Supertype of the <code>ChartData</code>
 * @param <DT> Supertype of the <code>ChartDataset</code>
 * @param <D>  Datatype of the <code>ChartDataset</code>
 */
@SuppressWarnings("unchecked")
public abstract class Chart<C, T, DT, D> {

    protected final String typeIdentifier;
    protected ChartData<T, DT, D> chartData;
    protected ChartOption chartOption;

    protected Chart(String typeIdentifier) {
        this.typeIdentifier = typeIdentifier;
    }

    public ChartData<T, DT, D> getChartData() {
        return chartData;
    }

    public C setChartData(ChartData<T, DT, D> chartData) {
        this.chartData = chartData;
        return (C) this;
    }

    public ChartOption getChartOptions() {
        return chartOption;
    }

    public C setChartOptions(ChartOption chartOption) {
        this.chartOption = chartOption;
        return (C) this;
    }

    public abstract JSONObject toJson();
}
