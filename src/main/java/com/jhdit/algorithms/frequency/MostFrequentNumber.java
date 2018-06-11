package com.jhdit.algorithms.frequency;

import java.util.List;
import java.util.Set;

public interface MostFrequentNumber {

    /**
     * Return the set of most frequently occurring numbers from a provided list
     * E.g.:
     *
     * [] => []
     * [1,1,2] => [1]
     * [1,1,2,2] => [1,2]
     *
     * @param numbers A list of numbers
     * @return Set of most frequency occurring numbers
     */

    Set<Integer> findFrom(List<Integer> numbers);
}
