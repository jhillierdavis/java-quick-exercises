package com.jhdit.concurrency;

import java.util.List;

public class ParallelStreamBasedWorker implements Worker {
    private Sender sender = new SlowSender();

    public int doWork(List<Integer> messages) {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "10");

        int sum = messages.parallelStream().mapToInt(m -> {
                // Handle unchecked exception
                try {
                    return this.sender.send(m);
                } catch (InterruptedException ie) {
                    throw new RuntimeException(ie);
                }
        }).sum();

        return sum;
    }
}
