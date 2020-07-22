package _1_Arrays_Strings;

public class ReplaceWithUrl {
    public static void main(String[] args) {
        /* 3 Write a method to replace all spaces in a string with '%20. You may assume that the string has sufficient space
        at the end to hold the additional characters and that you are given true length of the string. */
        urlify("Mr John Smith    ", 13);
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
            //if there is no space - we copy the original value
            else {
                strArray[index - 1] = strArray[i];
                index--;
            }
        }
        System.out.println(strArray);
    }
}
