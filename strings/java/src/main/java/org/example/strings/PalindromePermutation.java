package org.example.strings;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    static public boolean isPalindromePermutation(String str) {
        Map<Character, Integer> charsUnique = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                char c = Character.toLowerCase(str.charAt(i));
                if (charsUnique.containsKey(c)) {
                    charsUnique.put(c, charsUnique.get(c) + 1);
                } else {
                    charsUnique.put(c, 1);
                }
            }
        }

        int oddsCount = 0;
        for (Integer cnt : charsUnique.values()) {
            oddsCount += (cnt % 2 == 0) ? 0 : 1;
        }

        return oddsCount <= 1;
    }
}
