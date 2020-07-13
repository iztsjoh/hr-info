package com.ibiz.api.utils;

public class Enum {
    public enum AccessType {
        Write, Read
    }

    public enum Alignment {
        General(0), Left(1), Center(2), Right(3), Fill(4), Justify(5), CenterSelection(6);

        private int value;

        private Alignment(int value) {

            this.value = value;
        }

        public int getValue() {

            return this.value;
        }
    }

    public enum VerticalAlignment {
        Top(0), Center(1), Bottom(2), Justify(3);

        private int value;

        private VerticalAlignment(int value) {

            this.value = value;
        }

        public int getValue() {

            return this.value;
        }
    }

    public enum Name {
        Arial, 고딕, 굴림, 돋움, 궁서, 바탕, 나눔고딕
    }

    public enum Color {
        Black(8), White(9), Red(10), BrightGreen(11), Blue(12), Yellow(13), Pink(14), Turquoise(15), DarkRed(16), Green(17), DarkBlue(18), DarkYellow(19), Violet(20), Teal(21), Grey25Percent(22), Grey50Percent(23), CornflowerBlue(24), Maroon(25), LemonChiffon(26), Orchid(28), Coral(29), RoyalBlue(30), LightCornflowerBlue(31), SkyBlue(40), LightTurquoise(41), LightGreen(42), LightYellow(43), PaleBlue(44), Rose(45), Lavender(46), Tan(47), LightBlue(48), Aqua(49), Lime(50), Gold(51), LightOrange(52), Orange(53), BlueGrey(54), Grey40Percent(55), DarkTeal(56), SeaGreen(57), DarkGreen(58), OliveGreen(59), Brown(60), Plum(61), Indigo(62), Grey80Percent(63), None(65);

        private int value;

        private Color(int value) {

            this.value = value;
        }

        public int getValue() {

            return value;
        }
    }

    public enum Border {
        None(0), Thin(1), Medium(2), Dashed(3), Hair(4), Thick(5), Double(6), Dotted(7), MediumDashed(8), DashDot(9), MediumDashDot(10), DashDotDot(11), MediumDashDotDot(12), SlantedDashDot(13);

        private int value;

        private Border(int value) {

            this.value = value;
        }

        public int getValue() {

            return this.value;
        }
    }

    public enum Filter {
        NoFill(0), SolidForeground(1), FineDots(2), AltBars(3), SparseDots(4), BigSpots(9), Bricks(10), Squares(15), Diamonds(16);

        private int value;

        private Filter(int value) {

            this.value = value;
        }

        public int getValue() {

            return value;
        }
    }

    public enum CellType {
        None(-1), String(0), Numeric(1), Numeric2(2), NumericComma(3), NumericComma2(4), Percent(9), Percent2(10), Date(14), Datetime(22);

        private int value;

        private CellType(int value) {

            this.value = value;
        }

        public int getValue() {

            return value;
        }
    }

}
