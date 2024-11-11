package io.github.scpiota.coms9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OrganManagementSystem {
    private OrganInventory inventory;
    private List<Patient> patients;
    private OrganCompatibilityAnalyzer analyzer;

    public OrganInventory getInventory() {
        return inventory;
    }
    
    public List<Patient> getPatients() {
        return patients;
    }
    
    public OrganCompatibilityAnalyzer getAnalyzer() {
        return analyzer;
    }
    
    public OrganManagementSystem() {
        inventory = new OrganInventory();
        patients = new ArrayList<>();
        analyzer = new OrganCompatibilityAnalyzer();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        analyzer.addPatient(patient);
    }

    public void addOrgan(CyberneticOrgan organ) {
        inventory.addOrgan(organ);
        analyzer.addOrgan(organ);
    }

    public Set<String> getUniqueBloodTypes() {
        return patients.stream()
            .map(Patient::getBloodType)
            .collect(Collectors.toSet());
    }

    public Map<String, List<Patient>> groupPatientsByBloodType() {
        return patients.stream()
            .collect(Collectors.toMap(
                Patient::getBloodType,
                ref -> patients.stream()
                    .filter(patient -> patient.getBloodType().equals(ref.getBloodType()))
                    .toList()));
    }

    List<CyberneticOrgan> getTopCompatibleOrgans(Patient patient, int n) {
        return inventory.getOrgans().stream()
            .sorted((organ1, organ2) -> {
                var compatibility1 = analyzer.calculateCompatibilityScore(organ1, patient);
                var compatibility2 = analyzer.calculateCompatibilityScore(organ2, patient);
                return compatibility2 > compatibility1 ? 1 : -1;
            })
            .limit(n)
            .toList();
    }
}
