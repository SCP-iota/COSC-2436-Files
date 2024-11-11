package io.github.scpiota.coms9.queue;

import io.github.scpiota.coms9.Patient;

public class PatientWaitingList {
    private WaitingList list = new WaitingList();

    public void addPatient(Patient patient) {
        list.addPatient(patient, 0);
    }

    public Patient removeNextPatient() {
        return list.removeHighestPriority();
    }

    public boolean isEmpty() {
        return list.getHead() == null;
    }

    public void printWaitingList() {
        var builder = new StringBuilder();
        var curr = list.getHead();
        int i = 1;

        while(curr != null) {
            if(curr != list.getHead()) {
                builder.append("<-- ");
            }

            builder.append(i + ".[ "  + curr.getPatient().getName() + " ] ");
            builder.append(" ");
            curr = curr.getNext();
            i++;
        }

        System.out.println(builder.toString());
    }
}
