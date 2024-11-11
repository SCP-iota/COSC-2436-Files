package io.github.scpiota.coms8;

import java.util.ArrayList;
import java.util.Collections;

public class OrganInventory {
    private ArrayList<CyberneticOrgan> inventory = new ArrayList<>();

    public ArrayList<CyberneticOrgan> getOrgans() {
        return inventory;
    }

    public void addOrgan(CyberneticOrgan organ) {
        inventory.add(organ);
    }

    public boolean removeOrgan(String model) {
        for(var organ : inventory) {
            if (organ.getModel().equals(model)) {
                inventory.remove(organ);
                return true;
            }
        }

        return false;
    }

    public ArrayList<CyberneticOrgan> getOrganList() {
        return inventory;
    }

    public CyberneticOrgan getOrgan(String model) {
        for(var organ : inventory) {
            if (organ.getModel().equals(model)) {
                return organ;
            }
        }

        return null;
    }

    public ArrayList<CyberneticOrgan> searchOrganByFunctionality(String functionality) {
        var organs = new ArrayList<CyberneticOrgan>();

        for(var organ : inventory) {
            if (organ.getFunctionality().equals(functionality)) {
                organs.add(organ);
            }
        }

        return organs;
    }

    public ArrayList<CyberneticOrgan> sortOrgansByModel() {
        Collections.sort(inventory, (organ1, organ2) -> {
            return organ1.getModel().compareTo(organ2.getModel());
        });

        return inventory;
    }

    public ArrayList<CyberneticOrgan> sortOrganByNameModelAndCompatibilityUsingBuiltInSort() {
        Collections.sort(inventory);
        return inventory;
    }

    public ArrayList<CyberneticOrgan> quickSortOrganByNameModelAndCompatibility() {
        inventory = Partition.quickSort(inventory);
        return inventory;
    }
}
