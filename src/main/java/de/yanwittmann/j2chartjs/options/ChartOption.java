package de.yanwittmann.j2chartjs.options;

import de.yanwittmann.j2chartjs.options.animation.AnimationProperty;
import de.yanwittmann.j2chartjs.options.animation.ChartAnimationOption;
import de.yanwittmann.j2chartjs.options.animation.PropertyAnimationOption;
import de.yanwittmann.j2chartjs.options.interaction.InteractionOption;
import de.yanwittmann.j2chartjs.options.layout.LayoutOption;
import de.yanwittmann.j2chartjs.options.plugins.legend.LegendOption;
import de.yanwittmann.j2chartjs.options.plugins.title.TitleOption;
import de.yanwittmann.j2chartjs.options.scale.ScaleOption;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * For an overview of all configuration values, see the <a href="https://www.chartjs.org/docs/next/configuration/">documentation</a>.
 */
public class ChartOption extends AbstractChartOption {

    private AbstractChartOption scales;
    private AbstractChartOption interaction;
    private AbstractChartOption layout;
    private AbstractChartOption legend;
    private AbstractChartOption title;
    private AbstractChartOption animation;
    private final Map<String, AbstractChartOption> animations = new HashMap<>();

    /**
     * When set to false, disables all animations.
     */
    private Boolean animationsActive;
    /**
     * Resizes the chart canvas when its container does.
     */
    private Boolean responsive;
    /**
     * Maintain the original canvas aspect ratio (width / height) when resizing.
     */
    private Boolean maintainAspectRatio;
    /**
     * Canvas aspect ratio (i.e. width / height, a value of 1 representing a square canvas). Note that this option is ignored if the height is explicitly defined either as attribute or via the style.
     */
    private Double aspectRatio;
    /**
     * Delay the resize update by give amount of milliseconds. This can ease the resize process by debouncing update of the elements.
     */
    private Integer resizeDelay;
    /**
     * Override the window's default devicePixelRatio.
     */
    private Integer devicePixelRatio;
    /**
     * A string with a <code>BCP 47</code> language tag, leveraging on <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Intl/NumberFormat/NumberFormat">INTL NumberFormat</a>.<br>
     * A Unicode <code>BCP 47</code> locale identifier consists of<ol>
     * <li>a language code,</li>
     * <li>(optionally) a script code,</li>
     * <li>(optionally) a region (or country) code,</li>
     * <li>(optionally) one or more variant codes, and</li>
     * <li>(optionally) one or more extension sequences,</li>
     * </ol>with all present components separated by hyphens.
     */
    private String locale;

    public ChartOption setScales(ScaleOption scales) {
        this.scales = scales;
        return this;
    }

    public ChartOption setInteraction(InteractionOption interaction) {
        this.interaction = interaction;
        return this;
    }

    public ChartOption setLayout(LayoutOption layout) {
        this.layout = layout;
        return this;
    }

    public ChartOption setLegend(LegendOption legend) {
        this.legend = legend;
        return this;
    }

    public void setTitle(TitleOption title) {
        this.title = title;
    }

    public ChartOption setChartAnimation(ChartAnimationOption animation) {
        this.animation = animation;
        return this;
    }

    public ChartOption addPropertyAnimation(AnimationProperty key, PropertyAnimationOption animation) {
        this.animations.put(key.getKey(), animation);
        return this;
    }

    public ChartOption setAnimationsActive(boolean active) {
        animationsActive = active;
        return this;
    }

    public ChartOption setResponsive(Boolean responsive) {
        this.responsive = responsive;
        return this;
    }

    public ChartOption setMaintainAspectRatio(Boolean maintainAspectRatio) {
        this.maintainAspectRatio = maintainAspectRatio;
        return this;
    }

    public ChartOption setAspectRatio(Double aspectRatio) {
        this.aspectRatio = aspectRatio;
        return this;
    }

    public ChartOption setResizeDelay(Integer resizeDelay) {
        this.resizeDelay = resizeDelay;
        return this;
    }

    public ChartOption setDevicePixelRatio(Integer devicePixelRatio) {
        this.devicePixelRatio = devicePixelRatio;
        return this;
    }

    public ChartOption setLocale(String locale) {
        this.locale = locale;
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject optionsJson = new JSONObject();

        if (scales != null) optionsJson.put("scales", scales.toJson());
        if (interaction != null) optionsJson.put("interaction", interaction.toJson());
        if (layout != null) optionsJson.put("layout", layout.toJson());

        if (legend != null || title != null) {
            JSONObject pluginsJson = new JSONObject();
            if (legend != null) pluginsJson.put("legend", legend.toJson());
            if (title != null) pluginsJson.put("title", title.toJson());
            optionsJson.put("plugins", pluginsJson);
        }

        if (Boolean.FALSE.equals(animationsActive)) {
            optionsJson.put("animation", false);
        } else {
            if (animation != null) optionsJson.put("animation", animation.toJson());
            if (animations.size() > 0) {
                JSONObject animationsJson = new JSONObject();
                for (Map.Entry<String, AbstractChartOption> entry : animations.entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        animationsJson.put(entry.getKey(), entry.getValue().toJson());
                    }
                }
                optionsJson.put("animations", animationsJson);
            }
        }

        if (responsive != null) optionsJson.put("responsive", responsive);
        if (maintainAspectRatio != null) optionsJson.put("maintainAspectRatio", maintainAspectRatio);
        if (aspectRatio != null) optionsJson.put("aspectRatio", aspectRatio);
        if (resizeDelay != null) optionsJson.put("resizeDelay", resizeDelay);
        if (devicePixelRatio != null) optionsJson.put("devicePixelRatio", devicePixelRatio);

        return optionsJson;
    }
}
