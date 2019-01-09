package com.github.archerda.advices151;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by luohd on 16/12/27.
 */
public class CollectionShuffle77 {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        Collections.shuffle(integers);
        System.out.println(integers);
    }
}
