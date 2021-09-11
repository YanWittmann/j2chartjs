package de.yanwittmann.j2chartjs.chart;

import de.yanwittmann.j2chartjs.data.ChartData;
import de.yanwittmann.j2chartjs.options.ChartOptions;
import org.json.JSONObject;

public abstract class Chart<T, DT, D> {

    protected final String typeIdentifier;
    protected ChartData<T, DT, D> chartData;
    protected ChartOptions chartOptions;

    protected Chart(String typeIdentifier) {
        this.typeIdentifier = typeIdentifier;
    }

    public ChartData<T, DT, D> getChartData() {
        return chartData;
    }

    public void setChartData(ChartData<T, DT, D> chartData) {
        this.chartData = chartData;
    }

    public ChartOptions getChartOptions() {
        return chartOptions;
    }

    public void setChartOptions(ChartOptions chartOptions) {
        this.chartOptions = chartOptions;
    }

    public abstract JSONObject toJson();
}
