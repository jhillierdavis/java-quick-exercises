package com.jhdit.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceBasedWorker implements Worker {
    private Sender sender = new SlowSender();

    public int doWork(List<Integer> messages) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> callableTasks = createCallableTaskList(messages);

        List<Future<Integer>> futures = executorService.invokeAll(callableTasks);
        executorService.shutdown();

        return joinToTotalSum(futures);
    }

    private List<Callable<Integer>> createCallableTaskList(List<Integer> messages) {
        List<Callable<Integer>> callableTasks = new ArrayList<>();

        for (Integer message: messages) {
            callableTasks.add(() -> {
                return sender.send(message);
            });
        }
        return callableTasks;
    }

    private int joinToTotalSum(List<Future<Integer>> futures) throws Exception   {
        int sum = 0;
        for(Future<Integer> future : futures)   {
            sum += future.get();
        }
        return sum;
    }
}
