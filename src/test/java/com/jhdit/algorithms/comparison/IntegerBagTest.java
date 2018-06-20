package com.jhdit.algorithms.comparison;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for @see IntegerBag
 */

class IntegerBagTest {

    @Test
    void testFindAllSmallerThan() {
        // Setup: an expected integer result list
        List<Integer> expectedList = Arrays.asList(1,3,3,2);

        // Given: the SUT (Subject Under Test) initialised with a integer list
        List<Integer> candidates = Arrays.asList(1,3,5,7,4,3,2,5,8,9,5,45,55,34);
        IntegerBag sut = new IntegerBag(candidates);

        // When: compared
        List<Integer> comparisonList = Arrays.asList(99, 5, 45, 76, 8, 5, 7, 9, 9, 6, 599, 54, 4);
        List<Integer> lessThanList = sut.findAllSmallerThan(comparisonList);

        // Then: the expected list of numbers less than those supplied is returned
        assertFalse(lessThanList.isEmpty() , "Empty results list");
        assertEquals(lessThanList.size(), expectedList.size(), "List size mismatch, expected: " + expectedList.size() + " , actual: " + lessThanList.size() );
        assertTrue(lessThanList.containsAll(expectedList), "List content mismatch");
    }

    /**
     * Finds lowest amount of numbers (from a list) which sum to over 100
     */

    @Test
    void findLargestTerms()  {
        // Setup
        List<Integer> expectedList = Arrays.asList(46,32,32);

        // Given: an instance of the SUT (Subject Under Test)
        List<Integer> possibleTerms = Arrays.asList(5,6,3,23,46,4,32,3,32);
        IntegerBag sut = new IntegerBag(possibleTerms);

        // When: the SUT is invoked
        List<Integer> largestTerms = sut.findLargestTerms(100);

        // Then: the expected largest terms (addends, summands) are found
        assertFalse( largestTerms.isEmpty() , "Unexpected empty results list" );
        assertEquals(largestTerms, expectedList, "List size mismatch, expected: " + expectedList.size() + " , actual: " + largestTerms.size() );
        assertTrue(expectedList.containsAll( largestTerms ), "List content mismatch");
    }
}
