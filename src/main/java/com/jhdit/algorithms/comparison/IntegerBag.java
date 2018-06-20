package com.jhdit.algorithms.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representation of a bag (non-unique entries) of integers, providing comparison functionality.
 */

class IntegerBag {
    private final List<Integer> numbersInReverseOrder;

    IntegerBag(List<Integer> numbers) {
        Collections.sort(numbers, Collections.reverseOrder());
        this.numbersInReverseOrder = numbers;
    }

    /**
     * Find all integers less than those in the list provided.
     * @param numbersToCompare List of numbersInReverseOrder to compare against
     * @return List of integers in the bag that are less that the provided list.
     */

    List<Integer> findAllSmallerThan(List<Integer> numbersToCompare) {
        Collections.sort(numbersToCompare); // Sort smallest to largest (for comparison efficiency)

        List<Integer> results = new ArrayList<>();

        Collections.sort(numbersToCompare);

        for (Integer entry: numbersInReverseOrder) {
            if (isLessThan(entry, numbersToCompare)) {
                results.add(entry);
            }
        }
        return results;
    }

    List<Integer> findLargestTerms(Integer targetSum) {
        if (targetSum < 0)    {
            throw new IllegalArgumentException("Invalid negative sum value");
        }

        List<Integer> termsList = new ArrayList<>();
        int sum = 0;
        for (Integer number: this.numbersInReverseOrder)  {
            if (sum >= targetSum) {
                break;
            }
            sum += number;
            termsList.add(number);
        }

        if (sum < targetSum) {
            return Collections.emptyList();
        }

        return termsList;
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
