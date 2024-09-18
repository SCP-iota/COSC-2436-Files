package io.github.scpiota.coms3;

public class CyberneticOrgan {
    private int id;
    private String model;
    private String functionality;
    private String compatibility;
    private int health = 100;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.min(health, 100);
    }

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
