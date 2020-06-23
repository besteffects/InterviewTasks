import java.util.Arrays;

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
        //Task 4a
        if (verifyPalindrome1(isPalindrome)) {
            System.out.println(" is a palindrome");
        } else {
            System.out.println(" is not a palindrome");
        }
        //Task 4b
        verifyPalindrome2("madam");
        //Task 5
        findNumberOfSumPairs(new int[]{5, 5, 2, 8, 9, 1}, 10);

        //Task6
        int [] arr= {-3, 1,2,3,4,5,15,53,0};
        System.out.println(Arrays.toString(arr));
        findMaxNumber(arr);

    }

//	1. There is a scoundrel who stole a dog from a neighbor.
//	He wants to write a ransom note, cutting out words from a newspaper.
//	The task is to write a function that accepts 2 strings (text of the newspaper, text of the note)
//	and returns true if all the words from the note are in the text of the newspaper or false if there are not enough words
// cover case when words in note more than in newspaper

    static boolean checkNewspaperWords(String newspp, String note) {
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
    static void findFactor(int n, int k) {
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
    static int findValueInArray(int[] array, int value) {
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
    static boolean verifyPalindrome(String s) {
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

    //4a Check whether the given string is Palindrome (with while and charAt)
    static boolean verifyPalindrome1(String input) {
        System.out.println("4a Check if a String is palindrome with a while loop");
        System.out.print(input);

        String inputLowerCase = input.replaceAll("\\s+", "").toLowerCase();
        int length = inputLowerCase.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = inputLowerCase.charAt(forward++);
            char backwardChar = inputLowerCase.charAt(backward--);
            if (forwardChar != backwardChar) {
                return false;
            }
        }
        return true;
    }

    static void verifyPalindrome2(String A) {
        System.out.println("4b Check if a String is palindrome with charAt and conditional statement");
        //  Scanner sc=new Scanner(System.in);// String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int count = 0;
        for (int i = 0; i < A.length() / 2; i++) {
            if (A.charAt(i) == A.charAt(A.length() - 1 - i)) count++;
        }
        System.out.println((count == A.length() / 2) ? "Yes" : "No");
    }

    /* 5 Find pairs of elements from an array which sum to a specified value. -> Given
     * an array of integers, and a number ‘sum’, find the number of pairs of
     * integers in the array whose sum is equal to ‘sum’. */
    public static int findNumberOfSumPairs(int[] array, int sum) {
        System.out.println("5. Find number of pairs of elements that are equal to the specified sum");
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    count++;
                }
            }
        }
        System.out.println("The count of sum is: " + count);
        return count;
    }

    //6 Find max number in array
    private static int findMaxNumber(int arr[]){
        int maxNum=arr[0];
        for (int i = 0; i <arr.length; i++) {
            if(maxNum<arr[i]){
                maxNum=arr[i];
            }
        }
        System.out.println(maxNum);
        return maxNum;
    }
}
