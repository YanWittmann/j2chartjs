package de.yanwittmann.j2chartjs.dataset;

import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unchecked")
public class PolarAreaChartDataset extends ChartDataset<PolarAreaChartDataset, BigDecimal> {

    private String label;

    /**
     * Arc background color.
     */
    private List<Color> backgroundColor = null;
    /**
     * Arc border borderColor.
     */
    private List<Color> borderColor = null;
    /**
     * Arc border width (in pixels).
     */
    private List<Integer> borderWidth = null;
    /**
     * Arc offset (in pixels).
     */
    private List<Integer> offset = null;
    /**
     * Arc background color when hovered.
     */
    private List<Color> hoverBackgroundColor = null;
    /**
     * Arc border borderColor when hovered.
     */
    private List<Color> hoverBorderColor = null;
    /**
     * Arc border width (in pixels) when hovered.
     */
    private List<Integer> hoverBorderWidth = null;
    /**
     * Arc offset (in pixels) when hovered.
     */
    private List<Integer> hoverOffset = null;
    /**
     * Fixed arc offset (in pixels). Similar to <code>offset</code> but applies to all arcs.
     */
    private List<Integer> spacing = null;
    /**
     * When <code>center</code> is set, the borders of arcs next to each other will overlap.<br>
     * When <code>inner</code> is set, it is guaranteed that all the borders do not overlap.
     */
    private List<String> borderAlign = null;

    public String getLabel() {
        return label;
    }

    public PolarAreaChartDataset setLabel(String label) {
        this.label = label;
        return this;
    }

    public List<Color> getBackgroundColor() {
        return backgroundColor;
    }

    public PolarAreaChartDataset setBackgroundColor(List<Color> backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public List<Color> getBorderColor() {
        return borderColor;
    }

    public PolarAreaChartDataset setBorderColor(List<Color> borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public List<Integer> getBorderWidth() {
        return borderWidth;
    }

    public PolarAreaChartDataset setBorderWidth(List<Integer> borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public List<Integer> getOffset() {
        return offset;
    }

    public PolarAreaChartDataset setOffset(List<Integer> offset) {
        this.offset = offset;
        return this;
    }

    public List<Color> getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public PolarAreaChartDataset setHoverBackgroundColor(List<Color> hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
        return this;
    }

    public List<Color> getHoverBorderColor() {
        return hoverBorderColor;
    }

    public PolarAreaChartDataset setHoverBorderColor(List<Color> hoverBorderColor) {
        this.hoverBorderColor = hoverBorderColor;
        return this;
    }

    public List<Integer> getHoverBorderWidth() {
        return hoverBorderWidth;
    }

    public PolarAreaChartDataset setHoverBorderWidth(List<Integer> hoverBorderWidth) {
        this.hoverBorderWidth = hoverBorderWidth;
        return this;
    }

    public List<Integer> getHoverOffset() {
        return hoverOffset;
    }

    public PolarAreaChartDataset setHoverOffset(List<Integer> hoverOffset) {
        this.hoverOffset = hoverOffset;
        return this;
    }

    public List<Integer> getSpacing() {
        return spacing;
    }

    public PolarAreaChartDataset setSpacing(List<Integer> spacing) {
        this.spacing = spacing;
        return this;
    }

    public List<String> getBorderAlign() {
        return borderAlign;
    }

    public PolarAreaChartDataset setBorderAlign(List<String> borderAlign) {
        this.borderAlign = borderAlign;
        return this;
    }

    public PolarAreaChartDataset addBackgroundColor(Color... colors) {
        backgroundColor = Util.initializeListIfNull(backgroundColor);
        backgroundColor.addAll(Arrays.asList(colors));
        return this;
    }

    public PolarAreaChartDataset addBorderColor(Color... colors) {
        borderColor = Util.initializeListIfNull(borderColor);
        borderColor.addAll(Arrays.asList(colors));
        return this;
    }

    public PolarAreaChartDataset addBorderWidth(Integer... widths) {
        borderWidth = Util.initializeListIfNull(borderWidth);
        borderWidth.addAll(Arrays.asList(widths));
        return this;
    }

    public PolarAreaChartDataset addOffset(Integer... offsets) {
        offset = Util.initializeListIfNull(offset);
        offset.addAll(Arrays.asList(offsets));
        return this;
    }

    public PolarAreaChartDataset addSpacing(Integer... spacings) {
        spacing = Util.initializeListIfNull(spacing);
        spacing.addAll(Arrays.asList(spacings));
        return this;
    }

    public PolarAreaChartDataset addHoverBackgroundColor(Color... colors) {
        hoverBackgroundColor = Util.initializeListIfNull(hoverBackgroundColor);
        hoverBackgroundColor.addAll(Arrays.asList(colors));
        return this;
    }

    public PolarAreaChartDataset addHoverBorderColor(Color... colors) {
        hoverBorderColor = Util.initializeListIfNull(hoverBorderColor);
        hoverBorderColor.addAll(Arrays.asList(colors));
        return this;
    }

    public PolarAreaChartDataset addHoverBorderWidth(Integer... widths) {
        hoverBorderWidth = Util.initializeListIfNull(hoverBorderWidth);
        hoverBorderWidth.addAll(Arrays.asList(widths));
        return this;
    }

    public PolarAreaChartDataset addHoverOffset(Integer... offsets) {
        hoverOffset = Util.initializeListIfNull(hoverOffset);
        hoverOffset.addAll(Arrays.asList(offsets));
        return this;
    }

    public PolarAreaChartDataset addBorderAlign(String... alignments) {
        borderAlign = Util.initializeListIfNull(borderAlign);
        borderAlign.addAll(Arrays.asList(alignments));
        return this;
    }

    public PolarAreaChartDataset setData(int... data) {
        clearData();
        for (int d : data) this.data.add(new BigDecimal(d));
        return this;
    }

    public PolarAreaChartDataset setData(double... data) {
        clearData();
        return addData(data);
    }

    public PolarAreaChartDataset addData(double... data) {
        for (double d : data) this.data.add(new BigDecimal(d));
        return this;
    }

    public PolarAreaChartDataset addData(int... data) {
        for (int d : data) this.data.add(new BigDecimal(d));
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject datasetJson = new JSONObject();
        Util.addToJson(datasetJson, "data", data);
        Util.addToJson(datasetJson, "label", label);
        Util.addToJson(datasetJson, "backgroundColor", backgroundColor);
        Util.addToJson(datasetJson, "borderColor", borderColor);
        Util.addToJson(datasetJson, "borderWidth", borderWidth);
        Util.addToJson(datasetJson, "offset", offset);
        Util.addToJson(datasetJson, "hoverBackgroundColor", hoverBackgroundColor);
        Util.addToJson(datasetJson, "hoverBorderColor", hoverBorderColor);
        Util.addToJson(datasetJson, "hoverBorderWidth", hoverBorderWidth);
        Util.addToJson(datasetJson, "hoverOffset", hoverOffset);
        Util.addToJson(datasetJson, "spacing", spacing);
        Util.addToJson(datasetJson, "borderAlign", borderAlign);
        return datasetJson;
    }
}
