package io.github.scpiota.coms8.queue;

import io.github.scpiota.coms8.Patient;

public class WaitingListNode {
    private Patient patient;
    private int priority;
    private WaitingListNode next;

    public Patient getPatient() {
        return patient;
    }

    public int getPriority() {
        return priority;
    }

    public WaitingListNode getNext() {
        return next;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setNext(WaitingListNode next) {
        this.next = next;
    }

    public WaitingListNode(Patient patient, int priority) {
        this.patient = patient;
        this.priority = priority;
    }

    public WaitingListNode(Patient patient, int priority, WaitingListNode next) {
        this.patient = patient;
        this.priority = priority;
        this.next = next;
    }
}
