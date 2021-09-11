package de.yanwittmann.j2chartjs.options.animation;

public enum AnimationProperty {
    X("x"),
    Y("y"),
    BORDER_WIDTH("borderWidth"),
    RADIUS("radius"),
    TENSION("tension"),
    COLOR("color"),
    BORDER_COLOR("borderColor"),
    BACKGROUND_COLOR("backgroundColor");

    private final String key;

    AnimationProperty(java.lang.String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
