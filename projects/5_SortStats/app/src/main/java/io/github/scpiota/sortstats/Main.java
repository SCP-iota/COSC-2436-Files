package io.github.scpiota.sortstats;

import io.github.scpiota.sortstats.algorithms.BubbleSortAlgorithm;
import io.github.scpiota.sortstats.algorithms.InsertionSortAlgorithm;
import io.github.scpiota.sortstats.algorithms.MergeSortAlgorithm;
import io.github.scpiota.sortstats.algorithms.SelectionSortAlgorithm;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var algos = new ArrayList<SortAlgorithm>();
        algos.add(new BubbleSortAlgorithm());
        algos.add(new SelectionSortAlgorithm());
        algos.add(new InsertionSortAlgorithm());
        algos.add(new MergeSortAlgorithm());

        for (var algo : algos) {
            var benchmark = new Benchmark(algo);
            System.out.println("Algorithm: " + algo.getName());
            System.out.println("Average time: " + benchmark.getAverageTime());
            System.out.println("Min time: " + benchmark.getMinTime());
            System.out.println("Max time: " + benchmark.getMaxTime());
            System.out.println();
        }
    }
}
