package com.jhdit.algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of numbers return the most frequently occurring number
 */

public class MostFrequentNumberUsingMapImplementation implements MostFrequentNumber {
    public Integer mostCommonNumber(List<Integer> numbers) {

        Map<Integer, Integer> map = toFrequencyMap(numbers);

        return findMostFrequentKey(map);
    }

    private Integer findMostFrequentKey(Map<Integer, Integer> map) {
        int mostFrequentKey = -1;
        int mostFrequentValue = -1;

        for(Integer key: map.keySet())  {
            int value = map.get(key);
            if (value > mostFrequentValue)  {
                mostFrequentKey = key;
                mostFrequentValue = value;

            }
        }

        return mostFrequentKey;
    }

    private Map<Integer, Integer> toFrequencyMap(List<Integer> numbers) {
        Map<Integer, Integer> map = new HashMap();
        for(Integer number: numbers) {
            if (map.containsKey(number))    {
                int currentValue = map.get(number);
                map.put(number, ++currentValue);
            } else {
                map.put(number, 1);
            }

        }
        return map;
    }
}
