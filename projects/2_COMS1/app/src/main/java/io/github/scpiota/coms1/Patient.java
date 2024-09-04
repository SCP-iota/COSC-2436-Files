package io.github.scpiota.coms1;

import java.util.List;

public class Patient {
    private String name;
    private int age;
    private String medicalHistory;
    private List<CyberneticOrgan> installedOrgans;

    public void addOrgan(CyberneticOrgan organ) {
        installedOrgans.add(organ);
    }

    public String getPatientInfo() {
        return "Name: " + name + "\nAge: " + age + "\nMedical History: " + medicalHistory;
    }
}
