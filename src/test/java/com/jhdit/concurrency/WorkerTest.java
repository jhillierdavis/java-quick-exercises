package com.jhdit.concurrency;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class WorkerTest {

    /**
     * TODO: Simulate some unacceptably slow sychronous process to be improved (speed up, without changing the artificial delay in SlowSender).
     */

    @Test
    void performWork() {
        // Setup
        Worker worker = new SynchronousWorker();
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
        IntStream.range(1, max).forEach(i -> messages.add(i));
        return messages;
    }
}
