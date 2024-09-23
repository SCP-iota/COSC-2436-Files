package io.github.scpiota.sortstats;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var algos = new ArrayList<Algorithm>();
        // TODO: Add algorithms

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
