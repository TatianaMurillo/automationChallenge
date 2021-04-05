package utils;


public enum Areas {


    ACRE("Acre"),
    HECTARE("Hectarea"),
    SQUARE_METER("Metro cuadrado");

        String functionalName;

    Areas(String functionalName) {this.functionalName=functionalName;}

        public String getFunctionalName() {
            return functionalName;
        }
    }

