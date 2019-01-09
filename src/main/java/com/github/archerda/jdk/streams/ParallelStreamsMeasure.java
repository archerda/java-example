package com.github.archerda.jdk.streams;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by luohd on 16/12/6.
 */
public class ParallelStreamsMeasure {

    public static void main(String[] args) {
        System.out.println("Sequential sum done in: " +
                measureSumPerf(ParallelStreamsMeasure::sequentialSum, 10_000_000) + " msecs");

        System.out.println("Iterative sum done in: " +
                measureSumPerf(ParallelStreamsMeasure::iterativeSum, 10_000_000) + " msecs");

        System.out.println("Parallel sum done in: " +
                measureSumPerf(ParallelStreamsMeasure::parallelSum, 10_000_000) + " msecs" );

        System.out.println("rangedSum sum done in: " +
                measureSumPerf(ParallelStreamsMeasure::rangedSum, 10_000_000) + " msecs" );

        System.out.println("parallelRangedSum sum done in: " +
                measureSumPerf(ParallelStreamsMeasure::parallelRangedSum, 10_000_000) + " msecs" );
    }

    public static long iterativeSum(long n) {
        long result = 0L;

        for (long i = 1L; i <= n; ++i) {
            result += i;
        }

        return result;
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }

        return fastest;
    }

}
