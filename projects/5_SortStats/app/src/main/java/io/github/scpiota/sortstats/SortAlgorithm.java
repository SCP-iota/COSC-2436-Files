package io.github.scpiota.sortstats;

public abstract class SortAlgorithm {
    protected String name;

    public String getName() {
        return name;
    }

    public abstract void process(int[] array);
}
