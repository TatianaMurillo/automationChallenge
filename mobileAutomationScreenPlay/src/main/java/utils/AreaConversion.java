package utils;


public class AreaConversion {

    public static enum ACRE {

        HECTARE(0.4047),
        SQUARE_METER(4046.8564);

        double value;

        ACRE(double value) {this.value = value;}

        public double getValue() {
            return value;
        }
    }

    public static enum HECTARE {

        SQUARE_METER(10000),
        ACRE(2.4711);

        double value;

        HECTARE(double value) {this.value = value;}

        public double getValue() {
            return value;
        }
    }


    public static enum SQUARE_METER {

        HECTARE(0.0001),
        ACRE(0.0002471);

        double value;

        SQUARE_METER(double value) {this.value = value;}

        public double getValue() {
            return value;
        }
    }
}
