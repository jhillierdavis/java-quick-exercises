package com.jhdit.algorithms;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;


public class MostFrequentNumberTest {
    MostFrequentNumber sut = new MostFrequentNumberImplementation();

    @Test
    public void test() {
        // Given
        List<Integer> setOfNumbers = Arrays.asList(4,2,3,4,7,7,8,4,6,5,3);

        // When
        Integer mostCommon = sut.mostCommonNumber(setOfNumbers);

        // Then
        Assertions.assertEquals(new Integer(4), mostCommon);
    }
}
