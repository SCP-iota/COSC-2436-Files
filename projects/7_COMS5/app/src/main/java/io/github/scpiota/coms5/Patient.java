package io.github.scpiota.coms5;

import java.util.ArrayList;

public class Patient {
    private String name;
    private int age;
    private String medicalHistory;
    private CyberneticOrgan[] installedOrgans = new CyberneticOrgan[5];
    private int numOrgans = 0;
    private String bloodType;
    private int weight;
    private String hlaType;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public CyberneticOrgan[] getInstalledOrgans() {
        return installedOrgans;
    }

    public int getNumOrgans() {
        return numOrgans;
    }

    public String getBloodType() {
        return bloodType;
    }

    public int getWeight() {
        return weight;
    }

    public Patient(String name, String bloodType, int weight, String hlaType) {
        this.name = name;
        this.bloodType = bloodType;
        this.weight = weight;
        this.hlaType = hlaType;
    }

    public String getHla() {
        return hlaType;
    }

    public void addOrgan(CyberneticOrgan organ) throws Exception {
        if(numOrgans >= 5) {
            throw new Exception("Cannot install more than 5 organs");
        }
        
        installedOrgans[numOrgans] = organ;
    }

    public ArrayList<CyberneticOrgan> getOrganList() {
        var organList = new ArrayList<CyberneticOrgan>();

        for(var organ : installedOrgans) {
            organList.add(organ);
        }

        return organList;
    }

    public String getPatientInfo() {
        return "Name: " + name + "\nAge: " + age + "\nMedical History: " + medicalHistory;
    }
}
