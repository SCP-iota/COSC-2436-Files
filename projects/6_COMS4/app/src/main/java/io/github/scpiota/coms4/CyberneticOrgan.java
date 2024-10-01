package io.github.scpiota.coms4;

public class CyberneticOrgan implements Comparable<CyberneticOrgan> {
    private int id;
    private String name;
    private String model;
    private String functionality;
    private String compatibility;

    public String getName() {
        return name;
    }

    public String getCompatibility() {
        return compatibility;
    }

    private int health = 100;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.min(health, 100);
    }

    public CyberneticOrgan(String name, String model, String functionality) {
        this.name = name;
        this.model = model;
        this.functionality = functionality;
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

    @Override
    public int compareTo(CyberneticOrgan o) {
        if(getName().equals(o.getName())) {
            if (getModel().equals(o.getModel())) {
                return getCompatibility().compareTo(o.getCompatibility());
            }

            return getModel().compareTo(o.getModel());
        }

        return getName().compareTo(o.getName());
    }
}
