package com.jhdit.algorithms.comparison;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a bag (non-unique entries) of integers, providing comparison functionality.
 */

class IntegerBag {
    List<Integer> numbers;

    IntegerBag(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /**
     * Find all integers less than those in the list provided.
     * @param numbersToCompare List of numbers to compare against
     * @return List of integers in the bag that are less that the provided list.
     */

    List<Integer> findAllSmallerThan(List<Integer> numbersToCompare) {
        List<Integer> results = new ArrayList<>();

        for (Integer entry: numbers) {
            if (isLessThan(entry, numbersToCompare)) {
                results.add(entry);
            }
        }
        return results;
    }

    private boolean isLessThan(Integer entry, List<Integer> numbersToCompare) {
        for (Integer value : numbersToCompare) {
            if (entry >= value)  {
                return false;
            }
        }
        return true;
    }

}
