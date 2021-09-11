package de.yanwittmann.j2chartjs.options.animation;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import org.json.JSONObject;

import java.math.BigDecimal;

@SuppressWarnings("unchecked")
public class AnimationOption<T> extends AbstractChartOption {

    private BigDecimal duration;
    private BigDecimal delay;
    private AnimationEasingType easing;
    private Boolean loop;

    public BigDecimal getDuration() {
        return duration;
    }

    public T setDuration(BigDecimal duration) {
        this.duration = duration;
        return (T) this;
    }

    public T setDuration(int duration) {
        this.duration = new BigDecimal(duration);
        return (T) this;
    }

    public T setDuration(double duration) {
        this.duration = new BigDecimal(duration);
        return (T) this;
    }

    public BigDecimal getDelay() {
        return delay;
    }

    public T setDelay(BigDecimal delay) {
        this.delay = delay;
        return (T) this;
    }

    public T setDelay(int delay) {
        this.delay = new BigDecimal(delay);
        return (T) this;
    }

    public T setDelay(double delay) {
        this.delay = new BigDecimal(delay);
        return (T) this;
    }

    public AnimationEasingType getEasing() {
        return easing;
    }

    public T setEasing(AnimationEasingType easing) {
        this.easing = easing;
        return (T) this;
    }

    public Boolean getLoop() {
        return loop;
    }

    public T setLoop(Boolean loop) {
        this.loop = loop;
        return (T) this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject animationJson = new JSONObject();
        if (duration != null) animationJson.put("duration", duration);
        if (delay != null) animationJson.put("delay", delay);
        if (easing != null) animationJson.put("easing", easing.getKey());
        if (loop != null) animationJson.put("loop", loop);
        return animationJson;
    }
}
