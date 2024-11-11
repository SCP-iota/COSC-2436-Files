package io.github.scpiota.coms9;

import io.github.scpiota.coms9.queue.PatientWaitingList;

public class Main {
    public static void main(String[] args) {
        var waitingList = new PatientWaitingList();
        var cyberHeart  =new CyberneticOrgan("CyberHeart-X1", "Pro", "Pumps blood", "O+", 5, "");
        var analyzer = new OrganCompatibilityAnalyzer();

        var alice = new Patient("Alice", "Alice Brown", "O+", 120, "");
        var bob = new Patient("Bob", "Bob Johnson", "A+", 160, "");
        var jane = new Patient("Jane", "Jane Smith", "B-", 130, "");
        var john = new Patient("John", "John Doe", "B+", 140, "");

        waitingList.addPatient(alice);
        waitingList.addPatient(bob);
        waitingList.addPatient(jane);
        waitingList.addPatient(john);

        System.out.println("Current Waiting Queue:");
        waitingList.printWaitingList();

        System.out.println("Adding medical event to Alice's history:\n" +
            "- Annual checkup\n" +
            "- Flu vaccination\n" +
            "- Broken arm surgery\n");
        alice.getHistory().addMedicalEvent("Annual checkup");
        alice.getHistory().addMedicalEvent("Flu vaccination");
        alice.getHistory().addMedicalEvent("Broken arm surgery");

        System.out.println("\nViewing Alice's latest medical event: " + alice.getHistory().viewLatestEvent());
        System.out.println("Removing Alice's latest medical event: " + alice.getHistory().removeLatestEvent());
        System.out.println("\nChecking Alice Brown's medical history for compatibility:\n" +
            "- " + alice.getHistory().removeLatestEvent() +
            "\n- " + alice.getHistory().removeLatestEvent() + '\n');

        if(analyzer.isCompatible(cyberHeart, alice)) {
            System.out.println("Alice Brown is compatible with CyberHeart-X1!");
            waitingList.removeNextPatient();
        } else {
            System.out.println("Alice Brown is not compatible with CyberHeart-X1.");
        }
    }
}