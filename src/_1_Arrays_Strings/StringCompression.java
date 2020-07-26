package _1_Arrays_Strings;

/*
Implement a method to perform basic string compression using the counts of repeated characters. For example,
the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the original string,
your method should return the original string. You can assume the string has only uppercase and lowercase letters (a-z).
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compressBad("aabccaaaa"));
        System.out.println(compress("aabccaaaa"));
        System.out.println(compress1("aabccaaaa"));
    }

    //1.  Iterate through the string, copying characters to a new string and counting the repeats. At each iteration, check
    //if the current character is the same as the next character. If not, add its compressed version to the result.
    static String compressBad(String string) {
        int repeats = 0;
        String compressedString = "";
        System.out.println("String length: " + string.length());
        for (int i = 0; i < string.length(); i++) {
            repeats++;
            if (i + 1 >= string.length() || string.charAt(i) != string.charAt(i + 1)) { //i+1 never becomes >string.length() "aabccaaaaa" (last i+1 is 8+1. length is 9), so == will also work.
                compressedString += string.charAt(i) + Integer.toString(repeats);
                repeats = 0;
            }
        }
        return compressedString.length() < string.length() ? compressedString : string;
    }

    //2.StringBuilder  method
    static String compress(String string) {
        StringBuilder compressed = new StringBuilder();
        int countconsecutive = 0;
        for (int i = 0; i < string.length(); i++) {
            countconsecutive++;
            /*
            If next character is different than current, append this char to result.
             */
            if (i + 1 == string.length() || string.charAt(i) != string.charAt(i + 1)) {
                compressed.append(string.charAt(i));
                compressed.append(countconsecutive);
                countconsecutive = 0;
            }
        }
        return compressed.length() < string.length() ? compressed.toString() : string;
    }


    //3. In the case when there are not large amount of repeating characters
    static String compress1(String string) {
        //Check final string and return input string if it would be longer
        int finalLength = countCompression(string);
        if (finalLength >= string.length()) {
            return string;
        }
        StringBuilder compressed = new StringBuilder(finalLength); //initial capacity
        for (int i = 0; i < string.length(); i++) {
            int countConsecutive = 0;

            //If next character is different than current, append this char to result
            if (i + 1 > string.length() || string.charAt(i) != string.charAt(i + 1)) {
                compressed.append(string.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    private static int countCompression(String string) {
        int compressedLength=0;
        int countConsecutive=0;
        for (int i = 0; i <string.length() ; i++) {
            countConsecutive++;

            //If next character is different than current, increase the length
            if (i+1>=string.length() || string.charAt(i)!=string.charAt(i+1)){
                compressedLength+=1+string.valueOf(countConsecutive).length();
                countConsecutive=0;
            }
        }
        return compressedLength;
    }
}