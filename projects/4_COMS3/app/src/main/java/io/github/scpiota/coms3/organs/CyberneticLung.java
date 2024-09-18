package io.github.scpiota.coms3.organs;

import io.github.scpiota.coms3.CyberneticOrgan;

public class CyberneticLung extends CyberneticOrgan {
    private int oxygenLevel = 95;

    public int getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(int oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    public CyberneticLung() {
        super("CyberLung", "Breathes");
    }
}
