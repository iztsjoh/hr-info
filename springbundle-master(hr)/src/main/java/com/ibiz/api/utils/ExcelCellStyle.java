package com.ibiz.api.utils;

import com.ibiz.api.utils.Enum.Alignment;
import com.ibiz.api.utils.Enum.Border;
import com.ibiz.api.utils.Enum.Color;
import com.ibiz.api.utils.Enum.Filter;
import com.ibiz.api.utils.Enum.VerticalAlignment;

public class ExcelCellStyle {
    private Alignment align = Alignment.Justify;
    private VerticalAlignment verticalAlign = VerticalAlignment.Justify;
    private Font font = null;

    private Color backgroundColor = Color.None;
    private Color foregroundColor = Color.None;
    private Filter cellFilter = Filter.NoFill;

    private Color leftBorderColor = Color.None;
    private Color rightBorderColor = Color.None;
    private Color bottomBorderColor = Color.None;
    private Color topBorderColor = Color.None;

    private Border leftBorder = Border.None;
    private Border rightBorder = Border.None;
    private Border bottomBorder = Border.None;
    private Border topBorder = Border.None;

    public ExcelCellStyle() {

        setRotation((short) 0);
    }

    private short Rotation;

    public short getRotation() {

        return Rotation;
    }

    public void setRotation(short value) {

        Rotation = value;
    }

    public Alignment getAlign() {

        return align;
    }

    public void setAlign(Alignment align) {

        this.align = align;
    }

    public VerticalAlignment getVerticalAlign() {

        return verticalAlign;
    }

    public void setVerticalAlign(VerticalAlignment verticalAlign) {

        this.verticalAlign = verticalAlign;
    }

    public Color getBackgroundColor() {

        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {

        this.backgroundColor = backgroundColor;
    }

    public Color getForegroundColor() {

        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {

        this.foregroundColor = foregroundColor;
    }

    public Filter getCellFilter() {

        return cellFilter;
    }

    public void setCellFilter(Filter cellFilter) {

        this.cellFilter = cellFilter;
    }

    public Color getLeftBorderColor() {

        return leftBorderColor;
    }

    public void setLeftBorderColor(Color leftBorderColor) {

        this.leftBorderColor = leftBorderColor;
    }

    public Color getRightBorderColor() {

        return rightBorderColor;
    }

    public void setRightBorderColor(Color rightBorderColor) {

        this.rightBorderColor = rightBorderColor;
    }

    public Color getBottomBorderColor() {

        return bottomBorderColor;
    }

    public void setBottomBorderColor(Color bottomBorderColor) {

        this.bottomBorderColor = bottomBorderColor;
    }

    public Color getTopBorderColor() {

        return topBorderColor;
    }

    public void setTopBorderColor(Color topBorderColor) {

        this.topBorderColor = topBorderColor;
    }

    public Border getLeftBorder() {

        return leftBorder;
    }

    public void setLeftBorder(Border leftBorder) {

        this.leftBorder = leftBorder;
    }

    public Border getRightBorder() {

        return rightBorder;
    }

    public void setRightBorder(Border rightBorder) {

        this.rightBorder = rightBorder;
    }

    public Border getBottomBorder() {

        return bottomBorder;
    }

    public void setBottomBorder(Border bottomBorder) {

        this.bottomBorder = bottomBorder;
    }

    public Border getTopBorder() {

        return topBorder;
    }

    public void setTopBorder(Border topBorder) {

        this.topBorder = topBorder;
    }

    public Font getFontStyle() {

        if (font == null) {
            this.font = new Font();
        }

        return font;
    }

    public void setFont(Font font) {

        this.font = font;
    }
}