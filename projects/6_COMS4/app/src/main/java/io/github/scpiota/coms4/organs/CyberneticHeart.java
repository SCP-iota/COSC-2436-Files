package io.github.scpiota.coms4.organs;

import io.github.scpiota.coms4.CyberneticOrgan;

public class CyberneticHeart extends CyberneticOrgan {
    private int pumpRate = 70;

    public int getPumpRate() {
        return pumpRate;
    }

    public void setPumpRate(int pumpRate) {
        this.pumpRate = pumpRate;
    }

    public CyberneticHeart() {
        super("CyberHeartX1", "Pumps blood");
    }
}
