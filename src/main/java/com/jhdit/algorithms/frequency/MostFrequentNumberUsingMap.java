package com.jhdit.algorithms.frequency;

import java.util.*;

/**
 * Given a list of numbers return the most frequently occurring number
 */

public class MostFrequentNumberUsingMap implements MostFrequentNumber {

    @Override
    public Set<Integer> mostCommonNumber(List<Integer> numbers) {

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

        return values.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.intValue() > o2.intValue())  {
                    return 1;
                }
                return -1;
            }
        });
    }
}
