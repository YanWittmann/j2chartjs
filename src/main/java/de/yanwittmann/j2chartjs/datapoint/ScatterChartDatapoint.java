package de.yanwittmann.j2chartjs.datapoint;

import de.yanwittmann.util.Util;
import org.json.JSONObject;

public class ScatterChartDatapoint {

    private Number x;
    private Number y;

    public ScatterChartDatapoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ScatterChartDatapoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public ScatterChartDatapoint(Object x, Object y) {
        this.x = Double.parseDouble(String.valueOf(x));
        this.y = Double.parseDouble(String.valueOf(y));
    }

    public Number getX() {
        return x;
    }

    public ScatterChartDatapoint setX(int x) {
        this.x = x;
        return this;
    }

    public ScatterChartDatapoint setX(double x) {
        this.x = x;
        return this;
    }

    public Number getY() {
        return y;
    }

    public ScatterChartDatapoint setY(int y) {
        this.y = y;
        return this;
    }

    public ScatterChartDatapoint setY(double y) {
        this.y = y;
        return this;
    }

    public JSONObject toJson() {
        JSONObject datapointJson = new JSONObject();
        Util.addToJson(datapointJson, "x", x);
        Util.addToJson(datapointJson, "y", y);
        return datapointJson;
    }
}
