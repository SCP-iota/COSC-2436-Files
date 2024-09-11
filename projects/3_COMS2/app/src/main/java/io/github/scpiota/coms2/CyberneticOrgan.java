package io.github.scpiota.coms2;

public class CyberneticOrgan {
    private int id;
    private String model;
    private String functionality;
    private String compatibility;

    public CyberneticOrgan(String model, String functionality) {
        this.model = model;
        this.functionality = functionality;
    }

    public String getDetails() {
        return "ID: " + id + "\nModel: " + model + "\nFunctionality: " + functionality + "\nCompatibility: " + compatibility;
    }

    public String getModel() {
        return model;
    }

    public String getFunctionality() {
        return functionality;
    }

    public boolean isCompatible(String patientCompatibility) {
        return false;
    }
}
