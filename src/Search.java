public class Search {
    private static int binarySearchValue = 7;
    private static int[] arrayBinary = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        binarySearch(binarySearchValue, arrayBinary);
    }

    //Good link https://www.baeldung.com/java-binary-search
//binarySearch must be used only for sorted data structures
    static int binarySearch(int value, int[] array) {
        int index = 0;
        int lowIndex = 0;
        int highIndex = array.length - 1;
        while (lowIndex <= highIndex) {
            int middleIndex = (highIndex + lowIndex) / 2;
            if (array[middleIndex] < value) {
                lowIndex = middleIndex + 1; //added +1 to avoid looping
            } else if (array[middleIndex] > value) {
                highIndex = middleIndex - 1;
            } else if (array[middleIndex] == value) {
                index = middleIndex;
                break;
            } else {
                System.out.println("\nFound a match for " + value + "at Index " + middleIndex);
                lowIndex = highIndex + 1;
            }
        }
        System.out.println(index);
        return index;
    }
}
