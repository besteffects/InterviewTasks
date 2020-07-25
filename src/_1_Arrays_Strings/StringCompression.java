package _1_Arrays_Strings;

/*
Implement a method to perform basic string compression using the counts of repeated characters. For example,
the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the original string,
your method should return the original string. You can assume the string has only uppercase and lowercase letters (a-z).
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compressBad("aabcccccaaa"));
    }

    // Iterate through the string, copying characters to a new string and counting the repeats. At each iteration, check
    //if the current character is the same as the next character. If not, add its compressed version to the result.
    static String compressBad(String string) {
        int repeats = 0;
        String compressedString = "";
        System.out.println(string.length());
        for (int i = 0; i < string.length(); i++) {
            repeats++;
            if (i + 1 >= string.length()||string.charAt(i) != string.charAt(i + 1)) {
                compressedString += string.charAt(i) + Integer.toString(repeats);
                repeats=0;
            }
        }
        return compressedString.length()<string.length()?compressedString:string;
    }
}