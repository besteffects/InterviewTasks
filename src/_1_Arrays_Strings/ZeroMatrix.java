package _1_Arrays_Strings;

import java.util.Arrays;

/*
Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        setZeros(new int[][]{{5, 0, 12, 1}, {9, 5, 3}});
    }

    static void setZeros(int[][] matrix) {
        System.out.println("Initial Array" + Arrays.deepToString(matrix));
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        //Store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) { //in the example was (int j = 0; j < matrix[0].length; j++), but it worked only for square arrays
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        //Nullify rows
        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }

        //Nullify columns
        for (int j = 0; j < column.length; j++) {
            if (column[j]) nullifyColumn(matrix, j);
        }

        System.out.println("Final array: " + Arrays.deepToString(matrix));
    }

    static void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    static void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    //2 Second way.
    /* To make it more efficient we can use a bit vector instead of a boolean array. It would still be 0(1) space.
    We can reduce the space to O(1) by using the first row as a replacement for the row array and the first column as a replacement
    for the column array. This works as follows:
    1. Check if the first row and first column have any zeros, and set variables rowHasZero and columnHasZero. (We'll nullify the first
    row and first column later, if necessary.)
    2. Iterate through the rest of the matrix, setting matrix[i][0] and matrix[0][j] to zero whenever there's a zero matrix[i][j].
    3. Iterate through the rest of matrix, nullifying row i if there's a zero matrix[i][0].
    4. Iterate through rest of matrix, nullifying column j if there'sa zero matrix[0][j].
    5. Nullify the first row and the first column, if necessary (based on values from Step1).
     */
    static void setZeros1(int[][] matrix) {
        boolean rowHasZero = false;
        boolean colHasZero = false;

        // a Check if first row has a zero
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }

        // a Check if first column has a zero
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }

        // b Check for zeros in the rest of the array
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // c Nullify rows based on values in first column
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }

        //d Nullify columns based on values in first row
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                nullifyColumn(matrix, j);
            }
        }

        //Nullify first row
        if (rowHasZero) {
            nullifyRow(matrix, 0);
        }

        //Nullify first column
        if (colHasZero) {
            nullifyColumn(matrix, 0);
        }
    }
}
