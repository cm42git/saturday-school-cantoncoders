package org.example.strings;

public class Urlify {

    public static void replaceSpaces(char[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == ' ') {
                for (int j = input.length - 1; j > i; j--) {
                    input[j] = input[j - 2];
                }
                input[i] = '%';
                input[i + 1] = '2';
                input[i + 2] = '0';
                i = i + 3;
            }
        }
    }

}
