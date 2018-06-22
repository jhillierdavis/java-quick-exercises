package com.jhdit.concurrency;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

/**
 * Unit tests to simulate some time-consuming work (implemented via an artificial delay in SlowSender)
 * which would be unacceptably slow if implemented synchronously
 */

class WorkerTest {

    @Test
    void performWorkUsingExecutorService() {
        // Setup
        // Worker worker = new SynchronousWorker();
        Worker worker = new ExecutorServiceBasedWorker();
        int max = 10;


        // When: Some work is performed
        assertTimeoutPreemptively (ofSeconds(5), () ->  {
            int sum = worker.doWork(createMessages(max));

            // Then: the expected result occurs
            int expectedSum = ((max - 1) * max) / 2;
            assertEquals(expectedSum, sum);
        });
    }

    @Test
    void performWorkUsingParallelStreams() {
        Worker worker = new ParallelStreamBasedWorker();
        int max = 10;


        // When: Some work is performed
        assertTimeoutPreemptively (ofSeconds(5), () ->  {
            int sum = worker.doWork(createMessages(max));

            // Then: the expected result occurs
            int expectedSum = ((max - 1) * max) / 2;
            assertEquals(expectedSum, sum);
        });
    }

    private List<Integer> createMessages(int max)  {
        List<Integer> messages = new ArrayList<>();
        IntStream.range(1, max).forEach(messages::add);
        return messages;
    }
}
