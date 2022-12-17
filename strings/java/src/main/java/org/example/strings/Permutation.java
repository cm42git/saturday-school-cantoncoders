package org.example.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Permutation {

    static public boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        /*
         * Map<Character, Integer> strMap1 = new TreeMap<>();
         * Map<Character, Integer> strMap2 = new TreeMap<>();
         * for (int i = 0; i < str1.length(); i++) {
         * char checkChar = str1.charAt(i);
         * // char checkChar = str1.toLowerCase().charAt(i);
         * if (strMap1.containsKey(checkChar)) {
         * strMap1.put(checkChar, strMap1.get(checkChar) + 1);
         * } else {
         * strMap1.put(checkChar, 1);
         * }
         * 
         * checkChar = str2.charAt(i);
         * // checkChar = str2.toLowerCase().charAt(i);
         * if (strMap2.containsKey(checkChar)) {
         * strMap2.put(checkChar, strMap2.get(checkChar) + 1);
         * } else {
         * strMap2.put(checkChar, 1);
         * }
         * }
         * 
         * return strMap1.equals(strMap2);
         */

         // Sat code, how is this working?
        Map<Character, Integer> foundChars = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            var s1 = str1.charAt(i);
            var found = false;
            var foundCount = foundChars.getOrDefault(s1, 0);

            for (int j = 0; j < str2.length(); j++) {
                var s2 = str2.charAt(j);
                if (s1 == s2) {
                    if (foundCount == 0) {
                        found = true;
                        foundChars.put(s1, 1);
                        break;
                    } else {
                        foundCount--;
                    }
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

}
