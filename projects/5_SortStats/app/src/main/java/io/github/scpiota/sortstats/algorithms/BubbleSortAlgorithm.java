package io.github.scpiota.sortstats.algorithms;

import io.github.scpiota.sortstats.SortAlgorithm;

public class BubbleSortAlgorithm extends SortAlgorithm {

    public BubbleSortAlgorithm() {
        name = "Bubble Sort";
    }

    @Override
    public void process(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int og = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = og;
                }
            }
        }
    }
}
