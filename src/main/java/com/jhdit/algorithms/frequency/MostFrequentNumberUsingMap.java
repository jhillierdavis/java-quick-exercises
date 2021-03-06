package com.jhdit.algorithms.frequency;

import java.util.*;

/**
 * Implementation of @{@link MostFrequentNumber} using Java Map (primarily)
 */

public class MostFrequentNumberUsingMap implements MostFrequentNumber {

    @Override
    public Set<Integer> findFrom(List<Integer> numbers) {

        Map<Integer, Integer> map = toFrequencyMap(numbers);

        return findMostFrequentKey(map);
    }

    private Map<Integer, Integer> toFrequencyMap(List<Integer> numbers) {
        Map<Integer, Integer> map = new HashMap<>();
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

    private Set<Integer> findMostFrequentKey(Map<Integer, Integer> map) {

        Optional<Integer> optionalHighestFrequency = getHighestFrequency(map);
        if (!optionalHighestFrequency.isPresent())   {
            return Collections.emptySet();
        }
        int mostFrequentValue = optionalHighestFrequency.get();


        Set<Integer> set = new HashSet<>();

        for(Integer key: map.keySet())  {
            int value = map.get(key);
            if (value == mostFrequentValue)  {

                set.add(key);
            }
        }

        return set;
    }

    private Optional<Integer> getHighestFrequency(Map<Integer, Integer> map)    {
        Collection<Integer> values = map.values();

        return values.stream().max(Integer::compare);
    }
}
