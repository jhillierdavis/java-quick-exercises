package com.jhdit.algorithms.frequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class MostFrequentNumberUsingMapImplementationTest {
    // Subject under test (SUT)
    private MostFrequentNumber sut = new MostFrequentNumberUsingMapImplementation();

    @Test
    void testWithoutResult() {
        // Given: an empty list
        List<Integer> setOfNumbers = new ArrayList<>();

        // When
        Set<Integer> mostCommonSet = sut.mostCommonNumber(setOfNumbers);

        // Then: -1 is returned
        assertTrue(mostCommonSet.isEmpty());
    }

    @DisplayName("unique match expected")
    @ParameterizedTest(name = "{index} ==> inputNumbers=''{0}'', expected={1}")
    @CsvSource({
            "'4,2,3,4,7,7,8,4,6,5,3',4",
            "'1,2,2,3,3,3',3",
            "'99, 27, 99, 50',99"
    })
    void testWithUniqueResult(String inputNumbers, Integer expectedMostCommon) {
        // Given
        List<Integer> numberList = toIntegerList(inputNumbers);

        // When
        Set<Integer> mostCommonSet = sut.mostCommonNumber(numberList);

        // Then
        assertTrue(mostCommonSet.contains(expectedMostCommon));
    }


    @DisplayName("single (first) result expected for multiple matches")
    @ParameterizedTest(name = "{index} ==> inputNumbers=''{0}'', expected={1}")
    @CsvSource({
            "'1,1,1,2,2,2,3','1,2'",
            "'7,5,5,7','5,7'"
    })
    void testWithMultipleResults(String inputNumbers, String expectedNumbers) {
        // Given: a list of numbers where multiple are the most frequent
        List<Integer> numberList = toIntegerList(inputNumbers);
        Set<Integer> expectedSet = toIntegerSet(expectedNumbers);

        // When
        Set<Integer> mostCommonSet = sut.mostCommonNumber(numberList);

        // Then: the first of the most frequent numbers is returned
        assertTrue(mostCommonSet.containsAll(expectedSet));
    }

    private List<Integer> toIntegerList(String inputNumbers) {
        String[] array = inputNumbers.split("\\s*,\\s*");
        return Arrays.stream(array).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    private Set<Integer> toIntegerSet(String inputNumbers) {
        String[] array = inputNumbers.split("\\s*,\\s*");
        return Arrays.stream(array).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());
    }
}
