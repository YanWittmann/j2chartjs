package de.yanwittmann.j2chartjs.options.animation;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TransitionAnimationOption extends AbstractChartOption {

    private final Map<String, AbstractChartOption> animations = new HashMap<>();

    public TransitionAnimationOption addPropertyAnimation(AnimationPropertyOption key, PropertyAnimationOption animation) {
        this.animations.put(key.getKey(), animation);
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject transitionJson = new JSONObject();
        if (animations.size() > 0) {
            JSONObject animationsJson = new JSONObject();
            for (Map.Entry<String, AbstractChartOption> entry : animations.entrySet()) {
                if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                    animationsJson.put(entry.getKey(), entry.getValue().toJson());
                }
            }
            transitionJson.put("animations", animationsJson);
        }
        return transitionJson;
    }
}
