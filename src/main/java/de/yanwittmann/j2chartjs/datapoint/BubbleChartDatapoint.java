package de.yanwittmann.j2chartjs.datapoint;

import de.yanwittmann.util.Util;
import org.json.JSONObject;

public class BubbleChartDatapoint {

    private Number x;
    private Number y;
    private Number r;

    public BubbleChartDatapoint(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public BubbleChartDatapoint(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public BubbleChartDatapoint(Number x, Number y, Number r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public BubbleChartDatapoint(Object x, Object y, Object r) {
        this.x = Double.parseDouble(String.valueOf(x));
        this.y = Double.parseDouble(String.valueOf(y));
        this.r = Double.parseDouble(String.valueOf(r));
    }

    public BubbleChartDatapoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public BubbleChartDatapoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public BubbleChartDatapoint(Number x, Number y) {
        this.x = x;
        this.y = y;
    }

    public BubbleChartDatapoint(Object x, Object y) {
        this.x = Double.parseDouble(String.valueOf(x));
        this.y = Double.parseDouble(String.valueOf(y));
    }

    public Number getX() {
        return x;
    }

    public BubbleChartDatapoint setX(int x) {
        this.x = x;
        return this;
    }

    public BubbleChartDatapoint setX(double x) {
        this.x = x;
        return this;
    }

    public Number getY() {
        return y;
    }

    public BubbleChartDatapoint setY(int y) {
        this.y = y;
        return this;
    }

    public BubbleChartDatapoint setY(double y) {
        this.y = y;
        return this;
    }

    public Number getR() {
        return r;
    }

    public BubbleChartDatapoint setR(int r) {
        this.r = r;
        return this;
    }

    public BubbleChartDatapoint setR(double r) {
        this.r = r;
        return this;
    }

    public JSONObject toJson() {
        JSONObject datapointJson = new JSONObject();
        Util.addToJson(datapointJson, "x", x);
        Util.addToJson(datapointJson, "y", y);
        Util.addToJson(datapointJson, "r", r);
        return datapointJson;
    }
}
