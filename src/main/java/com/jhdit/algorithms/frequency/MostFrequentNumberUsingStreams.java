package com.jhdit.algorithms.frequency;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MostFrequentNumberUsingStreams implements MostFrequentNumber {

    @Override
    public Set<Integer> findFrom(List<Integer> numbers) {
        Map<Integer, Long> frequencyMap = createFrequencyMap(numbers);

        Optional<Long> optionalLong = frequencyMap.values().stream().max(Long::compare);

        if (optionalLong.isPresent())   {
            Long maxFrequency = optionalLong.get();
            return frequencyMap.keySet().stream().filter(key -> frequencyMap.get(key) == maxFrequency).collect(Collectors.toSet());

        }
        return Collections.emptySet();
    }

    private Map<Integer, Long> createFrequencyMap(List<Integer> numbers)  {
        Map<Integer, Long> frequencyMap = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return frequencyMap;
    }
}
