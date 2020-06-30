import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _1_Arrays_Strings {

    public static void main(String[] args) {
        // 1 Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

        String unique1 = "12345";
        String unique2 = "Noot";
        String unique3 = "ASDFGA";
        System.out.println(isUnique(unique1));
        System.out.println(isUnique(unique2));
        System.out.println(isUnique(unique3));

        System.out.println(isUnique1(unique1));
        System.out.println(isUnique1(unique2));
        System.out.println(isUnique1(unique3));

        System.out.println(isUnique2(unique1));
        System.out.println(isUnique2(unique2));
        System.out.println(isUnique2(unique3));

        //2 Given two strings, write a method to decide if one is a permutation of the other
        String permut1 = "ABCD";
        String permut2 = "ACDB";
        System.out.println("Check is a string a is a permutation of a string b: " + CheckPermutation(permut1, permut2));

        /* 3 Write a method to replace of spaces in a string with '%20. You may assume that the string has sufficient space
        at the end to hold the additional characters and that you are given true length of the string.
         */
         urlify("Mr John Smith    ", 13);

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

    //On2
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


    // 2
    //a Sort the string
    static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    //b compare lengths of two strings
    static boolean CheckPermutation(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }
        return sort(first).equals(sort(second));
    }

    //2b
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
//3
    static void urlify(String str, int trueLength) {
        char[] strArray = str.toCharArray();
        //in the first scan we count the number of spaces
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (strArray[i] == ' ') {
                spaceCount++;
            }
        }
        //here we compute how many extra characters will be required for the final string
        index = trueLength + spaceCount * 2;
        if (trueLength < strArray.length) {
            strArray[trueLength] = '\0'; //End array (cut off everything after the first n characters)
        }
    //here we replace the space with %20
        for (i = trueLength - 1; i >= 0; i--) {
            if (strArray[i] == ' ') {
                strArray[index - 1] = '0';
                strArray[index - 2] = '2';
                strArray[index - 3] = '%';
                index = index - 3;
            }
            //if there is not space - we copy the original value
            else {
                strArray[index - 1] = strArray[i];
                index--;
            }
        }
        System.out.println(strArray);
    }


}

