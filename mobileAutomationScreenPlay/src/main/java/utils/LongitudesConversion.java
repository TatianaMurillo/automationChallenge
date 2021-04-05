package utils;


public class LongitudesConversion{

    public static enum PIE {

        CENTIMETERS(30.48),
        KILOMETERS(0.0003048),
        METERS(0.3048);

        double value;

        PIE(double value) {this.value = value;}

        public double getValue() {
            return value;
        }
    }

    public static enum KILOMETER {

        PIES(3280.84),
        METERS(1000),
        CENTIMETERS(100000);

        double value;

        KILOMETER(double value) {this.value = value;}

        public double getValue() {
            return value;
        }
    }


    public static enum METER {

        PIES(3.28084),
        KILOMETERS(0.001),
        CENTIMETERS(100);

        double value;

        METER(double value) {this.value = value;}

        public double getValue() {
            return value;
        }
    }
}
