package _8_Recursion;
/*
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, ...

The next number is found by adding up the two numbers before it:
the 2 is found by adding the two numbers before it (1+1),
the 3 is found by adding the two numbers before it (1+2),
the 5 is (2+3),
 */
public class Fibonacci {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(fibonacci(10));
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Recursion with no optimization duration (nanoseconds): " + duration);
    }

    //slow method with recursion
    static int fibonacci(int i){
        if (i==0) return 0;
        if (i==1) return 1;
        return fibonacci(i-1)+fibonacci(i-2);
    }
}
