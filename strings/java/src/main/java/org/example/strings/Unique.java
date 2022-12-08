package org.example.strings;

import java.util.HashSet;
import java.util.Set;

public class Unique {

    static public boolean isUnique(String str) {
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            chars.add(str.charAt(i));
        }

        return chars.size() == str.length();
    }
}
