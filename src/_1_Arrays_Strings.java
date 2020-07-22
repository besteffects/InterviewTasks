import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _1_Arrays_Strings {

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

        //2 Given two strings, write a method to decide if one is a permutation of the other
        String permut1 = "ABCD";
        String permut2 = "ACDB";
        System.out.println("Check is a string a is a permutation of a string b: " + CheckPermutation(permut1, permut2));

        /* 3 Write a method to replace of spaces in a string with '%20. You may assume that the string has sufficient space
        at the end to hold the additional characters and that you are given true length of the string.
         */
        urlify("Mr John Smith    ", 13);


         /* 4 Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase
         the is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be
         limited to just dictionary words.
         To be a permutation of a palindrome, a string can have no more than one character that is odd. This will cover both the odd and the even cases.*/
        System.out.println("Is this phrase a permutation of palindrome? " + isPermutationOfPalindrome("Tact Coa"));
        System.out.println("Is this phrase a permutation of palindrome? " + isPermutationOfPalindrome1("Tact Coa"));
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

    //2b Check if the two strings have identical character count
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
        index = trueLength + spaceCount; //removed spacecount*2
        if (trueLength < strArray.length) {
            strArray[trueLength] = '\0'; //End array (cut off everything after the first n characters)
        }
        //here we replace the space with %20
        for (i = trueLength - 1; i >= 0 && index > 2; i--) { //added && index>2
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

    // 4 We use a hash table to count how many times each character appears. Then, we iterate through the hash table and ensure
    //that no more than one character has an odd count
    public static boolean isPermutationOfPalindrome(String phrase) {
//4a Build hash table
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    //4c Check that no more than one character has an odd count
    static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {  //same as foundOdd==true
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    //4a Map each character to a number. a->0, b->1, c->2, etc
    //This is case insensitive. Non-letter characters map to -1

    static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    //4b Count how many times each character appears
    static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') -
                Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    // Here we check the number of odd counts as we are going along. When we get to the end, we have our answer
    // Here the code is optimised, but it is slower
    static boolean isPermutationOfPalindrome1(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if ((table[x] % 2) == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }
}

