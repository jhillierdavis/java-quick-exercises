package com.jhdit.algorithms.frequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class MostFrequentNumberUsingMapImplementationTest {
    // Subject under test (SUT)
    MostFrequentNumber sut = new MostFrequentNumberUsingMapImplementation();

    @Test
    public void testWithoutResult() {
        // Given: an empty list
        List<Integer> setOfNumbers = new ArrayList();

        // When
        Integer mostCommon = sut.mostCommonNumber(setOfNumbers);

        // Then: -1 is returned
        Assertions.assertEquals(new Integer(-1), mostCommon);
    }

    @ParameterizedTest
    @CsvSource({"4,4", "7,7"})
    public void parameterized(Integer input, Integer output) {
        Assertions.assertEquals(input, output);
    }

    @Test
    public void testWithUniqueResult() {
        // Given
        String[] array = "4,2,3,4,7,7,8,4,6,5,3".split("\\s*,\\s*");
        List<Integer> numberList = Arrays.asList(array).stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Integer expectedMostCommon = 4;

        // When
        Integer mostCommon = sut.mostCommonNumber(numberList);

        // Then
        Assertions.assertEquals(expectedMostCommon, mostCommon);
    }

    @Test
    public void testWithMultipleResults() {
        // Given: a list of numbers where multiple are the most frequent
        List<Integer> setOfNumbers = Arrays.asList(1,1,1,2,2,2);

        // When
        Integer mostCommon = sut.mostCommonNumber(setOfNumbers);

        // Then: the first of the most frequent numbers is returned
        Assertions.assertEquals(new Integer(1), mostCommon);
    }
}
