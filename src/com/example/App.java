package com.example;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dmitin on 19.10.16.
 */
// http://stackoverflow.com/a/34440350/5249621
public class App {
    public static void main(String[] args) {
        MutablePair<Integer, Integer> pair1 = new MutablePair<>(0, 0);
        Set<MutablePair<Integer, Integer>> set1 = new HashSet<>();
        set1.add(pair1);
        System.out.println(set1.contains(new MutablePair<>(0, 0)));
        pair1.setValue1(1);
        pair1.setValue2(1);
        System.out.println(set1.contains(new MutablePair<>(0, 0)));
        System.out.println(set1.contains(new MutablePair<>(1, 1)));

        MutablePair<Integer, Integer> pair2 = new MutablePair<>(0, 0);
        Set<MutablePair<Integer, Integer>> set2 = new ObservingHashSet<>();
        set2.add(pair2);
        System.out.println(set2.contains(new MutablePair<>(0, 0)));
        pair2.setValue1(1);
        pair2.setValue2(1);
        System.out.println(set2.contains(new MutablePair<>(0, 0)));
        System.out.println(set2.contains(new MutablePair<>(1, 1)));
    }
}
