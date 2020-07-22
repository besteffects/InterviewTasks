package _1_Arrays_Strings;

import java.util.Arrays;

public class IsPermutation {
    public static void main(String[] args) {
        //2 Given two strings, write a method to decide if one is a permutation of the other
        String permut1 = "ABCD";
        String permut2 = "ACDB";
        System.out.println("Check is a string a is a permutation of a string b: " + checkPermutation(permut1, permut2));
    }

    // 2
    //a Sort the string
    static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    //b compare lengths of two strings
    static boolean checkPermutation(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }
        return sort(first).equals(sort(second));
    }

    //2b Check if the two strings have identical character count
    //Iterate through the code counting how many times each character appears
    static boolean permutation1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[128]; //Assumption
        char[] s_array = s.toCharArray();
        for (char c : s_array) { //count number of each char in s.
            letters[c]++;
        }
//compare two arrays
        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
