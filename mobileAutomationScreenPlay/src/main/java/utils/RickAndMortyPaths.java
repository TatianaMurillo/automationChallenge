package utils;

public enum RickAndMortyPaths {


    CHARACTERS("/character");


    String value;

    RickAndMortyPaths(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
