package de.yanwittmann.j2chartjs.dataset;

import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unchecked")
public class BarChartDataset extends ChartDataset<BarChartDataset, Number> {

    private String label;
    private String xAxisID;
    private String yAxisID;
    private String stack;
    private String indexAxis;
    private Number base;
    private Number barPercentage;
    private Number barThickness;
    private Number categoryPercentage;
    private Number minBarLength;
    private Boolean grouped;
    private Boolean skipNull;

    private List<Color> backgroundColor = null;
    private List<Color> borderColor = null;
    private List<Number> borderWidth = null;
    private List<Number> borderRadius = null;
    private List<String> borderSkipped = null;
    private List<Color> hoverBackgroundColor = null;
    private List<Color> hoverBorderColor = null;
    private List<Number> hoverBorderWidth = null;
    private List<Number> hoverBorderRadius = null;
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

    public Number getBase() {
        return base;
    }

    public BarChartDataset setBase(int base) {
        this.base = base;
        return this;
    }

    public BarChartDataset setBase(double base) {
        this.base = base;
        return this;
    }

    public BarChartDataset setBase(Number base) {
        this.base = base;
        return this;
    }

    public Number getBarPercentage() {
        return barPercentage;
    }

    public BarChartDataset setBarPercentage(Number barPercentage) {
        this.barPercentage = barPercentage;
        return this;
    }

    public BarChartDataset setBarPercentage(int barPercentage) {
        this.barPercentage = barPercentage;
        return this;
    }

    public BarChartDataset setBarPercentage(double barPercentage) {
        this.barPercentage = barPercentage;
        return this;
    }

    public Number getBarThickness() {
        return barThickness;
    }

    public BarChartDataset setBarThickness(Number barThickness) {
        this.barThickness = barThickness;
        return this;
    }

    public Number getCategoryPercentage() {
        return categoryPercentage;
    }

    public BarChartDataset setCategoryPercentage(Number categoryPercentage) {
        this.categoryPercentage = categoryPercentage;
        return this;
    }

    public Number getMinBarLength() {
        return minBarLength;
    }

    public BarChartDataset setMinBarLength(Number minBarLength) {
        this.minBarLength = minBarLength;
        return this;
    }

    public BarChartDataset setMinBarLength(int minBarLength) {
        this.minBarLength = minBarLength;
        return this;
    }

    public BarChartDataset setMinBarLength(double minBarLength) {
        this.minBarLength = minBarLength;
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

    public List<Color> getBackgroundColor() {
        return backgroundColor;
    }

    public BarChartDataset setBackgroundColor(List<Color> backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public List<Color> getBorderColor() {
        return borderColor;
    }

    public BarChartDataset setBorderColor(List<Color> borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public List<Number> getBorderWidth() {
        return borderWidth;
    }

    public BarChartDataset setBorderWidth(List<Number> borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public List<Number> getBorderRadius() {
        return borderRadius;
    }

    public BarChartDataset setBorderRadius(List<Number> borderRadius) {
        this.borderRadius = borderRadius;
        return this;
    }

    public List<String> getBorderSkipped() {
        return borderSkipped;
    }

    public BarChartDataset setBorderSkipped(List<String> borderSkipped) {
        this.borderSkipped = borderSkipped;
        return this;
    }

    public List<Color> getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public BarChartDataset setHoverBackgroundColor(List<Color> hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
        return this;
    }

    public List<Color> getHoverBorderColor() {
        return hoverBorderColor;
    }

    public BarChartDataset setHoverBorderColor(List<Color> hoverBorderColor) {
        this.hoverBorderColor = hoverBorderColor;
        return this;
    }

    public List<Number> getHoverBorderWidth() {
        return hoverBorderWidth;
    }

    public BarChartDataset setHoverBorderWidth(List<Number> hoverBorderWidth) {
        this.hoverBorderWidth = hoverBorderWidth;
        return this;
    }

    public List<Number> getHoverBorderRadius() {
        return hoverBorderRadius;
    }

    public BarChartDataset setHoverBorderRadius(List<Number> hoverBorderRadius) {
        this.hoverBorderRadius = hoverBorderRadius;
        return this;
    }

    public List<String> getHoverBorderSkipped() {
        return hoverBorderSkipped;
    }

    public BarChartDataset setHoverBorderSkipped(List<String> hoverBorderSkipped) {
        this.hoverBorderSkipped = hoverBorderSkipped;
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

    public BarChartDataset addBorderWidth(Number... widths) {
        borderWidth = Util.initializeListIfNull(borderWidth);
        borderWidth.addAll(Arrays.asList(widths));
        return this;
    }

    public BarChartDataset addBorderRadius(Number... radiuses) {
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

    public BarChartDataset addHoverBorderWidth(Number... widths) {
        hoverBorderWidth = Util.initializeListIfNull(hoverBorderWidth);
        hoverBorderWidth.addAll(Arrays.asList(widths));
        return this;
    }

    public BarChartDataset addHoverBorderRadius(Number... radiuses) {
        hoverBorderRadius = Util.initializeListIfNull(hoverBorderRadius);
        hoverBorderRadius.addAll(Arrays.asList(radiuses));
        return this;
    }

    public BarChartDataset addHoverBorderSkipped(String... edges) {
        hoverBorderSkipped = Util.initializeListIfNull(hoverBorderSkipped);
        hoverBorderSkipped.addAll(Arrays.asList(edges));
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject datasetJson = new JSONObject();
        Util.addToJson(datasetJson, "data", data);
        Util.addToJson(datasetJson, "label", label);
        Util.addToJson(datasetJson, "xAxisID", xAxisID);
        Util.addToJson(datasetJson, "yAxisID", yAxisID);
        Util.addToJson(datasetJson, "stack", stack);
        Util.addToJson(datasetJson, "indexAxis", indexAxis);
        Util.addToJson(datasetJson, "base", base);
        Util.addToJson(datasetJson, "barPercentage", barPercentage);
        Util.addToJson(datasetJson, "barThickness", barThickness);
        Util.addToJson(datasetJson, "categoryPercentage", categoryPercentage);
        Util.addToJson(datasetJson, "minBarLength", minBarLength);
        Util.addToJson(datasetJson, "grouped", grouped);
        Util.addToJson(datasetJson, "skipNull", skipNull);
        Util.addToJson(datasetJson, "backgroundColor", backgroundColor);
        Util.addToJson(datasetJson, "borderColor", borderColor);
        Util.addToJson(datasetJson, "borderWidth", borderWidth);
        Util.addToJson(datasetJson, "borderRadius", borderRadius);
        Util.addToJson(datasetJson, "borderSkipped", borderSkipped);
        Util.addToJson(datasetJson, "hoverBackgroundColor", hoverBackgroundColor);
        Util.addToJson(datasetJson, "hoverBorderColor", hoverBorderColor);
        Util.addToJson(datasetJson, "hoverBorderWidth", hoverBorderWidth);
        Util.addToJson(datasetJson, "hoverBorderRadius", hoverBorderRadius);
        Util.addToJson(datasetJson, "hoverBorderSkipped", hoverBorderSkipped);
        return datasetJson;
    }
}
