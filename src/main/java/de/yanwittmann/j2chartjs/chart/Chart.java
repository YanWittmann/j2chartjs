package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.ChartData;
import de.yanwittmann.j2chartjs.options.ChartOptions;
import de.yanwittmann.util.Util;
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

    private JSONObject toJson() {
        JSONObject chartDefinition = new JSONObject();
        Util.addToJson(chartDefinition, "type", typeIdentifier);
        Util.addToJson(chartDefinition, "data", chartData);
        Util.addToJson(chartDefinition, "options", chartOptions);
        return chartDefinition;
    }

    private String prepareBuild() {
        return toJson().toString();
    }

    public String build() {
        return Util.finalizeBuildString(prepareBuild());
    }

    @Override
    public String toString() {
        return build();
    }
}
