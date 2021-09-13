package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.ChartData;
import de.yanwittmann.j2chartjs.options.ChartOptions;
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
    protected ChartOptions chartOptions;

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

    public ChartOptions getChartOptions() {
        return chartOptions;
    }

    public C setChartOptions(ChartOptions chartOptions) {
        this.chartOptions = chartOptions;
        return (C) this;
    }

    public JSONObject toJson() {
        JSONObject chartDefinition = new JSONObject();
        chartDefinition.put("type", typeIdentifier);
        if (chartData != null) chartDefinition.put("data", chartData.toJson());
        if (chartOptions != null) chartDefinition.put("options", chartOptions.toJson());
        return chartDefinition;
    }

    @Override
    public String toString() {
        return toJson().toString();
    }
}
