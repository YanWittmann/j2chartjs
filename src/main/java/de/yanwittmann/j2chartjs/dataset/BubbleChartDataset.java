package de.yanwittmann.j2chartjs.dataset;

import de.yanwittmann.j2chartjs.datapoint.BubbleChartDatapoint;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class BubbleChartDataset extends ChartDataset<BubbleChartDataset, BubbleChartDatapoint> {

    private String label;
    private String xAxisID;
    private String yAxisID;

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
    /**
     * The rotation of the point in degrees.
     */
    private List<Integer> rotation = null;
    /**
     * Style of the point.<ul>
     * <li>circle</li>
     * <li>cross</li>
     * <li>crossRot</li>
     * <li>dash</li>
     * <li>line</li>
     * <li>rect</li>
     * <li>rectRounded</li>
     * <li>rectRot</li>
     * <li>star</li>
     * <li>triangle</li>
     * </ul>
     */
    private List<String> pointStyle = null;

    public String getLabel() {
        return label;
    }

    public BubbleChartDataset setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getxAxisID() {
        return xAxisID;
    }

    public BubbleChartDataset setxAxisID(String xAxisID) {
        this.xAxisID = xAxisID;
        return this;
    }

    public String getyAxisID() {
        return yAxisID;
    }

    public BubbleChartDataset setyAxisID(String yAxisID) {
        this.yAxisID = yAxisID;
        return this;
    }

    public List<Integer> getRotation() {
        return rotation;
    }

    public BubbleChartDataset setRotation(List<Integer> rotation) {
        this.rotation = rotation;
        return this;
    }

    public List<String> getPointStyle() {
        return pointStyle;
    }

    public BubbleChartDataset setPointStyle(List<String> pointStyle) {
        this.pointStyle = pointStyle;
        return this;
    }

    public List<Color> getBackgroundColor() {
        return backgroundColor;
    }

    public BubbleChartDataset setBackgroundColor(List<Color> backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public List<Color> getBorderColor() {
        return borderColor;
    }

    public BubbleChartDataset setBorderColor(List<Color> borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public List<Integer> getBorderWidth() {
        return borderWidth;
    }

    public BubbleChartDataset setBorderWidth(List<Integer> borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public List<Integer> getBorderRadius() {
        return borderRadius;
    }

    public BubbleChartDataset setBorderRadius(List<Integer> borderRadius) {
        this.borderRadius = borderRadius;
        return this;
    }

    public List<String> getBorderSkipped() {
        return borderSkipped;
    }

    public BubbleChartDataset setBorderSkipped(List<String> borderSkipped) {
        this.borderSkipped = borderSkipped;
        return this;
    }

    public List<Color> getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public BubbleChartDataset setHoverBackgroundColor(List<Color> hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
        return this;
    }

    public List<Color> getHoverBorderColor() {
        return hoverBorderColor;
    }

    public BubbleChartDataset setHoverBorderColor(List<Color> hoverBorderColor) {
        this.hoverBorderColor = hoverBorderColor;
        return this;
    }

    public List<Integer> getHoverBorderWidth() {
        return hoverBorderWidth;
    }

    public BubbleChartDataset setHoverBorderWidth(List<Integer> hoverBorderWidth) {
        this.hoverBorderWidth = hoverBorderWidth;
        return this;
    }

    public List<Integer> getHoverBorderRadius() {
        return hoverBorderRadius;
    }

    public BubbleChartDataset setHoverBorderRadius(List<Integer> hoverBorderRadius) {
        this.hoverBorderRadius = hoverBorderRadius;
        return this;
    }

    public List<String> getHoverBorderSkipped() {
        return hoverBorderSkipped;
    }

    public BubbleChartDataset setHoverBorderSkipped(List<String> hoverBorderSkipped) {
        this.hoverBorderSkipped = hoverBorderSkipped;
        return this;
    }

    public BubbleChartDataset addBackgroundColor(Color... colors) {
        backgroundColor = Util.initializeListIfNull(backgroundColor);
        backgroundColor.addAll(Arrays.asList(colors));
        return this;
    }

    public BubbleChartDataset addBorderColor(Color... colors) {
        borderColor = Util.initializeListIfNull(borderColor);
        borderColor.addAll(Arrays.asList(colors));
        return this;
    }

    public BubbleChartDataset addBorderWidth(Integer... widths) {
        borderWidth = Util.initializeListIfNull(borderWidth);
        borderWidth.addAll(Arrays.asList(widths));
        return this;
    }

    public BubbleChartDataset addBorderRadius(Integer... radiuses) {
        borderRadius = Util.initializeListIfNull(borderRadius);
        borderRadius.addAll(Arrays.asList(radiuses));
        return this;
    }

    public BubbleChartDataset addBorderSkipped(String... edges) {
        borderSkipped = Util.initializeListIfNull(borderSkipped);
        borderSkipped.addAll(Arrays.asList(edges));
        return this;
    }

    public BubbleChartDataset addHoverBackgroundColor(Color... colors) {
        hoverBackgroundColor = Util.initializeListIfNull(hoverBackgroundColor);
        hoverBackgroundColor.addAll(Arrays.asList(colors));
        return this;
    }

    public BubbleChartDataset addHoverBorderColor(Color... colors) {
        hoverBorderColor = Util.initializeListIfNull(hoverBorderColor);
        hoverBorderColor.addAll(Arrays.asList(colors));
        return this;
    }

    public BubbleChartDataset addHoverBorderWidth(Integer... widths) {
        hoverBorderWidth = Util.initializeListIfNull(hoverBorderWidth);
        hoverBorderWidth.addAll(Arrays.asList(widths));
        return this;
    }

    public BubbleChartDataset addHoverBorderRadius(Integer... radiuses) {
        hoverBorderRadius = Util.initializeListIfNull(hoverBorderRadius);
        hoverBorderRadius.addAll(Arrays.asList(radiuses));
        return this;
    }

    public BubbleChartDataset addHoverBorderSkipped(String... edges) {
        hoverBorderSkipped = Util.initializeListIfNull(hoverBorderSkipped);
        hoverBorderSkipped.addAll(Arrays.asList(edges));
        return this;
    }

    public BubbleChartDataset addPointStyle(String... styles) {
        pointStyle = Util.initializeListIfNull(pointStyle);
        pointStyle.addAll(Arrays.asList(styles));
        return this;
    }

    public BubbleChartDataset addRotation(Integer... rotations) {
        rotation = Util.initializeListIfNull(rotation);
        rotation.addAll(Arrays.asList(rotations));
        return this;
    }

    public BubbleChartDataset addData(BubbleChartDatapoint... datapoint) {
        this.data.addAll(Arrays.asList(datapoint));
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject datasetJson = new JSONObject();
        datasetJson.put("data", data.stream().map(BubbleChartDatapoint::toJson).collect(Collectors.toList()));
        if (label != null) datasetJson.put("label", label);
        if (xAxisID != null) datasetJson.put("xAxisID", xAxisID);
        if (yAxisID != null) datasetJson.put("yAxisID", yAxisID);
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
        Util.smartAddToJsonObject(datasetJson, "rotation", rotation);
        Util.smartAddToJsonObject(datasetJson, "pointStyle", pointStyle);
        return datasetJson;
    }
}
