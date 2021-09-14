package de.yanwittmann.j2chartjs.quick;

import de.yanwittmann.j2chartjs.data.*;
import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.j2chartjs.options.ChartOptions;
import de.yanwittmann.j2chartjs.options.interaction.InteractionOption;
import de.yanwittmann.j2chartjs.options.plugins.title.TitleOption;
import de.yanwittmann.j2chartjs.options.scale.LinearScaleOption;
import de.yanwittmann.j2chartjs.options.scale.RadialScaleOption;
import de.yanwittmann.j2chartjs.options.scale.ScaleGridOption;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public abstract class QuickChart<T extends QuickChart<?, ?>, D extends ChartData<?, ?, ?>> {

    protected D chartData;
    protected final ChartOptions chartOptions = new ChartOptions();
    private final Map<String, AbstractChartOption> scales = new HashMap<>();

    public QuickChart(D chartData) {
        this.chartData = chartData;
    }

    public T addLabels(Collection<?> labels) {
        chartData.addLabels(labels.stream().map(Object::toString).collect(Collectors.toList()));
        return (T) this;
    }

    public T addLabels(Object... labels) {
        chartData.addLabels(Arrays.stream(labels).map(Object::toString).collect(Collectors.toList()));
        return (T) this;
    }

    public T setTitle(String title) {
        chartOptions.setTitle(new TitleOption()
                .setDisplay(true)
                .setText(title)
        );
        return (T) this;
    }

    public T setGridLinesVisible(boolean visible) {
        if (chartData instanceof BarChartData || chartData instanceof LineChartData || chartData instanceof BubbleChartData || chartData instanceof ScatterChartData) {
            if (scales.containsKey("x")) {
                ((LinearScaleOption) scales.get("x"))
                        .setGrid(new ScaleGridOption().setDisplay(visible));
            } else {
                scales.put("x", new LinearScaleOption()
                        .setGrid(new ScaleGridOption().setDisplay(visible))
                );
            }
            if (scales.containsKey("y")) {
                ((LinearScaleOption) scales.get("y"))
                        .setGrid(new ScaleGridOption().setDisplay(visible));
            } else {
                scales.put("y", new LinearScaleOption()
                        .setGrid(new ScaleGridOption().setDisplay(visible))
                );
            }
        } else {
            if (scales.containsKey("r")) {
                ((RadialScaleOption) scales.get("r"))
                        .setGrid(new ScaleGridOption().setDisplay(visible));
            } else {
                scales.put("r", new RadialScaleOption()
                        .setGrid(new ScaleGridOption().setDisplay(visible))
                );
            }
        }
        refreshScaleOptions();
        return (T) this;
    }

    public T setBeginAtZero(boolean beginAtZero) {
        if (chartData instanceof BarChartData || chartData instanceof LineChartData || chartData instanceof BubbleChartData || chartData instanceof ScatterChartData) {
            if (scales.containsKey("x")) {
                ((LinearScaleOption) scales.get("x"))
                        .setBeginAtZero(beginAtZero);
            } else {
                scales.put("x", new LinearScaleOption()
                        .setBeginAtZero(beginAtZero)
                );
            }
            if (scales.containsKey("y")) {
                ((LinearScaleOption) scales.get("y"))
                        .setBeginAtZero(beginAtZero);
            } else {
                scales.put("y", new LinearScaleOption()
                        .setBeginAtZero(beginAtZero)
                );
            }
        } else {
            if (scales.containsKey("r")) {
                ((RadialScaleOption) scales.get("r"))
                        .setBeginAtZero(beginAtZero);
            } else {
                scales.put("r", new RadialScaleOption()
                        .setBeginAtZero(beginAtZero)
                );
            }
        }
        refreshScaleOptions();
        return (T) this;
    }

    private void refreshScaleOptions() {
        chartOptions.clearScales();
        for (Map.Entry<String, AbstractChartOption> scale : scales.entrySet()) {
            if (scale.getValue() instanceof LinearScaleOption)
                chartOptions.addScale(scale.getKey(), ((LinearScaleOption) scale.getValue()));
            else if (scale.getValue() instanceof RadialScaleOption)
                chartOptions.addScale(scale.getKey(), ((RadialScaleOption) scale.getValue()));
        }
    }

    public T setIndexMode(boolean indexMode) {
        if (indexMode) {
            chartOptions.setInteraction(new InteractionOption()
                    .setMode("index"));
        } else {
            chartOptions.setInteraction(new InteractionOption()
                    .setMode("nearest"));
        }
        return (T) this;
    }

    public abstract JSONObject toJson();
}
