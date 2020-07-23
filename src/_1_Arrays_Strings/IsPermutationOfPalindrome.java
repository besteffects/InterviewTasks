package _1_Arrays_Strings;

public class IsPermutationOfPalindrome {

    public static void main(String[] args) {
         /* 4 Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase
         the is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be
         limited to just dictionary words.
         To be a permutation of a palindrome, a string can have no more than one character that is odd. This will cover both the odd and the even cases.*/
        System.out.println("Is this phrase a permutation of palindrome? " + isPermutationOfPalindrome("Tact Coa"));
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

