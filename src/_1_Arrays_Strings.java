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

    }

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
}
