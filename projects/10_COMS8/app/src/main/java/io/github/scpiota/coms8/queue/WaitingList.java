package io.github.scpiota.coms8.queue;

import io.github.scpiota.coms8.Patient;

public class WaitingList {
    private WaitingListNode head;
    
    public WaitingListNode getHead() {
        return head;
    }

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

        var highestPriorityNode = head;
        var curr = head;

        while(curr != null) {
            if(curr.getPriority() > highestPriorityNode.getPriority()) {
                highestPriorityNode = curr;
            }

            curr = curr.getNext();
        }

        if(highestPriorityNode == head) {
            head = head.getNext();
        } else {
            curr = head;

            while(curr.getNext() != highestPriorityNode) {
                curr = curr.getNext();
            }

            curr.setNext(highestPriorityNode.getNext());
        }

        return highestPriorityNode.getPatient();
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
