package org.example.strings;

import java.util.LinkedList;
import java.util.List;

public class OneAway {
    public static boolean evaluate(String candidate, String target) {
        int in = (target.length() > candidate.length()) ? target.length() - candidate.length() : 0;
        int ed = 0;
        List<Character> targList = new LinkedList<>();
        for (Character c : target.toCharArray()) {
            targList.add(c);
        }

        for (Character candChar : candidate.toCharArray()) {
            if (targList.contains(candChar)) {
                targList.remove(candChar);
            } else {
                ed++;
            }
        }
        return in + ed <= 1;
    }

}
