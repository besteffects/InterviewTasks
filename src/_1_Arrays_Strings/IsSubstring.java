package _1_Arrays_Strings;
/*
Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2,
write a code to check if s2 is is a rotation of s1 using only one call to isSubstring  (e.g. "waterbottle" is a
rotation of erbottlewat
 */
public class IsSubstring {
    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }

    static boolean isRotation(String s1, String s2) {
        int len = s1.length();
        //Check that s1 and s2 are equal length and are not empty
        if (len == s2.length() && len > 0) {
            //concatenate s1 and s1 within new buffer
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    private static boolean isSubstring(String s1s1, String s2) {
        return (s1s1.contains(s2));
    }
}
