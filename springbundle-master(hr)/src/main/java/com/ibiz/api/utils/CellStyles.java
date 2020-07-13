package com.ibiz.api.utils;

import com.ibiz.api.utils.Enum.*;

public class CellStyles {
    public static ExcelCellStyle Title() {

        ExcelCellStyle style = new ExcelCellStyle();

        style.setAlign(Alignment.Center);
        style.setVerticalAlign(VerticalAlignment.Center);

        style.setForegroundColor(Color.BlueGrey);
        style.setBackgroundColor(Color.None);

        style.setCellFilter(Filter.SolidForeground);
        style.setLeftBorder(Border.Thin);
        style.setRightBorder(Border.Thin);
        style.setTopBorder(Border.Thin);
        style.setBottomBorder(Border.Thin);

        style.setLeftBorderColor(Color.Grey25Percent);
        style.setRightBorderColor(Color.Grey25Percent);
        style.setTopBorderColor(Color.Grey25Percent);
        style.setBottomBorderColor(Color.Grey25Percent);

        style.setRotation((short) 0);

        Font f = new Font();

        f.setFontColor(Color.White);
        f.setSize(10);
        f.setIsStrikeOut(false);
        f.setIsItalic(false);
        f.setIsBold(true);
        f.setFontName(Name.나눔고딕);

        style.setFont(f);

        return style;
    }

    public static ExcelCellStyle Content()
    {
        ExcelCellStyle style = new ExcelCellStyle();

        style.setAlign(Alignment.Center);
        style.setVerticalAlign(VerticalAlignment.Center);

        style.setForegroundColor(Color.White);
        style.setBackgroundColor(Color.None);
        style.setCellFilter(Filter.SolidForeground);

        style.setLeftBorder(Border.Thin);
        style.setRightBorder(Border.Thin);
        style.setTopBorder(Border.Thin);
        style.setBottomBorder(Border.Thin);
        style.setLeftBorderColor(Color.Grey40Percent);
        style.setRightBorderColor(Color.Grey40Percent);
        style.setTopBorderColor(Color.Grey40Percent);
        style.setBottomBorderColor(Color.Grey40Percent);

        style.setRotation((short)0);

        Font f = new Font();

        f.setFontColor(Color.Black);
        f.setSize(10);
        f.setIsStrikeOut(false);
        f.setIsItalic(false);
        f.setIsBold(false);
        f.setFontName(Name.나눔고딕);

        style.setFont(f);

        return style;
    }

    public static ExcelCellStyle ContentLeft()
    {
        ExcelCellStyle style = new ExcelCellStyle();

        style.setAlign(Alignment.Left);
        style.setVerticalAlign(VerticalAlignment.Center);

        style.setForegroundColor(Color.White);
        style.setBackgroundColor(Color.None);
        style.setCellFilter(Filter.SolidForeground);

        style.setLeftBorder(Border.Thin);
        style.setRightBorder(Border.Thin);
        style.setTopBorder(Border.Thin);
        style.setBottomBorder(Border.Thin);
        style.setLeftBorderColor(Color.Grey40Percent);
        style.setRightBorderColor(Color.Grey40Percent);
        style.setTopBorderColor(Color.Grey40Percent);
        style.setBottomBorderColor(Color.Grey40Percent);

        style.setRotation((short)0);

        Font f = new Font();

        f.setFontColor(Color.Black);
        f.setSize(10);
        f.setIsStrikeOut(false);
        f.setIsItalic(false);
        f.setIsBold(false);
        f.setFontName(Name.나눔고딕);

        style.setFont(f);

        return style;
    }


    public static ExcelCellStyle ContentRight()
    {
        ExcelCellStyle style = new ExcelCellStyle();

        style.setAlign(Alignment.Right);
        style.setVerticalAlign(VerticalAlignment.Center);

        style.setForegroundColor(Color.White);
        style.setBackgroundColor(Color.None);
        style.setCellFilter(Filter.SolidForeground);

        style.setLeftBorder(Border.Thin);
        style.setRightBorder(Border.Thin);
        style.setTopBorder(Border.Thin);
        style.setBottomBorder(Border.Thin);
        style.setLeftBorderColor(Color.Grey40Percent);
        style.setRightBorderColor(Color.Grey40Percent);
        style.setTopBorderColor(Color.Grey40Percent);
        style.setBottomBorderColor(Color.Grey40Percent);

        style.setRotation((short)0);

        Font f = new Font();

        f.setFontColor(Color.Black);
        f.setSize(10);
        f.setIsStrikeOut(false);
        f.setIsItalic(false);
        f.setIsBold(false);
        f.setFontName(Name.나눔고딕);

        style.setFont(f);

        return style;
    }
}
