package de.yanwittmann.j2chartjs.options.animation;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

@SuppressWarnings("unchecked")
public class AnimationOption<T> extends AbstractChartOption {

    private Number duration;
    private Number delay;
    private AnimationEasingType easing;
    private Boolean loop;

    public Number getDuration() {
        return duration;
    }

    public T setDuration(Number duration) {
        this.duration = duration;
        return (T) this;
    }

    public T setDuration(int duration) {
        this.duration = duration;
        return (T) this;
    }

    public T setDuration(double duration) {
        this.duration = duration;
        return (T) this;
    }

    public Number getDelay() {
        return delay;
    }

    public T setDelay(Number delay) {
        this.delay = delay;
        return (T) this;
    }

    public T setDelay(int delay) {
        this.delay = delay;
        return (T) this;
    }

    public T setDelay(double delay) {
        this.delay = delay;
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
        Util.addToJson(animationJson, "duration", duration);
        Util.addToJson(animationJson, "delay", delay);
        Util.addToJson(animationJson, "easing", easing);
        Util.addToJson(animationJson, "loop", loop);
        return animationJson;
    }
}
