package de.yanwittmann.j2chartjs.dataset;

import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unchecked")
public class BarChartDataset extends ChartDataset<BarChartDataset, BigDecimal> {

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

    private List<Color> backgroundColor = null;
    private List<Color> borderColor = null;
    private List<Integer> borderWidth = null;
    private List<Integer> borderRadius = null;
    private List<String> borderSkipped = null;
    private List<Color> hoverBackgroundColor = null;
    private List<Color> hoverBorderColor = null;
    private List<Integer> hoverBorderWidth = null;
    private List<Integer> hoverBorderRadius = null;
    private List<String> hoverBorderSkipped = null;

    public String getLabel() {
        return label;
    }

    public BarChartDataset setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getxAxisID() {
        return xAxisID;
    }

    public BarChartDataset setxAxisID(String xAxisID) {
        this.xAxisID = xAxisID;
        return this;
    }

    public String getyAxisID() {
        return yAxisID;
    }

    public BarChartDataset setyAxisID(String yAxisID) {
        this.yAxisID = yAxisID;
        return this;
    }

    public String getStack() {
        return stack;
    }

    public BarChartDataset setStack(String stack) {
        this.stack = stack;
        return this;
    }

    public String getIndexAxis() {
        return indexAxis;
    }

    public BarChartDataset setIndexAxis(String indexAxis) {
        this.indexAxis = indexAxis;
        return this;
    }

    public BigDecimal getBase() {
        return base;
    }

    public BarChartDataset setBase(int base) {
        this.base = new BigDecimal(base);
        return this;
    }

    public BarChartDataset setBase(double base) {
        this.base = new BigDecimal(base);
        return this;
    }

    public BarChartDataset setBase(BigDecimal base) {
        this.base = base;
        return this;
    }

    public BigDecimal getBarPercentage() {
        return barPercentage;
    }

    public BarChartDataset setBarPercentage(BigDecimal barPercentage) {
        this.barPercentage = barPercentage;
        return this;
    }

    public BarChartDataset setBarPercentage(int barPercentage) {
        this.barPercentage = new BigDecimal(barPercentage);
        return this;
    }

    public BarChartDataset setBarPercentage(double barPercentage) {
        this.barPercentage = new BigDecimal(barPercentage);
        return this;
    }

    public BigDecimal getBarThickness() {
        return barThickness;
    }

    public BarChartDataset setBarThickness(BigDecimal barThickness) {
        this.barThickness = barThickness;
        return this;
    }

    public BigDecimal getCategoryPercentage() {
        return categoryPercentage;
    }

    public BarChartDataset setCategoryPercentage(BigDecimal categoryPercentage) {
        this.categoryPercentage = categoryPercentage;
        return this;
    }

    public BigDecimal getMinBarLength() {
        return minBarLength;
    }

    public BarChartDataset setMinBarLength(BigDecimal minBarLength) {
        this.minBarLength = minBarLength;
        return this;
    }

    public BarChartDataset setMinBarLength(int minBarLength) {
        this.minBarLength = new BigDecimal(minBarLength);
        return this;
    }

    public BarChartDataset setMinBarLength(double minBarLength) {
        this.minBarLength = new BigDecimal(minBarLength);
        return this;
    }

    public Boolean getGrouped() {
        return grouped;
    }

    public BarChartDataset setGrouped(Boolean grouped) {
        this.grouped = grouped;
        return this;
    }

    public Boolean getSkipNull() {
        return skipNull;
    }

    public BarChartDataset setSkipNull(Boolean skipNull) {
        this.skipNull = skipNull;
        return this;
    }

    public BarChartDataset addBackgroundColor(Color... colors) {
        backgroundColor = Util.initializeListIfNull(backgroundColor);
        backgroundColor.addAll(Arrays.asList(colors));
        return this;
    }

    public BarChartDataset addBorderColor(Color... colors) {
        borderColor = Util.initializeListIfNull(borderColor);
        borderColor.addAll(Arrays.asList(colors));
        return this;
    }

    public BarChartDataset addBorderWidth(Integer... widths) {
        borderWidth = Util.initializeListIfNull(borderWidth);
        borderWidth.addAll(Arrays.asList(widths));
        return this;
    }

    public BarChartDataset addBorderRadius(Integer... radiuses) {
        borderRadius = Util.initializeListIfNull(borderRadius);
        borderRadius.addAll(Arrays.asList(radiuses));
        return this;
    }

    public BarChartDataset addBorderSkipped(String... edges) {
        borderSkipped = Util.initializeListIfNull(borderSkipped);
        borderSkipped.addAll(Arrays.asList(edges));
        return this;
    }

    public BarChartDataset addHoverBackgroundColor(Color... colors) {
        hoverBackgroundColor = Util.initializeListIfNull(hoverBackgroundColor);
        hoverBackgroundColor.addAll(Arrays.asList(colors));
        return this;
    }

    public BarChartDataset addHoverBorderColor(Color... colors) {
        hoverBorderColor = Util.initializeListIfNull(hoverBorderColor);
        hoverBorderColor.addAll(Arrays.asList(colors));
        return this;
    }

    public BarChartDataset addHoverBorderWidth(Integer... widths) {
        hoverBorderWidth = Util.initializeListIfNull(hoverBorderWidth);
        hoverBorderWidth.addAll(Arrays.asList(widths));
        return this;
    }

    public BarChartDataset addHoverBorderRadius(Integer... radiuses) {
        hoverBorderRadius = Util.initializeListIfNull(hoverBorderRadius);
        hoverBorderRadius.addAll(Arrays.asList(radiuses));
        return this;
    }

    public BarChartDataset addHoverBorderSkipped(String... edges) {
        hoverBorderSkipped = Util.initializeListIfNull(hoverBorderSkipped);
        hoverBorderSkipped.addAll(Arrays.asList(edges));
        return this;
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
        Util.smartAddToJsonObject(datasetJson, "backgroundColor", backgroundColor);
        Util.smartAddToJsonObject(datasetJson, "borderColor", borderColor);
        Util.smartAddToJsonObject(datasetJson, "borderWidth", borderWidth);
        Util.smartAddToJsonObject(datasetJson, "borderRadius", borderRadius);
        Util.smartAddToJsonObject(datasetJson, "borderSkipped", borderSkipped);
        Util.smartAddToJsonObject(datasetJson, "hoverBackgroundColor", hoverBackgroundColor);
        Util.smartAddToJsonObject(datasetJson, "hoverBorderColor", hoverBorderColor);
        Util.smartAddToJsonObject(datasetJson, "hoverBorderWidth", hoverBorderWidth);
        Util.smartAddToJsonObject(datasetJson, "hoverBorderRadius", hoverBorderRadius);
        Util.smartAddToJsonObject(datasetJson, "hoverBorderSkipped", hoverBorderSkipped);
        return datasetJson;
    }
}
