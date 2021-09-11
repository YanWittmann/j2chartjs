package de.yanwittmann.j2chartjs.dataset;

import java.math.BigDecimal;

public class BarChartDataset extends BackgroundBorderHoverChartDataset<BarChartDataset, BigDecimal> {

    private String label;
    private String xAxisID;
    private String yAxisID;

    public BarChartDataset setLabel(String label) {
        this.label = label;
        return this;
    }

    public BarChartDataset setXAxisID(String xAxisID) {
        this.xAxisID = xAxisID;
        return this;
    }

    public BarChartDataset setYAxisID(String yAxisID) {
        this.yAxisID = yAxisID;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public String getXAxisID() {
        return xAxisID;
    }

    public String getYAxisID() {
        return yAxisID;
    }

    public BarChartDataset setData(int... data) {
        clearData();
        for (int d : data) this.data.add(new BigDecimal(d));
        return this;
    }

    public BarChartDataset setData(double... data) {
        clearData();
        return addData(data);
    }

    public BarChartDataset addData(double... data) {
        for (double d : data) this.data.add(new BigDecimal(d));
        return this;
    }

    public BarChartDataset addData(int... data) {
        for (int d : data) this.data.add(new BigDecimal(d));
        return this;
    }
}
