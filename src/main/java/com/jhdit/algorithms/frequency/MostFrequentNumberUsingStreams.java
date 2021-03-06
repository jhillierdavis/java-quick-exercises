package com.jhdit.algorithms.frequency;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Implementation of @{@link MostFrequentNumber} using Java Streams (primarily)
 */

public class MostFrequentNumberUsingStreams implements MostFrequentNumber {

    @Override
    public Set<Integer> findFrom(List<Integer> numbers) {
        Map<Integer, Long> frequencyMap = createFrequencyMap(numbers);

        Optional<Long> optionalLong = frequencyMap.values().stream().max(Long::compare);

        if (optionalLong.isPresent())   {
            Long maxFrequency = optionalLong.get();
            return frequencyMap.keySet().stream().filter(key -> frequencyMap.get(key).equals( maxFrequency )).collect(Collectors.toSet());

        }
        return Collections.emptySet();
    }

    private Map<Integer, Long> createFrequencyMap(List<Integer> numbers)  {
        return numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }
}
