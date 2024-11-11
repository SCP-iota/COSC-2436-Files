package io.github.scpiota.coms9;

import java.util.Stack;

public class PatientHistory {
    private Stack<String> history = new Stack<>();

    public void addMedicalEvent(String event) {
        history.push(event);
    }

    public String viewLatestEvent() {
        return history.peek();
    }

    public String removeLatestEvent() {
        return history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}
