package com.apps.medConnect.model;

public enum City {
    Delhi,
    Faridabad,
    Noida;
    public static City fromString(String value) {
        for (City city : City.values()) {
            if (city.name().equalsIgnoreCase(value)) {
                return city;
            }
        }
        throw new IllegalArgumentException("No constant with name " + value + " found for enum City");
    }
}
