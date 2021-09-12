package de.yanwittmann.j2chartjs.datapoint;

import org.json.JSONObject;

import java.math.BigDecimal;

public class ScatterChartDatapoint {

    private BigDecimal x;
    private BigDecimal y;

    public ScatterChartDatapoint(int x, int y) {
        this.x = new BigDecimal(x);
        this.y = new BigDecimal(y);
    }

    public ScatterChartDatapoint(double x, double y) {
        this.x = new BigDecimal(x);
        this.y = new BigDecimal(y);
    }

    public ScatterChartDatapoint(Object x, Object y) {
        this.x = new BigDecimal(String.valueOf(x));
        this.y = new BigDecimal(String.valueOf(y));
    }

    public BigDecimal getX() {
        return x;
    }

    public ScatterChartDatapoint setX(int x) {
        this.x = new BigDecimal(x);
        return this;
    }

    public ScatterChartDatapoint setX(double x) {
        this.x = new BigDecimal(x);
        return this;
    }

    public BigDecimal getY() {
        return y;
    }

    public ScatterChartDatapoint setY(int y) {
        this.y = new BigDecimal(y);
        return this;
    }

    public ScatterChartDatapoint setY(double y) {
        this.y = new BigDecimal(y);
        return this;
    }

    public JSONObject toJson() {
        JSONObject datapointJson = new JSONObject();
        if (x != null) datapointJson.put("x", x);
        if (y != null) datapointJson.put("y", y);
        return datapointJson;
    }
}
