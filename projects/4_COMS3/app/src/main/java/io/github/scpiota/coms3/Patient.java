package io.github.scpiota.coms3;

import java.util.ArrayList;

public class Patient {
    private String name;
    private int age;
    private String medicalHistory;
    private CyberneticOrgan[] installedOrgans = new CyberneticOrgan[5];
    private int numOrgans = 0;

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
