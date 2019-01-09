package com.github.archerda.advices151;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by luohd on 16/12/27.
 */
public class CollectionIntersection76 {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        List<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        integers1.add(1);
        integers1.add(6);
        integers1.add(7);
        integers1.add(8);
        integers1.add(9);

        integers.addAll(integers1);
        System.out.println(integers);

        Set<Integer> integers2 = new HashSet<>(integers);
        System.out.println(integers2);

    }
}
