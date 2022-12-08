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

    public static int findNumberOfDiff(String candidate, String target) {
        var ci = 0;
        var ti = 0;
        var diff = 0;

        while (ci < candidate.length() && ti < target.length()) {

            if (candidate.charAt(ci) == target.charAt(ti)) {
                ci++;
                ti++;
            } else if (candidate.length() > target.length()) {
                ci++;
                diff++;
            } else if (candidate.length() < target.length()) {
                ti++;
                diff++;
            } else {
                ti++;
                ci++;
                diff++;
            }

            if (ti == target.length()) {
                diff += Math.abs(candidate.length() - ci);
            }
        }
        return diff;
    }
}
