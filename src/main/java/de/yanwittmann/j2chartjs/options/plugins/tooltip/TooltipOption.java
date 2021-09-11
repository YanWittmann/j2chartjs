package de.yanwittmann.j2chartjs.options.plugins.tooltip;

import de.yanwittmann.j2chartjs.options.AbstractChartOption;
import de.yanwittmann.j2chartjs.type.ChartFont;
import de.yanwittmann.j2chartjs.type.ChartPadding;
import de.yanwittmann.util.Util;
import org.json.JSONObject;

import java.awt.*;

public class TooltipOption extends AbstractChartOption {

    /**
     * Whether on-canvas tooltips are enabled.
     */
    private Boolean enabled;
    /**
     * The method that should be used when positioning the tooltip.<ul>
     * <li><code>average</code> (default)</li>
     * <li><code>nearest</code></li>
     * </ul>
     */
    private String position;
    /**
     * The background color of the tooltip.
     */
    private Color backgroundColor;
    /**
     * The color of the tooltip title.
     */
    private Color titleColor;
    /**
     * The font of the tooltip title.
     */
    private ChartFont titleFont;
    /**
     * Horizontal alignment of the title text lines.<ul>
     * <li>left (default)</li>
     * <li>right</li>
     * <li>center</li>
     * </ul>
     */
    private String titleAlign;
    /**
     * Spacing to add to top and bottom of each title line.
     */
    private Integer titleSpacing;
    /**
     * Margin to add on bottom of title section.
     */
    private Integer titleMarginBottom;
    /**
     * Color of the body text.
     */
    private Color bodyColor;
    /**
     * The font of the body text.
     */
    private ChartFont bodyFont;
    /**
     * Horizontal alignment of the body text lines.<ul>
     * <li>left (default)</li>
     * <li>right</li>
     * <li>center</li>
     * </ul>
     */
    private String bodyAlign;
    /**
     * Spacing to add to top and bottom of each tooltip item.
     */
    private Integer bodySpacing;
    /**
     * Color of the footer text.
     */
    private Color footerColor;
    /**
     * The font of the footer text.
     */
    private ChartFont footerFont;
    /**
     * Horizontal alignment of the footer text lines.<ul>
     * <li>left (default)</li>
     * <li>right</li>
     * <li>center</li>
     * </ul>
     */
    private String footerAlign;
    /**
     * Spacing to add to top and bottom of each footer line.
     */
    private Integer footerSpacing;
    /**
     * Margin to add before drawing the footer.
     */
    private Integer footerMarginTop;
    /**
     * Padding inside the tooltip.
     */
    private ChartPadding padding;
    /**
     * Extra distance to move the end of the tooltip arrow away from the tooltip point.
     */
    private Integer caretPadding;
    /**
     * Size, in px, of the tooltip arrow.
     */
    private Integer caretSize;
    /**
     * Radius of tooltip corner curves.
     */
    private Integer cornerRadius;
    /**
     * Color to draw behind the colored boxes when multiple items are in the tooltip.
     */
    private Color multiKeyBackground;
    /**
     * If true, color boxes are shown in the tooltip.
     */
    private Boolean displayColors;
    /**
     * Width of the color box if displayColors is true.
     */
    private Integer boxWidth;
    /**
     * Height of the color box if displayColors is true.
     */
    private Integer boxHeight;
    /**
     * Color of the border.
     */
    private Color borderColor;
    /**
     * Size of the border.
     */
    private Integer borderWidth;
    /**
     * <code>true</code> for rendering the tooltip from right to left.
     */
    private Boolean rtl;
    /**
     * This will force the text direction 'rtl' or 'ltr on the canvas for rendering the tooltips, regardless of the css specified on the canvas
     */
    private String textDirection;

    public Boolean getEnabled() {
        return enabled;
    }

    public TooltipOption setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public TooltipOption setPosition(String position) {
        this.position = position;
        return this;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public TooltipOption setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Color getTitleColor() {
        return titleColor;
    }

    public TooltipOption setTitleColor(Color titleColor) {
        this.titleColor = titleColor;
        return this;
    }

    public ChartFont getTitleFont() {
        return titleFont;
    }

    public TooltipOption setTitleFont(ChartFont titleFont) {
        this.titleFont = titleFont;
        return this;
    }

    public String getTitleAlign() {
        return titleAlign;
    }

    public TooltipOption setTitleAlign(String titleAlign) {
        this.titleAlign = titleAlign;
        return this;
    }

    public Integer getTitleSpacing() {
        return titleSpacing;
    }

    public TooltipOption setTitleSpacing(Integer titleSpacing) {
        this.titleSpacing = titleSpacing;
        return this;
    }

    public Integer getTitleMarginBottom() {
        return titleMarginBottom;
    }

    public TooltipOption setTitleMarginBottom(Integer titleMarginBottom) {
        this.titleMarginBottom = titleMarginBottom;
        return this;
    }

    public Color getBodyColor() {
        return bodyColor;
    }

    public TooltipOption setBodyColor(Color bodyColor) {
        this.bodyColor = bodyColor;
        return this;
    }

    public ChartFont getBodyFont() {
        return bodyFont;
    }

    public TooltipOption setBodyFont(ChartFont bodyFont) {
        this.bodyFont = bodyFont;
        return this;
    }

    public String getBodyAlign() {
        return bodyAlign;
    }

    public TooltipOption setBodyAlign(String bodyAlign) {
        this.bodyAlign = bodyAlign;
        return this;
    }

    public Integer getBodySpacing() {
        return bodySpacing;
    }

    public TooltipOption setBodySpacing(Integer bodySpacing) {
        this.bodySpacing = bodySpacing;
        return this;
    }

    public Color getFooterColor() {
        return footerColor;
    }

    public TooltipOption setFooterColor(Color footerColor) {
        this.footerColor = footerColor;
        return this;
    }

    public ChartFont getFooterFont() {
        return footerFont;
    }

    public TooltipOption setFooterFont(ChartFont footerFont) {
        this.footerFont = footerFont;
        return this;
    }

    public String getFooterAlign() {
        return footerAlign;
    }

    public TooltipOption setFooterAlign(String footerAlign) {
        this.footerAlign = footerAlign;
        return this;
    }

    public Integer getFooterSpacing() {
        return footerSpacing;
    }

    public TooltipOption setFooterSpacing(Integer footerSpacing) {
        this.footerSpacing = footerSpacing;
        return this;
    }

    public Integer getFooterMarginTop() {
        return footerMarginTop;
    }

    public TooltipOption setFooterMarginTop(Integer footerMarginTop) {
        this.footerMarginTop = footerMarginTop;
        return this;
    }

    public ChartPadding getPadding() {
        return padding;
    }

    public TooltipOption setPadding(ChartPadding padding) {
        this.padding = padding;
        return this;
    }

    public Integer getCaretPadding() {
        return caretPadding;
    }

    public TooltipOption setCaretPadding(Integer caretPadding) {
        this.caretPadding = caretPadding;
        return this;
    }

    public Integer getCaretSize() {
        return caretSize;
    }

    public TooltipOption setCaretSize(Integer caretSize) {
        this.caretSize = caretSize;
        return this;
    }

    public Integer getCornerRadius() {
        return cornerRadius;
    }

    public TooltipOption setCornerRadius(Integer cornerRadius) {
        this.cornerRadius = cornerRadius;
        return this;
    }

    public Color getMultiKeyBackground() {
        return multiKeyBackground;
    }

    public TooltipOption setMultiKeyBackground(Color multiKeyBackground) {
        this.multiKeyBackground = multiKeyBackground;
        return this;
    }

    public Boolean getDisplayColors() {
        return displayColors;
    }

    public TooltipOption setDisplayColors(Boolean displayColors) {
        this.displayColors = displayColors;
        return this;
    }

    public Integer getBoxWidth() {
        return boxWidth;
    }

    public TooltipOption setBoxWidth(Integer boxWidth) {
        this.boxWidth = boxWidth;
        return this;
    }

    public Integer getBoxHeight() {
        return boxHeight;
    }

    public TooltipOption setBoxHeight(Integer boxHeight) {
        this.boxHeight = boxHeight;
        return this;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public TooltipOption setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public Integer getBorderWidth() {
        return borderWidth;
    }

    public TooltipOption setBorderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public Boolean getRtl() {
        return rtl;
    }

    public TooltipOption setRtl(Boolean rtl) {
        this.rtl = rtl;
        return this;
    }

    public String getTextDirection() {
        return textDirection;
    }

    public TooltipOption setTextDirection(String textDirection) {
        this.textDirection = textDirection;
        return this;
    }

    @Override
    public JSONObject toJson() {
        JSONObject optionsJson = new JSONObject();
        if (enabled != null) optionsJson.put("enabled", enabled);
        if (position != null) optionsJson.put("position", position);
        if (backgroundColor != null) optionsJson.put("backgroundColor", Util.convertColorToJs(backgroundColor));
        if (titleColor != null) optionsJson.put("titleColor", Util.convertColorToJs(titleColor));
        if (titleFont != null) optionsJson.put("titleFont", titleFont.toJson());
        if (titleAlign != null) optionsJson.put("titleAlign", titleAlign);
        if (titleSpacing != null) optionsJson.put("titleSpacing", titleSpacing);
        if (titleMarginBottom != null) optionsJson.put("titleMarginBottom", titleMarginBottom);
        if (bodyColor != null) optionsJson.put("bodyColor", Util.convertColorToJs(bodyColor));
        if (bodyFont != null) optionsJson.put("bodyFont", bodyFont.toJson());
        if (bodyAlign != null) optionsJson.put("bodyAlign", bodyAlign);
        if (bodySpacing != null) optionsJson.put("bodySpacing", bodySpacing);
        if (footerColor != null) optionsJson.put("footerColor", Util.convertColorToJs(footerColor));
        if (footerFont != null) optionsJson.put("footerFont", footerFont.toJson());
        if (footerAlign != null) optionsJson.put("footerAlign", footerAlign);
        if (footerSpacing != null) optionsJson.put("footerSpacing", footerSpacing);
        if (footerMarginTop != null) optionsJson.put("footerMarginTop", footerMarginTop);
        if (padding != null) optionsJson.put("padding", padding);
        if (caretPadding != null) optionsJson.put("caretPadding", caretPadding);
        if (caretSize != null) optionsJson.put("caretSize", caretSize);
        if (cornerRadius != null) optionsJson.put("cornerRadius", cornerRadius);
        if (multiKeyBackground != null) optionsJson.put("multiKeyBackground", multiKeyBackground);
        if (displayColors != null) optionsJson.put("displayColors", displayColors);
        if (boxWidth != null) optionsJson.put("boxWidth", boxWidth);
        if (boxHeight != null) optionsJson.put("boxHeight", boxHeight);
        if (borderColor != null) optionsJson.put("borderColor", Util.convertColorToJs(borderColor));
        if (borderWidth != null) optionsJson.put("borderWidth", borderWidth);
        if (rtl != null) optionsJson.put("rtl", rtl);
        if (textDirection != null) optionsJson.put("textDirection", textDirection);
        return optionsJson;
    }
}
