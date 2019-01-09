package com.github.archerda.jdk.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 自反性/传递性/对称性
 * Create by archerda on 2017/02/14
 */
public class Test {

    public static void main(String[] args) {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1));
        itemList.add(new Item(1));
        itemList.add(new Item(2));
        itemList.add(new Item(2));
        itemList.add(new Item(2));
        itemList.add(new Item(0));
        itemList.add(new Item(-190));


        Collections.sort(itemList, (o1, o2) -> o1.getValue() > o2.getValue() ? 1 : -1);

        for (Item item : itemList) {
            System.out.println(item.getValue());
        }
    }

    private static class Item {
        private Integer value;

        public Item(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
}
