package com.ibiz.api.utils;

import com.ibiz.api.utils.Enum.Color;
import com.ibiz.api.utils.Enum.Name;

public class Font {
    private Name fontName = Name.바탕;
    private Color fontColor = Color.Black;
    private int size = 10;

    public Font() {

        setIsItalic(false);
        setIsStrikeOut(false);
        setUnderLine((byte) 0);
        setIsBold(false);
    }

    public Name getFontName() {

        return this.fontName;
    }

    public void setFontName(Name value) {

        this.fontName = value;
    }

    private boolean IsBold;

    public boolean getIsBold() {

        return IsBold;
    }

    public void setIsBold(boolean value) {

        IsBold = value;
    }

    private byte UnderLine;

    public byte getUnderLine() {

        return UnderLine;
    }

    public void setUnderLine(byte value) {

        UnderLine = value;
    }

    private boolean IsStrikeOut;

    public boolean getIsStrikeOut() {

        return IsStrikeOut;
    }

    public void setIsStrikeOut(boolean value) {

        IsStrikeOut = value;
    }

    private boolean IsItalic;

    public boolean getIsItalic() {

        return IsItalic;
    }

    public void setIsItalic(boolean value) {

        IsItalic = value;
    }

    public int getSize() {

        return this.size;
    }

    public void setSize(int value) {

        this.size = value;
    }

    public Color getFontColor() {

        return this.fontColor;
    }

    public void setFontColor(Color value) {

        this.fontColor = value;
    }
}
