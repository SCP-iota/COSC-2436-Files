package io.github.scpiota.coms3.organs;

import io.github.scpiota.coms3.CyberneticOrgan;

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
