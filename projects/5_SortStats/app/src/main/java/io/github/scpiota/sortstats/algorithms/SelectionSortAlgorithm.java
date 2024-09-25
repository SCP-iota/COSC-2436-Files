package io.github.scpiota.sortstats.algorithms;

import io.github.scpiota.sortstats.SortAlgorithm;

public class SelectionSortAlgorithm extends SortAlgorithm {

    public SelectionSortAlgorithm() {
        name = "Selection Sort";
    }

    @Override
    public void process(int[] array) {
        int n = array.length;

        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++)
                if (array[j] < array[minIndex])
                    minIndex = j;

            int og = array[minIndex];
            array[minIndex] = array[i];
            array[i] = og;
        }
    }
}
