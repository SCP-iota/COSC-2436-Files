package io.github.scpiota.coms6;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        var oms = new OrganManagementSystem();

        // Add sample organs
        oms.addOrgan(new CyberneticOrgan("Heart", "CyberHeart X", "Pumps blood", "A+", 300, "1-2-3-4-5-6"));
        oms.addOrgan(new CyberneticOrgan("Kidney", "CyberKidney Plus", "Filters Blood", "B-", 150, "1-3-5-7-9-11"));
        oms.addOrgan(new CyberneticOrgan("Liver", "CyberLiver Beta", "Lives, idk", "O+", 1500, "2-4-6-8-10-12"));

        // Add sample patients
        oms.addPatient(new Patient("John Doe", "A+", 70, "1-2-3-4-5-6"));
        oms.addPatient(new Patient("Jane Smith", "B-", 65, "2-4-6-8-10-12"));
        oms.addPatient(new Patient("Bob Johnson", "O+", 80, "1-3-5-7-9-11"));

        System.out.println("Available Organs:");

        for(var organ : oms.getInventory().getOrgans()) {
            System.out.println(organ.getName() + " (" + organ.getBloodType() + ", " + organ.getWeight() + "kg)");
        }

        System.out.println("\nPatients:");

        for(var patient : oms.getPatients()) {
            System.out.println(patient.getName() + " (" + patient.getBloodType() + ", " + patient.getWeight() + "kg)");
        }

        var ubtBuilder = new StringBuilder();

        for(var bloodType : oms.getUniqueBloodTypes()) {
            ubtBuilder.append(bloodType).append(", ");
        }

        System.out.println("\nUnique Blood Types: [" + ubtBuilder.toString() + "]");

        var patientsByBloodType = oms.groupPatientsByBloodType();
        System.out.println("\nPatients Grouped by Blood Type:");

        for(var bloodType : patientsByBloodType.keySet()) {
            System.out.print(bloodType + ":[");

            for(var patient : patientsByBloodType.get(bloodType)) {
                System.out.print(patient.getName() + ",");
            }

            System.out.println("]");
        }

        System.out.println("\nOrgans Sorted by Weight:");

        for(var organ : oms.getInventory().getOrgans().stream().sorted((o1, o2) -> o2.getWeight() - o1.getWeight()).toList()) {
            System.out.println(organ.getName() + " (" + organ.getBloodType() + ", " + organ.getWeight() + "kg)");
        }

        var compatibilityMatrix = oms.getAnalyzer().createCompatibilityMatrix();
        System.out.println("\nCompatibility Scores:");

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.println(oms.getPatients().get(j).getName() + " - " + oms.getInventory().getOrgans().get(i).getName() + ": " + compatibilityMatrix[i][j]);
            }
        }

        System.out.println("\nTop 3 Compatible Organs for " + oms.getPatients().get(0).getName() + ":");
        var topOrgans = oms.getTopCompatibleOrgans(oms.getPatients().get(0), 3);

        for(var organ : topOrgans) {
            System.out.println(organ.getName() + " (" + organ.getBloodType() + ", " + organ.getWeight() + "kg) - Score: " + oms.getAnalyzer().calculateCompatibilityScore(organ, oms.getPatients().get(0)));
        }
    }
}