package de.yanwittmann.j2chartjs.dataset;

import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class BackgroundBorderHoverChartDataset<T, D> extends ChartDataset<T, D> {
    protected List<Color> backgroundColor = null;
    protected List<Color> borderColor = null;
    protected List<Integer> borderWidth = null;
    protected List<Integer> borderRadius = null;
    protected List<String> borderSkipped = null;
    protected List<Color> hoverBackgroundColor = null;
    protected List<Color> hoverBorderColor = null;
    protected List<Integer> hoverBorderWidth = null;
    protected List<Integer> hoverBorderRadius = null;
    protected List<String> hoverBorderSkipped = null;

    public T addBackgroundColor(Color... colors) {
        backgroundColor = Util.initializeListIfNull(backgroundColor);
        backgroundColor.addAll(Arrays.asList(colors));
        return (T) this;
    }

    public T addBorderColor(Color... colors) {
        borderColor = Util.initializeListIfNull(borderColor);
        borderColor.addAll(Arrays.asList(colors));
        return (T) this;
    }

    public T addBorderWidth(Integer... widths) {
        borderWidth = Util.initializeListIfNull(borderWidth);
        borderWidth.addAll(Arrays.asList(widths));
        return (T) this;
    }

    public T addBorderRadius(Integer... radiuses) {
        borderRadius = Util.initializeListIfNull(borderRadius);
        borderRadius.addAll(Arrays.asList(radiuses));
        return (T) this;
    }

    public T addBorderSkipped(String... edges) {
        borderSkipped = Util.initializeListIfNull(borderSkipped);
        borderSkipped.addAll(Arrays.asList(edges));
        return (T) this;
    }

    public T addHoverBackgroundColor(Color... colors) {
        hoverBackgroundColor = Util.initializeListIfNull(hoverBackgroundColor);
        hoverBackgroundColor.addAll(Arrays.asList(colors));
        return (T) this;
    }

    public T addHoverBorderColor(Color... colors) {
        hoverBorderColor = Util.initializeListIfNull(hoverBorderColor);
        hoverBorderColor.addAll(Arrays.asList(colors));
        return (T) this;
    }

    public T addHoverBorderWidth(Integer... widths) {
        hoverBorderWidth = Util.initializeListIfNull(hoverBorderWidth);
        hoverBorderWidth.addAll(Arrays.asList(widths));
        return (T) this;
    }

    public T addHoverBorderRadius(Integer... radiuses) {
        hoverBorderRadius = Util.initializeListIfNull(hoverBorderRadius);
        hoverBorderRadius.addAll(Arrays.asList(radiuses));
        return (T) this;
    }

    public T addHoverBorderSkipped(String... edges) {
        hoverBorderSkipped = Util.initializeListIfNull(hoverBorderSkipped);
        hoverBorderSkipped.addAll(Arrays.asList(edges));
        return (T) this;
    }

    public List<Color> getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(List<Color> backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public List<Color> getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(List<Color> borderColor) {
        this.borderColor = borderColor;
    }

    public List<Integer> getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(List<Integer> borderWidth) {
        this.borderWidth = borderWidth;
    }

    public List<Integer> getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(List<Integer> borderRadius) {
        this.borderRadius = borderRadius;
    }

    public List<String> getBorderSkipped() {
        return borderSkipped;
    }

    public void setBorderSkipped(List<String> borderSkipped) {
        this.borderSkipped = borderSkipped;
    }

    public List<Color> getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(List<Color> hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public List<Color> getHoverBorderColor() {
        return hoverBorderColor;
    }

    public void setHoverBorderColor(List<Color> hoverBorderColor) {
        this.hoverBorderColor = hoverBorderColor;
    }

    public List<Integer> getHoverBorderWidth() {
        return hoverBorderWidth;
    }

    public void setHoverBorderWidth(List<Integer> hoverBorderWidth) {
        this.hoverBorderWidth = hoverBorderWidth;
    }

    public List<Integer> getHoverBorderRadius() {
        return hoverBorderRadius;
    }

    public void setHoverBorderRadius(List<Integer> hoverBorderRadius) {
        this.hoverBorderRadius = hoverBorderRadius;
    }

    public List<String> getHoverBorderSkipped() {
        return hoverBorderSkipped;
    }

    public void setHoverBorderSkipped(List<String> hoverBorderSkipped) {
        this.hoverBorderSkipped = hoverBorderSkipped;
    }

    public JSONObject bbhToJson() {
        JSONObject datasetJson = new JSONObject();
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
