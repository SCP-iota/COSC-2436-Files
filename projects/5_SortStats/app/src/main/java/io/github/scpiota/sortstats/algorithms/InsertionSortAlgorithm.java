package io.github.scpiota.sortstats.algorithms;

import io.github.scpiota.sortstats.SortAlgorithm;

public class InsertionSortAlgorithm extends SortAlgorithm {

    public InsertionSortAlgorithm() {
        name = "Insertion Sort";
    }

    @Override
    public void process(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
    }
}
