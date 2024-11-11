package io.github.scpiota.coms8;

import io.github.scpiota.coms8.queue.WaitingList;

public class Main {
    public static void main(String[] args) {
        // Create a waiting list
        WaitingList waitingList = new WaitingList();

        // Create some patients
        Patient johnDoe = new Patient("P001", "John Doe", "A+", 70, "HLA-A");
        Patient janeSmith = new Patient("P002", "Jane Smith", "B-", 65, "HLA-B");
        Patient bobJohnson = new Patient("P003", "Bob Johnson", "O+", 80, "HLA-A");
        Patient aliceBrown = new Patient("P004", "Alice Brown", "AB-", 55, "HLA-C");

        // Add patients to the waiting list
        System.out.println("Adding patients to the waiting list...");
        waitingList.addPatient(johnDoe, 5);
        waitingList.addPatient(janeSmith, 3);
        waitingList.addPatient(bobJohnson, 4);

        // Display initial waiting list
        System.out.println("\nInitial Waiting List:");
        waitingList.displayWaitingList();

        // Add a new patient
        System.out.println("\nAdding new patient: Alice Brown (Priority: 6)");
        waitingList.addPatient(aliceBrown, 6);

        // Display updated waiting list
        System.out.println("Updated Waiting List:");
        waitingList.displayWaitingList();

        // Remove highest priority patient
        Patient removedPatient = waitingList.removeHighestPriority();
        System.out.println("\nRemoving highest priority patient: " + removedPatient.getName());

        // Update priority for a patient
        System.out.println("\nUpdating priority for Bob Johnson to 7");
        waitingList.updatePriority("P003", 7);

        // Display updated waiting list
        System.out.println("Updated Waiting List:");
        waitingList.displayWaitingList();

        // Create an organ
        CyberneticOrgan cyberHeart = new CyberneticOrgan("CyberHeart-X1", "O001", "Pumps blood", "A+", 350, "HLA-A");

        // Create an OrganCompatibilityAnalyzer
        OrganCompatibilityAnalyzer analyzer = new OrganCompatibilityAnalyzer();

        // Match organ to waiting list
        System.out.println("\nMatching "+cyberHeart.getName()+" to Waiting List:");
        Patient matchedPatient = analyzer.findCompatiblePatient(cyberHeart, waitingList);
        if (matchedPatient != null) {
            int priority = waitingList.getPosition(matchedPatient.getId());
            System.out.println("Compatible patient found: " + matchedPatient.getName() +
                    " (Priority: " + priority + ")");
        } else {
            System.out.println("No compatible patient found in the waiting list.");
        }

        //after matchingPatient is found, remove the patient from the waiting list
        System.out.println("\nRemoving matched patient from the waiting list...");
        waitingList.removePatient(matchedPatient.getId());
        System.out.println("Updated Waiting List:");
        waitingList.displayWaitingList();
    }
}