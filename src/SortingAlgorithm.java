public class SortingAlgorithm {
    public static void main(String args[])
    {
        SortingAlgorithm ob = new SortingAlgorithm();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }

    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    //Bubble sorting
    public static void bubbleSort (int arr[]) {
        for (int a = 1; a <arr.length; a++){
            for(int b=arr.length-1;b>=a;b--){
                if(arr[b-1]>arr[b]){
                    int temp = arr[b - 1];
                    arr[b-1]=arr[b];
                    arr[b]=temp;
                }
            }
        }
    }
}
