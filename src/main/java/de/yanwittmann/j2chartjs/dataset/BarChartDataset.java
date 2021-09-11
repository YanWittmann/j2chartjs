package de.yanwittmann.j2chartjs.dataset;

import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.math.BigDecimal;

/**
 * <a href="https://www.chartjs.org/docs/latest/charts/bar.html#dataset-properties">Properties documentation</a>.
 */
public class BarChartDataset extends BackgroundBorderHoverChartDataset<BarChartDataset, BigDecimal> {

    private String label;
    private String xAxisID;
    private String yAxisID;
    private String stack;
    private String indexAxis;
    private BigDecimal base;
    private BigDecimal barPercentage;
    private BigDecimal barThickness;
    private BigDecimal categoryPercentage;
    private BigDecimal minBarLength;
    private Boolean grouped;
    private Boolean skipNull;

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

    public BarChartDataset setStack(String stack) {
        this.stack = stack;
        return this;
    }

    public BarChartDataset setIndexAxis(String indexAxis) {
        this.indexAxis = indexAxis;
        return this;
    }

    public BarChartDataset setBase(int base) {
        this.base = new BigDecimal(base);
        return this;
    }

    public BarChartDataset setBarPercentage(int barPercentage) {
        this.barPercentage = new BigDecimal(barPercentage);
        return this;
    }

    public BarChartDataset setBarThickness(int barThickness) {
        this.barThickness = new BigDecimal(barThickness);
        return this;
    }

    public BarChartDataset setCategoryPercentage(int categoryPercentage) {
        this.categoryPercentage = new BigDecimal(categoryPercentage);
        return this;
    }

    public BarChartDataset setMinBarLength(int minBarLength) {
        this.minBarLength = new BigDecimal(minBarLength);
        return this;
    }

    public BarChartDataset setBarPercentage(double barPercentage) {
        this.barPercentage = new BigDecimal(barPercentage);
        return this;
    }

    public BarChartDataset setBarThickness(double barThickness) {
        this.barThickness = new BigDecimal(barThickness);
        return this;
    }

    public BarChartDataset setCategoryPercentage(double categoryPercentage) {
        this.categoryPercentage = new BigDecimal(categoryPercentage);
        return this;
    }

    public BarChartDataset setMinBarLength(double minBarLength) {
        this.minBarLength = new BigDecimal(minBarLength);
        return this;
    }

    public BarChartDataset setGrouped(boolean grouped) {
        this.grouped = grouped;
        return this;
    }

    public BarChartDataset setSkipNull(boolean skipNull) {
        this.skipNull = skipNull;
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

    public String getStack() {
        return stack;
    }

    public String getIndexAxis() {
        return indexAxis;
    }

    public BigDecimal getBase() {
        return base;
    }

    public BigDecimal getBarPercentage() {
        return barPercentage;
    }

    public BigDecimal getBarThickness() {
        return barThickness;
    }

    public BigDecimal getCategoryPercentage() {
        return categoryPercentage;
    }

    public BigDecimal getMinBarLength() {
        return minBarLength;
    }

    public boolean isGrouped() {
        return grouped;
    }

    public boolean isSkipNull() {
        return skipNull;
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

    @Override
    public JSONObject toJson() {
        JSONObject datasetJson = new JSONObject();
        datasetJson.put("data", data);
        if (label != null) datasetJson.put("label", label);
        if (xAxisID != null) datasetJson.put("xAxisID", xAxisID);
        if (yAxisID != null) datasetJson.put("yAxisID", yAxisID);
        if (stack != null) datasetJson.put("stack", stack);
        if (indexAxis != null) datasetJson.put("indexAxis", indexAxis);
        if (base != null) datasetJson.put("base", base);
        if (barPercentage != null)
            datasetJson.put("barPercentage", Util.roundToDecimals(Double.parseDouble(barPercentage.toString()), 3));
        if (barThickness != null) datasetJson.put("barThickness", barThickness);
        if (categoryPercentage != null) datasetJson.put("categoryPercentage", categoryPercentage);
        if (minBarLength != null) datasetJson.put("minBarLength", minBarLength);
        if (grouped != null) datasetJson.put("grouped", grouped);
        if (stack != null) datasetJson.put("skipNull", skipNull);
        Util.deepMerge(bbhToJson(), datasetJson);
        return datasetJson;
    }
}
