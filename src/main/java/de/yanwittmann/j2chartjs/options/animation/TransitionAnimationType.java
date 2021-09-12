package de.yanwittmann.j2chartjs.options.animation;

public enum TransitionAnimationType {
    ACTIVE("active"),
    RESIZE("resize"),
    SHOW("show"),
    HIDE("hide");

    private final String key;

    TransitionAnimationType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
