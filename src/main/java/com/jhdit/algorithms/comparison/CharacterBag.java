package com.jhdit.algorithms.comparison;

import java.util.HashMap;
import java.util.Map;

class CharacterBag {
    private final Map<Character, Integer> vocabCharMap;

    CharacterBag(String chars)  {
        this.vocabCharMap = toCharMap(chars);
    }

    boolean canSpell(String word)   {
        // TODO: Handle punctuation, spaces etc.

        Map<Character, Integer> wordCharMap = toCharMap(word);

        for (Character key: wordCharMap.keySet())   {
            if (!this.vocabCharMap.containsKey(key))   {
                return false;
            }

            Integer wordCharCount = wordCharMap.get(key);
            Integer vocabCharCount = this.vocabCharMap.get(key);

            if (vocabCharCount < wordCharCount) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> toCharMap(String chars)  {
        Map<Character, Integer> charMap = new HashMap<>();
        char[] charArray = chars.toLowerCase().toCharArray();
        for (char ch: charArray) {
            if (charMap.containsKey(ch)) {
                int value = charMap.get(ch);
                charMap.put(ch, ++value);
            } else {
                charMap.put(ch, 1);
            }
        }
        return charMap;
    }
}
