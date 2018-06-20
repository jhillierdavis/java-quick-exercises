package com.jhdit.algorithms.comparison;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a bag (non-unique entries) of integers, providing comparison functionality.
 */

public class IntegerBag {
    List<Integer> numbers;

    public IntegerBag(List<Integer> numbers) {
        this.numbers = numbers;
    }

    List<Integer> findAllSmallerThan(List<Integer> numbersToCompare) {
        List<Integer> results = new ArrayList<>();


        for (Integer entry: numbers) {
            boolean isLessThan = true;
            for (Integer value : numbersToCompare) {
                if (entry >= value)  {
                    isLessThan = false;
                    break;
                }
            }
            if (isLessThan) {
                results.add(entry);
            }
        }
        return results;
    }

}
