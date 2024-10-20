package io.github.scpiota.coms7.queue;

import io.github.scpiota.coms7.Patient;

public class WaitingList {
    private WaitingListNode head;
    
    public WaitingList() {
        head = null;
    }

    public void addPatient(Patient patient, int priority) {
        if(head == null) {
            head = new WaitingListNode(patient, priority);
        } else {
            var current = head;

            while(current.getNext() != null && current.getNext().getPriority() < priority) {
                current = current.getNext();
            }

            current.setNext(new WaitingListNode(patient, priority, current.getNext()));
        }
    }

    public Patient removeHighestPriority() {
        if(head == null) {
            return null;
        }

        var patient = head.getPatient();
        head = head.getNext();
        return patient;
    }

    public void updatePriority(String patientId, int newPriority) {
        if(head == null) {
            return;
        }

        var current = head;

        while(current != null && !current.getPatient().getId().equals(patientId)) {
            current = current.getNext();
        }

        if(current != null) {
            current.setPriority(newPriority);
        }
    }

    public void displayWaitingList() {
        var current = head;

        while(current != null) {
            System.out.println(current.getPatient().getName() + " - " + current.getPriority());
            current = current.getNext();
        }
    }

    public int getPosition(String patientId) {
        var current = head;
        int position = 1;

        while(current != null && !current.getPatient().getId().equals(patientId)) {
            current = current.getNext();
            position++;
        }

        return current == null ? -1 : position;
    }

    public void removePatient(String patientId) {
        if(head == null) {
            return;
        }

        if(head.getPatient().getId().equals(patientId)) {
            head = head.getNext();
            return;
        }

        var current = head;

        while(current.getNext() != null && !current.getNext().getPatient().getId().equals(patientId)) {
            current = current.getNext();
        }

        if(current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }
    }
}
