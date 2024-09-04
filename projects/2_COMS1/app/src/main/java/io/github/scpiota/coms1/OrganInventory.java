package io.github.scpiota.coms1;

import java.util.List;

public class OrganInventory {
    private List<CyberneticOrgan> inventory;

    public void addOrgan(CyberneticOrgan organ) {
        inventory.add(organ);
    }

    public CyberneticOrgan getOrgan(String model) {
        return null;
    }
}
