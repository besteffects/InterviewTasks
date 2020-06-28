import java.util.HashSet;
import java.util.Set;

public class _1_Arrays_Strings {
    /*
   1 Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
     */
    public static void main(String[] args) {
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
    }

    //1
    static boolean isUnique(String input) {
        if (input.length() > 128) {
            return false;
        }
        boolean[] inputChar = new boolean[128];
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
            if (!set.contains(chars[i])){
                set.add(chars[i]);
            }
            else return false;
        }
        return true;

    }
}

