package com.jhdit.concurrency;

import java.util.List;

public interface Worker {
    int doWork(List<Integer> messages) throws Exception;
}
