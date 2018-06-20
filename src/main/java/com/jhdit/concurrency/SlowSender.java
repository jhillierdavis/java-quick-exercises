package com.jhdit.concurrency;

/**
 * Simulate the slow sender behaviour
 */

class SlowSender implements Sender {
    public int send(int i) throws InterruptedException {
        Thread.sleep(3000); //simulates an I/O delay
        return i;
    }
}
