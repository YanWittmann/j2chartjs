package de.yanwittmann.j2chartjs.options.animation;

import de.yanwittmann.util.Util;
import org.json.JSONObject;

public class PropertyAnimationOption<D> extends AnimationOption<PropertyAnimationOption<D>> {

    private String type;
    private D from;
    private D to;

    public String getType() {
        return type;
    }

    public PropertyAnimationOption<D> setType(String type) {
        this.type = type;
        return this;
    }

    public D getFrom() {
        return from;
    }

    public PropertyAnimationOption<D> setFrom(D from) {
        this.from = from;
        return this;
    }

    public D getTo() {
        return to;
    }

    public PropertyAnimationOption<D> setTo(D to) {
        this.to = to;
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject animationJson = Util.deepMerge(super.toJson(), new JSONObject());
        Util.addToJson(animationJson, "type", type);
        Util.addToJson(animationJson, "from", from);
        Util.addToJson(animationJson, "to", to);
        return animationJson;
    }
}
