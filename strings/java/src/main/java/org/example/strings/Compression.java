package org.example.strings;


public class Compression {

    public static String compress(String str) {
        // if (str.chars().distinct().count() * 2 >= str.length()) {
        // return str;
        // } else {
        if (str.isEmpty())
            return str;

        var compStr = new StringBuilder();
        int counter = 1;
        var c = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            // char c = str.charAt(i);
            // if (i + 1 < str.length() && str.charAt(i + 1) == c) {
            if (str.charAt(i) == c) {
                counter++;
            }
            if (str.charAt(i) != c) {
                compStr.append(c).append(counter);
                counter = 1;
                c = str.charAt(i);
            }
            if (i + 1 == str.length()) {
                compStr.append(c).append(counter);
            }
        }
        return str.length() == compStr.length() ? str : compStr.toString();
    }
}