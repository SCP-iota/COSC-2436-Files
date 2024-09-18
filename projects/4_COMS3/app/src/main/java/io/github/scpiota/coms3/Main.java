package io.github.scpiota.coms3;

import java.util.Random;

import io.github.scpiota.coms3.organs.CyberneticBrain;
import io.github.scpiota.coms3.organs.CyberneticHeart;
import io.github.scpiota.coms3.organs.CyberneticLung;

public class Main {
    private static Random rand = new Random();

    public static void main(String[] args) {
        var inventory = new OrganInventory();
        System.out.println("Adding organs to inventory...");
        CyberneticOrgan cyberHeartX1 = new CyberneticHeart();
        inventory.addOrgan(cyberHeartX1);
        System.out.println("Added CyberHeartX1 to inventory.");
        CyberneticOrgan cyberLung = new CyberneticLung();
        inventory.addOrgan(cyberLung);
        System.out.println("Added CyberLung to inventory.\n");
        CyberneticOrgan cyberBrain = new CyberneticBrain();
        inventory.addOrgan(cyberBrain);
        System.out.println("Added CyberBrain to inventory.\n");
        
        System.out.println("Initial States:");
        System.out.println("Heart health: " + cyberHeartX1.getHealth());
        System.out.println("Lung health: " + cyberLung.getHealth());
        System.out.println("Brain health: " + cyberBrain.getHealth() + "\n");
        int end = updateOrgans(inventory, 0, 100);
        System.out.println("Simulation Ended:");
        System.out.println("Time: " + (end + 1));
        System.out.println("Heart health: " + cyberHeartX1.getHealth());
        System.out.println("Lung health: " + cyberLung.getHealth());
        System.out.println("Brain health: " + cyberBrain.getHealth());
    }

    private static int updateOrgans(OrganInventory inv, int i, int n) {
        // Get organs from inventory
        var cyberHeartX1 = (CyberneticHeart) inv.getOrgan("CyberHeartX1");
        var cyberLung = (CyberneticLung) inv.getOrgan("CyberLung");
        var cyberBrain = (CyberneticBrain) inv.getOrgan("CyberBrain");

        // Apply extra damage for special events
        int extraHeartDamage = 0;
        int extraLungDamage = 0;
        int extraBrainDamage = 0;

        if(rand.nextInt(0, 10) == 0) {
            switch(rand.nextInt(0, 3)) {
                case 0:
                    extraHeartDamage = rand.nextInt(-10, 11);
                    break;
                case 1:
                    extraLungDamage = rand.nextInt(-10, 11);
                    break;
                case 2:
                    extraBrainDamage = rand.nextInt(-10, 11);
                    break;
            }
        }

        if(extraHeartDamage > 0) {
            System.out.println("ALERT at time " + (i + 1) + ": Random health change for heart by " + extraHeartDamage + "%");
        } else if(extraLungDamage > 0) {
            System.out.println("ALERT at time " + (i + 1) + ": Random health change for lung by " + extraHeartDamage + "%");
        } else if(extraBrainDamage > 0) {
            System.out.println("ALERT at time " + (i + 1) + ": Random health change for brain by " + extraHeartDamage + "%");
        }

        // Update heart
        cyberHeartX1.setPumpRate(cyberHeartX1.getPumpRate() + (cyberBrain.getControlEfficiency() / 10) - 5 + rand.nextInt(-4, 4));
        int prevHeartHealth = cyberHeartX1.getHealth();
        cyberHeartX1.setHealth(cyberHeartX1.getHealth() + extraHeartDamage - 1 + (cyberLung.getOxygenLevel() / 25) - 2);

        if(cyberHeartX1.getHealth() < 25 && prevHeartHealth >= 25) {
            System.out.println("ALERT at time " + (i + 1) + ": Heart critical! Health at " + cyberHeartX1.getHealth() + "%");
        }

        // Update lung
        cyberLung.setOxygenLevel(cyberLung.getOxygenLevel() + (cyberHeartX1.getPumpRate() / 20) + 3 + rand.nextInt(-2, 2));
        int prevLungHealth = cyberLung.getHealth();
        cyberLung.setHealth(cyberLung.getHealth() + extraLungDamage - 1 + (cyberHeartX1.getPumpRate() / 25) - 2);

        if(cyberLung.getHealth() < 25 && prevLungHealth >= 25) {
            System.out.println("ALERT at time " + (i + 1) + ": Lung critical! Health at " + cyberHeartX1.getHealth() + "%");
        }

        // Update brain
        cyberBrain.setControlEfficiency(cyberBrain.getControlEfficiency() + (cyberLung.getOxygenLevel() / 20) - 3 + rand.nextInt(-2, 2));
        int prevBrainHealth = cyberBrain.getHealth();
        cyberBrain.setHealth(cyberBrain.getHealth() + extraBrainDamage - 1 + (cyberLung.getOxygenLevel() / 25) - 2);

        if(cyberBrain.getHealth() < 25 && prevBrainHealth >= 25) {
            System.out.println("ALERT at time " + (i + 1) + ": Brain critical! Health at " + cyberHeartX1.getHealth() + "%");
        }

        System.out.println("Time: " + (i + 1));
        System.out.println("Heart health: " + cyberHeartX1.getHealth() + " | Pump Rate: " + cyberHeartX1.getPumpRate());
        System.out.println("Lung health: " + cyberLung.getHealth() + " | Oxygen Level: " + cyberLung.getOxygenLevel());
        System.out.println("Brain health: " + cyberBrain.getHealth() + " | Control Efficiency: " + cyberBrain.getControlEfficiency() + "\n");

        // Check if any of the organs have died
        if(cyberHeartX1.getHealth() <= 0 || cyberLung.getHealth() <= 0 || cyberBrain.getHealth() <= 0) {
            return i;
        }

        // Recursively run the update loop n times

        if(i < n - 1) {
            return updateOrgans(inv, i + 1, n);
        }

        return i;
    }
}
