package io.github.scpiota.coms1;

public class CyberneticOrgan {
    private int id;
    private String model;
    private String functionality;
    private String compatibility;

    public String getDetails() {
        return "ID: " + id + "\nModel: " + model + "\nFunctionality: " + functionality + "\nCompatibility: " + compatibility;
    }

    public boolean isCompatible(String patientCompatibility) {
        return false;
    }
}
