package _1_Arrays_Strings;

/* There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character.
Given two strings write a function to check if they are one edit (or zero edits) away.
Example:
pale,ple -> true
pales, pale -> true
pale,bale -> true
pale, bae -> false
Replacement: different in one place
Insertion: the strings apple and aple are one insertion away. This means that if you compared the strings, they would be identical,
except for a shift at some point in the strings.
Removal: The strings apple and aple are also one removal away, since removal is just the inverse of insertion
*/
public class OneWay {
    public static void main(String[] args) {
  //      oneEditAway("pale", "bale"); //test for replace
        oneEditAway("pales", "pale"); //test for insert/remove
    }

    //merge insertion and removal into one step
    static boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }

   static private boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    //Check if you can insert a character into s1 to make s2
   static private boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
