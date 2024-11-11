package io.github.scpiota.coms9;

import java.util.ArrayList;
import java.util.List;

public class Partition<T extends Comparable<T>> {
    private ArrayList<T> lesser;
    private ArrayList<T> greater;

    public Partition(ArrayList<T> lesser, ArrayList<T> greater) {
        this.lesser = lesser;
        this.greater = greater;
    }

    public static <T extends Comparable<T>> Partition<T> partition(List<T> arr) {
        var pivot = arr.get(0);
        var lesser = new ArrayList<T>();
        var greater = new ArrayList<T>();

        for(var i = 1; i < arr.size(); i++) {
            if(arr.get(i).compareTo(pivot) < 0) {
                lesser.add(arr.get(i));
            } else {
                greater.add(arr.get(i));
            }
        }

        return new Partition<T>(lesser, greater);
    }

    public static <T extends Comparable<T>> ArrayList<T> quickSort(ArrayList<T> arr) {
        if(arr.size() <= 1) {
            return arr;
        }

        var partition = partition(arr);
        var sorted = new ArrayList<T>();

        for(var item : quickSort(partition.lesser)) {
            sorted.add(item);
        }

        sorted.add(arr.get(0));

        for(var item : quickSort(partition.greater)) {
            sorted.add(item);
        }

        return sorted;
    }
}
