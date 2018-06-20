package com.jhdit.algorithms.comparison;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for @see CharacterBag
 */

class CharacterBagTest {


    @DisplayName("can word provided be spelt from vocabulary given")
    @ParameterizedTest(name = "{index} ==> vocab=''{0}'', word={1} , expected={2}")
    @CsvSource({
            "Market,Team,true",
            "Market,Kate,true",
            "Market,Teams,false",
            "Guinness,Geniuses,false",
            "Geniuses,Guinness,false",
            "Guinness,Genuine,false",
            "Cameron,Romance,true"
    })
    void canSpell(String vocab, String word, boolean expected) {
        // Given: a SUT (Subject Under Test) initialised with a vocabulary
        CharacterBag charBag = new CharacterBag(vocab);

        // When: the SUT is invoked
        boolean canSpell = charBag.canSpell(word);

        // Then: the expected response is returned
        assertEquals(canSpell, expected);
    }
}
