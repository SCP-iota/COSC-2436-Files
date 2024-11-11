package io.github.scpiota.coms9;

public class CyberneticOrgan implements Comparable<CyberneticOrgan> {
    private int id;
    private String name;
    private String model;
    private String functionality;
    private String compatibility;
    private String bloodType;
    private int health = 100;

    public int getId() {
        return id;
    }

    public String getBloodType() {
        return bloodType;
    }

    public int getWeight() {
        return weight;
    }

    public String getHla() {
        return hlaType;
    }

    private int weight;
    private String hlaType;

    public String getName() {
        return name;
    }

    public String getCompatibility() {
        return compatibility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.min(health, 100);
    }

    public CyberneticOrgan(String name, String model, String functionality, String bloodType, int weight, String hlaType) {
        this.name = name;
        this.model = model;
        this.functionality = functionality;
        this.bloodType = bloodType;
        this.weight = weight;
        this.hlaType = hlaType;
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
