public class Search {
    private static int binarySearchValue;
    private static int[] arrayBinary;

    public static void main(String[] args) {
        binarySearch(binarySearchValue, arrayBinary);
    }

    static void binarySearch(int value, int[] array) {
        int lowIndex = 0;
        int highIndex = array.length - 1;
        while (lowIndex <= highIndex) {
            int middleIndex = (highIndex + lowIndex) / 2;
            if (array[middleIndex] < value) {
                lowIndex = middleIndex;
            } else if (array[middleIndex] > value) {
                highIndex = middleIndex - 1;
            } else if(array[middleIndex]==value){
                highIndex=middleIndex;
            }
            else {
                System.out.println("\nFound a match for " + value + "at Index " + middleIndex);
                lowIndex = highIndex + 1;
            }
        }
    }
}
