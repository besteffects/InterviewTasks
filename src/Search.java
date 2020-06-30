public class Search {
    private static int binarySearchValue=5;
    private static int[] arrayBinary={1,2,3,4,5,6,7,8,9};


    public static void main(String[] args) {
        binarySearch(binarySearchValue, arrayBinary);
    }
//binarySearch must be used only for sorted data structures
    static void binarySearch(int value, int[] array) {
        int lowIndex = 0;
        int highIndex = array.length - 1;
        while (lowIndex <= highIndex) {
            int middleIndex = (highIndex + lowIndex) / 2;
            if (array[middleIndex] < value) {
                lowIndex = middleIndex+1; //added +1 to avoid looping
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
