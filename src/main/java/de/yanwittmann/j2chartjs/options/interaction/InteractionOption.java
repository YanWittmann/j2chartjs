package de.yanwittmann.j2chartjs.options.interaction;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

public class InteractionOption extends AbstractChartOption {

    /**
     * Sets which elements appear in the interaction.<ul>
     * <li><code>nearest</code> (default, gets the items that are at the nearest distance to the point)</li>
     * <li><code>index</code> (finds item at the same index)</li>
     * <li><code>dataset</code> (finds items in the same dataset)</li>
     * <li><code>point</code> (finds all of the items that intersect the point)</li>
     * <li><code>x</code> (returns all items that would intersect based on the X coordinate of the position only)</li>
     * <li><code>y</code> (returns all items that would intersect based on the Y coordinate of the position only)</li>
     * </ul>
     */
    private String mode;
    /**
     * if true, the interaction mode only applies when the mouse position intersects an item on the chart.
     */
    private Boolean intersect;
    /**
     * Can be set to 'x', 'y', or 'xy' to define which directions are used in calculating distances. Defaults to 'x' for 'index' mode and 'xy' in dataset and 'nearest' modes.
     */
    private String axis;

    public InteractionOption setMode(String mode) {
        this.mode = mode;
        return this;
    }

    public InteractionOption setIntersect(Boolean intersect) {
        this.intersect = intersect;
        return this;
    }

    public InteractionOption setAxis(String axis) {
        this.axis = axis;
        return this;
    }

    public String getMode() {
        return mode;
    }

    public Boolean getIntersect() {
        return intersect;
    }

    public String getAxis() {
        return axis;
    }

    @Override
    public JSONObject toJson() {
        JSONObject optionsJson = new JSONObject();
        Util.addToJson(optionsJson, "mode", mode);
        Util.addToJson(optionsJson, "intersect", intersect);
        Util.addToJson(optionsJson, "mode", axis);
        return optionsJson;
    }
}
