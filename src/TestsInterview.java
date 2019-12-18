public class TestsInterview {

    public static void main(String[] args) {
        //Task 1
        System.out.println(checkNewspaperWords("abc, de! fg.", "de? fg!"));
        //Task 2
        findFactor(2, 100);
        //Task 3
        findValueInArray(new int[]{6, 8, 3, 7, 5, 6, 1, 4}, 5);
        //Task 4
        String isPalindrome = "level";
        if (verifyPalindrome(isPalindrome)) {
            System.out.println(" is a palindrome");
        } else {
            System.out.println(" is not a palindrome");
        }
    }

//	1. There is a scoundrel who stole a dog from a neighbor.
//	He wants to write a ransom note, cutting out words from a newspaper.
//	The task is to write a function that accepts 2 strings (text of the newspaper, text of the note)
//	and returns true if all the words from the note are in the text of the newspaper or false if there are not enough words
// cover case when words in note more than in newspaper

    public static boolean checkNewspaperWords(String newspp, String note) {
        System.out.println("1. checkNewspaperWords");
        boolean result = false;
        int count = 0;
        String[] newspWords = newspp.split("\\W+");
        String[] noteWords = note.split("\\W+");

        for (String n : newspWords) {
            for (String t : noteWords) {
                if (n.equals(t)) {
                    count++;
                }
            }
        }

        if (count == noteWords.length)
            result = true;

        return result;
    }

    // 2. Find the factors of numbers from n to k
    public static void findFactor(int n, int k) {
        System.out.println("2. Find the factors of numbers from n to k");
        for (int i = n; i <= k; i++) {
            System.out.println("Factors of n " + i + ":");
            for (int j = 2; j < i; j++) {
                if ((i % j) == 0) {
                    System.out.println(j + " ");
                }
            }
        }
    }

    //3 Find a value in unsorted array
    public static int findValueInArray(int[] array, int value) {
        System.out.println("3 Find a value in unsorted array");
        boolean found = false;
        //use for-each style to search array for val.
        for (int x : array) {
            if (x == value) {
                found = true;
                System.out.println("value index is " + array[x]);
                break;
            }

        }
        if (found) {
            System.out.println("Value is found");
        }
        return value;
    }

    //4 Check whether the given string is Palindrome. Examples: madam, racecar, rotor, rotator, Level, anna, civic
    public static boolean verifyPalindrome(String s) {
        System.out.println("4. Check if a String is a palindrome");
        char[] array = s.toCharArray();
        boolean isPalindrome = false;

        //print array of chars
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }

        //Find if a word is a palindrome
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[array.length - 1 - i]) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
