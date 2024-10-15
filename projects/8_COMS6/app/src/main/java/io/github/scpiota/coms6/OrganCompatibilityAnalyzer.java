package io.github.scpiota.coms6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrganCompatibilityAnalyzer {
    private List<CyberneticOrgan> organs;
    private List<Patient> patients;

    public OrganCompatibilityAnalyzer() {
        organs = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addOrgan(CyberneticOrgan organ) {
        organs.add(organ);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public int[][] createCompatibilityMatrix() {
        int[][] matrix = new int[organs.size()][patients.size() * 3]; // 3 factors: blood type, weight, HLA

        for(int i = 0; i < organs.size(); i++) {
            for(int j = 0; j < patients.size(); j++) {
                var organ = organs.get(i);
                var patient = patients.get(j);

                matrix[i][j * 3] = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
                matrix[i][j * 3 + 1] = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
                matrix[i][j * 3 + 2] = calculateHlaCompatibility(organ.getHla(), patient.getHla());
            }
        }

        return matrix;
    }

    private int calculateBloodTypeCompatibility(String donorType, String recipientType) {
        if(donorType.equals(recipientType)) {
            return 100;
        } else if(donorType.equals("O") && recipientType.equals("A")) {
            return 80;
        }
        
        return 0;
    }

    private int calculateWeightCompatibility(int organWeight, int patientWeight) {
        var ratio = ((double) organWeight) / (((double) patientWeight) * 1000);

        if(ratio >= 0.8 && ratio <= 1.2) {
            return 100;
        } else if(ratio >= 0.6 && ratio <= 1.4) {
            return 50;
        }

        return 0;
    }

    private int calculateHlaCompatibility(String organHla, String patientHla) {
        int matches = 0;

        for(int i = 0; i < Math.min(organHla.length(), patientHla.length()); i++) {
            if(organHla.charAt(i) == patientHla.charAt(i)) {
                matches++;
            }
        }

        return (int) Math.floor(((double) matches) / ((double) Math.max(organHla.length(), patientHla.length())) * 100);
    }

    public double[][] calculateWeightedCompatibility(double[] weights) {
        int[][] compatibilityMatrix = createCompatibilityMatrix();
        double[][] resultMatrix = new double[organs.size()][patients.size()];

        for(int i = 0; i < organs.size(); i++) {
            for(int j = 0; j < patients.size(); j++) {
                double sum = 0;

                for(int k = 0; k < 3; k++) {
                    sum += compatibilityMatrix[i][j * 3 + k] * weights[k];
                }

                resultMatrix[i][j] = sum;
            }
        }

        return resultMatrix;
    }


    public void displayMatrix(int[][] matrix) {
        System.out.println("Initial Compatibility Matrix:");

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%3d ", matrix[i][j]);
            }

            System.out.println();
        }
    }

    public void displayWeightMatrix(double[] weights) {
        System.out.println("\nWeight Matrix:");
        for (double weight : weights) {
            System.out.printf("%.2f  ", weight);
        }
        System.out.println();
    }

    public void displayWeightedMatrix(double[][] matrix) {
        System.out.println("\nFinal Weighted Compatibility Matrix:");
        System.out.println("     ");
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%.2f ", matrix[i][j]);
            }

            System.out.println();
        }
    }

    boolean isCompatible(CyberneticOrgan organ, Patient patient) {
        return calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType()) > 0 &&
               calculateWeightCompatibility(organ.getWeight(), patient.getWeight()) > 0 &&
               calculateHlaCompatibility(organ.getHla(), patient.getHla()) > 0;
    }

    List<CyberneticOrgan> getCompatibleOrgans(Patient patient) {
        return organs.stream()
            .filter(organ -> isCompatible(organ, patient))
            .toList();
    }

    public double calculateCompatibilityScore(CyberneticOrgan organ, Patient patient) {
        return 0.4 * ((int)calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType())) +
               0.3 * ((int)calculateWeightCompatibility(organ.getWeight(), patient.getWeight())) +
               0.3 * ((int)calculateHlaCompatibility(organ.getHla(), patient.getHla()));
    }

    Map<Patient, List<Double>> calculateCompatibilityScores() {
        return patients.stream()
            .collect(Collectors.toMap(patient -> patient, patient -> organs.stream()
                .map(organ -> calculateCompatibilityScore(organ, patient))
                .toList()));
    }
}