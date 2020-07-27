package _1_Arrays_Strings;

import java.util.Arrays;

/*
Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        setZeros( new int[][]{ {1, 2, 3,5,3,0,12}, {7, 8, 9,5,3}});
    }


    static void setZeros(int[][] matrix) {
        System.out.println("Initial Array" + Arrays.deepToString(matrix));
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        //Store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
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
        for (int j = 0; j < matrix[0].length; j++) {
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

}
