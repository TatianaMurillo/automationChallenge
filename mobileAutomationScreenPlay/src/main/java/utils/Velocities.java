package utils;


public enum Velocities {


    MILIMETROXHORA("Milimetro por hora"),
    MILLAXMINUTO("Milla por minuto"),
    METROXMINUTO("Metro por minuto");

        String functionalName;

    Velocities(String functionalName) {this.functionalName=functionalName;}

        public String getFunctionalName() {
            return functionalName;
        }
    }

