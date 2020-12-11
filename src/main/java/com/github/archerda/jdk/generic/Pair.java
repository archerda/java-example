package com.github.archerda.jdk.generic;

/**
 * @author luohuida
 */
public class Pair<T, K> {

    public T first;
    public K second;

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public K getSecond() {
        return second;
    }

    public void setSecond(K second) {
        this.second = second;
    }

    public static <E> E getStatic(E a) {
        return a;
    }
}
