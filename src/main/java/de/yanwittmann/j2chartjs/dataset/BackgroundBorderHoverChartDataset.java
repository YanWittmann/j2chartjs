package de.yanwittmann.j2chartjs.dataset;

import de.yanwittmann.util.Util;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class BackgroundBorderHoverChartDataset<T, D> extends ChartDataset<T, D> {
    protected List<Color> backgroundColor = null;
    protected List<Color> borderColor = null;
    protected List<Integer> borderWidth = null;
    protected List<Color> hoverBackgroundColor = null;
    protected List<Color> hoverBorderColor = null;
    protected List<Integer> hoverBorderWidth = null;

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

    public void setBackgroundColor(List<Color> backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setBorderColor(List<Color> borderColor) {
        this.borderColor = borderColor;
    }

    public void setBorderWidth(List<Integer> borderWidth) {
        this.borderWidth = borderWidth;
    }

    public void setHoverBackgroundColor(List<Color> hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public void setHoverBorderColor(List<Color> hoverBorderColor) {
        this.hoverBorderColor = hoverBorderColor;
    }

    public void setHoverBorderWidth(List<Integer> hoverBorderWidth) {
        this.hoverBorderWidth = hoverBorderWidth;
    }

    public List<Color> getBackgroundColor() {
        return backgroundColor;
    }

    public List<Color> getBorderColor() {
        return borderColor;
    }

    public List<Color> getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public List<Color> getHoverBorderColor() {
        return hoverBorderColor;
    }

    public List<Integer> getBorderWidth() {
        return borderWidth;
    }

    public List<Integer> getHoverBorderWidth() {
        return hoverBorderWidth;
    }
}
