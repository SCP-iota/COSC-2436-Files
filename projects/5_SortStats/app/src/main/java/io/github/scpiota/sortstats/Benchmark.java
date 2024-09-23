package io.github.scpiota.sortstats;

public class Benchmark {
    private long averageTime;
    private long minTime;
    private long maxTime;
    
    public long getAverageTime() {
        return averageTime;
    }

    public long getMinTime() {
        return minTime;
    }

    public long getMaxTime() {
        return maxTime;
    }

    public Benchmark(int averageTime, int minTime, int maxTime) {
        this.averageTime = averageTime;
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    public Benchmark(Algorithm algo) {
        long minTime = Integer.MAX_VALUE;
        long maxTime = 0;
        long totalTime = 0;

        for(int testNum = 0; testNum <= 10; testNum++) {
            int[] array = new int[1000];
            for (int i = 0; i < 1000; i++) {
                array[i] = (int) (Math.random() * 1000);
            }
            long startTime = System.currentTimeMillis();
            algo.process(array);
            long endTime = System.currentTimeMillis();
            long elapsed = endTime - startTime;
            totalTime += elapsed;

            if(elapsed < minTime) {
                minTime = elapsed;
            }

            if(elapsed > maxTime) {
                maxTime = elapsed;
            }
        }

        this.averageTime = totalTime / 10;
        this.minTime = minTime;
        this.maxTime = maxTime;
    }
}
