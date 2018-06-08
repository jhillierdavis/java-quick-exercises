package com.jhdit.algorithms.frequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        Integer mostCommon = sut.mostCommonNumber(setOfNumbers);

        // Then: -1 is returned
        assertEquals(new Integer(-1), mostCommon);
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
        Integer mostCommon = sut.mostCommonNumber(numberList);

        // Then
        assertEquals(expectedMostCommon, mostCommon);
    }


    @DisplayName("single (first) result expected for multiple matches")
    @ParameterizedTest(name = "{index} ==> inputNumbers=''{0}'', expected={1}")
    @CsvSource({
            "'1,1,1,2,2,2',1",
            "'7,5,5,7',5"
    })
    void testWithMultipleResults(String inputNumbers, Integer expectedMostCommon) {
        // Given: a list of numbers where multiple are the most frequent
        List<Integer> numberList = toIntegerList(inputNumbers);

        // When
        Integer mostCommon = sut.mostCommonNumber(numberList);

        // Then: the first of the most frequent numbers is returned
        assertEquals(expectedMostCommon, mostCommon);
    }

    private List<Integer> toIntegerList(String inputNumbers) {
        String[] array = inputNumbers.split("\\s*,\\s*");
        return Arrays.stream(array).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }
}
