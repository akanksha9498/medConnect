package com.apps.medConnect.model;

public enum Speciality {
    Orthopedic,
    Gynecology,
    Dermatology,
    ENT;
    public static Speciality fromString(String value) {
        for (Speciality speciality : Speciality.values()) {
            if (speciality.name().equalsIgnoreCase(value)) {
                return speciality;
            }
        }
        throw new IllegalArgumentException("No constant with name " + value + " found for enum City");
    }
}
