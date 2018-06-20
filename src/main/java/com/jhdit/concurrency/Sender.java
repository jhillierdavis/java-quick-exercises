package com.jhdit.concurrency;

interface Sender {
    int send(int i) throws InterruptedException;
}
