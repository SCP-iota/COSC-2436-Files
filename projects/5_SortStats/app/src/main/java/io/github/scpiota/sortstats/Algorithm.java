package io.github.scpiota.sortstats;

public abstract class Algorithm {
    private String name;

    public String getName() {
        return name;
    }

    public Algorithm(String name) {
        this.name = name;
    }

    public abstract int process(int[] array);
}
