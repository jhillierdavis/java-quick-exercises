package com.jhdit.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;


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


    @Test
    public void testWithUniqueResult() {
        // Given
        List<Integer> setOfNumbers = Arrays.asList(4,2,3,4,7,7,8,4,6,5,3);

        // When
        Integer mostCommon = sut.mostCommonNumber(setOfNumbers);

        // Then
        Assertions.assertEquals(new Integer(4), mostCommon);
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
