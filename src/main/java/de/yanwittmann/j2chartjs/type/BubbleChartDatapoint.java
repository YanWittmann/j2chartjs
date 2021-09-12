package de.yanwittmann.j2chartjs.type;

import org.json.JSONObject;

import java.math.BigDecimal;

public class BubbleChartDatapoint {

    private BigDecimal x;
    private BigDecimal y;
    private BigDecimal r;

    public BubbleChartDatapoint(int x, int y, int r) {
        this.x = new BigDecimal(x);
        this.y = new BigDecimal(y);
        this.r = new BigDecimal(r);
    }

    public BubbleChartDatapoint(double x, double y, double r) {
        this.x = new BigDecimal(x);
        this.y = new BigDecimal(y);
        this.r = new BigDecimal(r);
    }

    public BubbleChartDatapoint(Object x, Object y, Object r) {
        this.x = new BigDecimal(String.valueOf(x));
        this.y = new BigDecimal(String.valueOf(y));
        this.r = new BigDecimal(String.valueOf(r));
    }

    public BubbleChartDatapoint(int x, int y) {
        this.x = new BigDecimal(x);
        this.y = new BigDecimal(y);
    }

    public BubbleChartDatapoint(double x, double y) {
        this.x = new BigDecimal(x);
        this.y = new BigDecimal(y);
    }

    public BubbleChartDatapoint(Object x, Object y) {
        this.x = new BigDecimal(String.valueOf(x));
        this.y = new BigDecimal(String.valueOf(y));
    }

    public BigDecimal getX() {
        return x;
    }

    public BubbleChartDatapoint setX(int x) {
        this.x = new BigDecimal(x);
        return this;
    }

    public BubbleChartDatapoint setX(double x) {
        this.x = new BigDecimal(x);
        return this;
    }

    public BigDecimal getY() {
        return y;
    }

    public BubbleChartDatapoint setY(int y) {
        this.y = new BigDecimal(y);
        return this;
    }

    public BubbleChartDatapoint setY(double y) {
        this.y = new BigDecimal(y);
        return this;
    }

    public BigDecimal getR() {
        return r;
    }

    public BubbleChartDatapoint setR(int r) {
        this.r = new BigDecimal(r);
        return this;
    }

    public BubbleChartDatapoint setR(double r) {
        this.r = new BigDecimal(r);
        return this;
    }

    public JSONObject toJson() {
        JSONObject datapointJson = new JSONObject();
        if (x != null) datapointJson.put("x", x);
        if (y != null) datapointJson.put("y", y);
        if (r != null) datapointJson.put("r", r);
        return datapointJson;
    }
}
