package io.github.scpiota.coms8.organs;

import io.github.scpiota.coms8.CyberneticOrgan;

public class CyberneticBrain extends CyberneticOrgan {
    private int controlEfficiency = 90;

    public int getControlEfficiency() {
        return controlEfficiency;
    }

    public void setControlEfficiency(int controlEfficiency) {
        this.controlEfficiency = controlEfficiency;
    }

    public CyberneticBrain() {
        super("CyberBrain", "Thinks");
    }
}
