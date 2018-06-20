package com.jhdit.concurrency;

import java.util.List;

public class SynchronousWorker implements Worker {
    private Sender sender = new SlowSender();

    @Override
    public int doWork(List<Integer> messages) throws Exception   {
        int sum = 0;
        for(Integer message : messages) {
            sum += sender.send(message);
        }
        return sum;
    }
}
