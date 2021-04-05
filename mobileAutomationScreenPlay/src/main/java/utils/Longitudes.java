package utils;


public enum Longitudes {


        CENTIMETERS("Centimetro"),
        KILOMETERS("Kilómetro"),
        METERS("Metro"),
        PIES("Pie");

        String functionalName;

    Longitudes(String functionalName) {this.functionalName=functionalName;}

        public String getFunctionalName() {
            return functionalName;
        }
    }

