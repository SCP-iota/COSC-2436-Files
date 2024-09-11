package io.github.scpiota.coms2;

public class Main {
    public static void main(String[] args) {
        var inventory = new OrganInventory();
        System.out.println("Adding organs to inventory...");
        CyberneticOrgan cyberHeartX1 = new CyberneticOrgan("CyberHeartX1", "Pumps blood");
        inventory.addOrgan(cyberHeartX1);
        System.out.println("Added CyberHeartX1 to inventory.");
        CyberneticOrgan cyberEyeV2 = new CyberneticOrgan("CyberEyeV2", "Enhanced vision");
        inventory.addOrgan(cyberEyeV2);
        System.out.println("Added CyberEyeV2 to inventory.\n");

        var johnDoe = new Patient();
        System.out.println("Adding organs to patient John Doe...");

        try {
            johnDoe.addOrgan(cyberHeartX1);
            System.out.println("Added CyberHeartX1 to John Doe's installed organs.\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Searching for organs with functionality 'Enhanced vision'...");
        var organsWithEnhancedVision = inventory.searchOrganByFunctionality("Enhanced vision");
        System.out.println("Found " + organsWithEnhancedVision.size() + " organs(s):");

        for(var organ : organsWithEnhancedVision) {
            System.out.println("- " + organ.getModel());
        }

        System.out.println("\nSorting organs by model name in inventory...\n" +
                           "Sorted organs:");
        
        for(var organ : inventory.sortOrgansByModel()) {
            System.out.println("- " + organ.getModel());
        }
    }
}
