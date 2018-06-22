package com.jhdit.concurrency;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamBasedWorker implements Worker {
    private Sender sender = new SlowSender();

    public int doWork(List<Integer> messages) {
        setThreadPoolSize(10);

        int sum = calculateSumUsingStreams(messages);

        return sum;
    }

    /**r
     * Override the default thread pool  size (set to the number of processors), used by parallel streams, to the supplied value.
     * @param numberOfThreadsInPool Desired thread pool size
     */

    private void setThreadPoolSize(int numberOfThreadsInPool) {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "" + numberOfThreadsInPool);
    }

    private int calculateSumUsingStreams(List<Integer> messages) {
        return messages.parallelStream().mapToInt(m -> {
                    // Handle unchecked exception
                    try {
                        return this.sender.send(m);
                    } catch (InterruptedException ie) {
                        throw new RuntimeException(ie);
                    }
            }).sum();
    }

/*
    // Alternative implementation using collect()

    private int calculateSumUsingStreams(List<Integer> messages) {
        return messages.parallelStream().collect(Collectors.summingInt(m -> {
            // Handle unchecked exception
            try {
                return this.sender.send(m);
            } catch (InterruptedException ie) {
                throw new RuntimeException(ie);
            }
        }));
    }
*/

/*
    // Alternative implementation using reduce()

    private int calculateSumUsingStreams(List<Integer> messages) {
        return messages.parallelStream().mapToInt(m -> {
            // Handle unchecked exception
            try {
                return this.sender.send(m);
            } catch (InterruptedException ie) {
                throw new RuntimeException(ie);
            }
        }).reduce(0, Integer::sum);
    }
*/
}
