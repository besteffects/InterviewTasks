package _1_Arrays_Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsUnique {
    public static void main(String[] args) {
        //  1 Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
        String unique1 = "12345";
        String unique2 = "Noot";
        String unique3 = "ASDFGA";
//        System.out.println(isUnique(unique1));
//        System.out.println(isUnique(unique2));
//        System.out.println(isUnique(unique3));
//
//        System.out.println(isUnique1(unique1));
//        System.out.println(isUnique1(unique2));
//        System.out.println(isUnique1(unique3));
//
//        System.out.println(isUnique2(unique1));
//        System.out.println(isUnique2(unique2));
//        System.out.println(isUnique2(unique3));

        System.out.println(isUnique3(unique1));
        System.out.println(isUnique3(unique2));
        System.out.println(isUnique3(unique3));
    }

    //1
    static boolean isUnique(String input) {
        //ASCII string
        if (input.length() > 128) {
            return false;
        }
        boolean[] inputChar = new boolean[128];
        //flag at index i indicates whether character i in the alphabet is contained in the string.
        //The second time you see the character, you immediately return false.
        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i);
            if (inputChar[val]) {
                return false;
            }
            inputChar[val] = true;
        }
        return true;
    }

    //1a On2 Compare every character of the string to every other character of the string
    static boolean isUnique1(String name) {
        char[] array = name.toCharArray();
        // If at any time we encounter 2 same
        // characters, return false
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return false;
                }
            }
        }
        // If no duplicate characters encountered,
        // return true
        return true;
    }
    //1b
    static boolean isUnique2(String name) {
        char[] chars = name.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
            } else return false;
        }
        return true;
    }
    //1c Sort the string and then linearly check the string for neighboring characters that are identical.
    static boolean isUnique3(String name) {
        boolean isUnique=false;
        char[] array = name.toCharArray();
        Arrays.sort(array);
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] == array[i + 1]) {
                isUnique=false;
                break;
            }
            else isUnique=true;
        }
        return isUnique;
    }
}
