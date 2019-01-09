package com.github.archerda.jdk.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by luohd on 2016/9/5.
 */
public class ListIteratorTest {
    public static void main(String[] args) {
        String[] books = {"iOS", "Java", "Go"};

        List<Object> bookList = new ArrayList<>();
        Collections.addAll(bookList, books);

        ListIterator<Object> listIterator = bookList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
            listIterator.add("-----分隔符-----");
        }

        System.out.println("====反向遍历.====");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}
