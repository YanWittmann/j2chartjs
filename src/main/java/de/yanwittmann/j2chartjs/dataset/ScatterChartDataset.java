package de.yanwittmann.j2chartjs.dataset;

import de.yanwittmann.j2chartjs.datapoint.ScatterChartDatapoint;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class ScatterChartDataset extends ChartDataset<ScatterChartDataset, ScatterChartDatapoint> {

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
    /**
     * If true, the line will be drawn for this dataset.
     */
    private Boolean showLine;

    public String getLabel() {
        return label;
    }

    public ScatterChartDataset setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getxAxisID() {
        return xAxisID;
    }

    public ScatterChartDataset setxAxisID(String xAxisID) {
        this.xAxisID = xAxisID;
        return this;
    }

    public String getyAxisID() {
        return yAxisID;
    }

    public ScatterChartDataset setyAxisID(String yAxisID) {
        this.yAxisID = yAxisID;
        return this;
    }

    public List<Integer> getRotation() {
        return rotation;
    }

    public ScatterChartDataset setRotation(List<Integer> rotation) {
        this.rotation = rotation;
        return this;
    }

    public List<String> getPointStyle() {
        return pointStyle;
    }

    public ScatterChartDataset setPointStyle(List<String> pointStyle) {
        this.pointStyle = pointStyle;
        return this;
    }

    public List<Color> getBackgroundColor() {
        return backgroundColor;
    }

    public ScatterChartDataset setBackgroundColor(List<Color> backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public List<Color> getBorderColor() {
        return borderColor;
    }

    public ScatterChartDataset setBorderColor(List<Color> borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public List<Integer> getBorderWidth() {
        return borderWidth;
    }

    public ScatterChartDataset setBorderWidth(List<Integer> borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public List<Integer> getBorderRadius() {
        return borderRadius;
    }

    public ScatterChartDataset setBorderRadius(List<Integer> borderRadius) {
        this.borderRadius = borderRadius;
        return this;
    }

    public List<String> getBorderSkipped() {
        return borderSkipped;
    }

    public ScatterChartDataset setBorderSkipped(List<String> borderSkipped) {
        this.borderSkipped = borderSkipped;
        return this;
    }

    public List<Color> getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public ScatterChartDataset setHoverBackgroundColor(List<Color> hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
        return this;
    }

    public List<Color> getHoverBorderColor() {
        return hoverBorderColor;
    }

    public ScatterChartDataset setHoverBorderColor(List<Color> hoverBorderColor) {
        this.hoverBorderColor = hoverBorderColor;
        return this;
    }

    public List<Integer> getHoverBorderWidth() {
        return hoverBorderWidth;
    }

    public ScatterChartDataset setHoverBorderWidth(List<Integer> hoverBorderWidth) {
        this.hoverBorderWidth = hoverBorderWidth;
        return this;
    }

    public List<Integer> getHoverBorderRadius() {
        return hoverBorderRadius;
    }

    public ScatterChartDataset setHoverBorderRadius(List<Integer> hoverBorderRadius) {
        this.hoverBorderRadius = hoverBorderRadius;
        return this;
    }

    public List<String> getHoverBorderSkipped() {
        return hoverBorderSkipped;
    }

    public ScatterChartDataset setHoverBorderSkipped(List<String> hoverBorderSkipped) {
        this.hoverBorderSkipped = hoverBorderSkipped;
        return this;
    }

    public Boolean getShowLine() {
        return showLine;
    }

    public ScatterChartDataset setShowLine(Boolean showLine) {
        this.showLine = showLine;
        return this;
    }

    public ScatterChartDataset addBackgroundColor(Color... colors) {
        backgroundColor = Util.initializeListIfNull(backgroundColor);
        backgroundColor.addAll(Arrays.asList(colors));
        return this;
    }

    public ScatterChartDataset addBorderColor(Color... colors) {
        borderColor = Util.initializeListIfNull(borderColor);
        borderColor.addAll(Arrays.asList(colors));
        return this;
    }

    public ScatterChartDataset addBorderWidth(Integer... widths) {
        borderWidth = Util.initializeListIfNull(borderWidth);
        borderWidth.addAll(Arrays.asList(widths));
        return this;
    }

    public ScatterChartDataset addBorderRadius(Integer... radiuses) {
        borderRadius = Util.initializeListIfNull(borderRadius);
        borderRadius.addAll(Arrays.asList(radiuses));
        return this;
    }

    public ScatterChartDataset addBorderSkipped(String... edges) {
        borderSkipped = Util.initializeListIfNull(borderSkipped);
        borderSkipped.addAll(Arrays.asList(edges));
        return this;
    }

    public ScatterChartDataset addHoverBackgroundColor(Color... colors) {
        hoverBackgroundColor = Util.initializeListIfNull(hoverBackgroundColor);
        hoverBackgroundColor.addAll(Arrays.asList(colors));
        return this;
    }

    public ScatterChartDataset addHoverBorderColor(Color... colors) {
        hoverBorderColor = Util.initializeListIfNull(hoverBorderColor);
        hoverBorderColor.addAll(Arrays.asList(colors));
        return this;
    }

    public ScatterChartDataset addHoverBorderWidth(Integer... widths) {
        hoverBorderWidth = Util.initializeListIfNull(hoverBorderWidth);
        hoverBorderWidth.addAll(Arrays.asList(widths));
        return this;
    }

    public ScatterChartDataset addHoverBorderRadius(Integer... radiuses) {
        hoverBorderRadius = Util.initializeListIfNull(hoverBorderRadius);
        hoverBorderRadius.addAll(Arrays.asList(radiuses));
        return this;
    }

    public ScatterChartDataset addHoverBorderSkipped(String... edges) {
        hoverBorderSkipped = Util.initializeListIfNull(hoverBorderSkipped);
        hoverBorderSkipped.addAll(Arrays.asList(edges));
        return this;
    }

    public ScatterChartDataset addPointStyle(String... styles) {
        pointStyle = Util.initializeListIfNull(pointStyle);
        pointStyle.addAll(Arrays.asList(styles));
        return this;
    }

    public ScatterChartDataset addRotation(Integer... rotations) {
        rotation = Util.initializeListIfNull(rotation);
        rotation.addAll(Arrays.asList(rotations));
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject datasetJson = new JSONObject();
        Util.addToJson(datasetJson, "data", data.stream().map(ScatterChartDatapoint::toJson).collect(Collectors.toList()));
        Util.addToJson(datasetJson, "label", label);
        Util.addToJson(datasetJson, "xAxisID", xAxisID);
        Util.addToJson(datasetJson, "yAxisID", yAxisID);
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
        Util.addToJson(datasetJson, "rotation", rotation);
        Util.addToJson(datasetJson, "pointStyle", pointStyle);
        Util.addToJson(datasetJson, "showLine", showLine);
        return datasetJson;
    }
}
