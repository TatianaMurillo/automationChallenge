package utils;


public class VelocitiesConversion {

    public static enum MILIMETROXHORA {

        MILLAXMINUTO(0.00000001036),
        METROXMINUTO(0.00001667);

        double value;

        MILIMETROXHORA(double value) {this.value = value;}

        public double getValue() {
            return value;
        }
    }

    public static enum MILLAXMINUTO {

        MILIMETROXHORA(96560640),
        METROXMINUTO(1609.344);

        double value;

        MILLAXMINUTO(double value) {this.value = value;}

        public double getValue() {
            return value;
        }
    }


    public static enum METROXMINUTO {

        MILLAXMINUTO(0.0006214),
        MILIMETROXHORA(60000);

        double value;

        METROXMINUTO(double value) {this.value = value;}

        public double getValue() {
            return value;
        }
    }
}
