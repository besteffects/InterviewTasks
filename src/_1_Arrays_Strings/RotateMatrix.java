package _1_Arrays_Strings;
/*
Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image
by 90 degrees. Can you do this in place?
 */
public class RotateMatrix {

    public static void main(String[] args) {
    }

    public static boolean rotate(int [][]matrix){
        if (matrix.length==0||matrix.length!=matrix[0].length) return false;
        int n=matrix.length;
        for (int layer=0;layer<n/2;layer++){
            int first=layer;
            int last=n-1-layer;
            for (int i = first; i < last; i++) {
                int offset=i-first;
                int top=matrix[first][i]; //save top

                //left->top
                matrix[first][i]=matrix[last-offset][first];

                //bottom -> left
                matrix[last-offset][first]=matrix[last][last-offset];

                //right -> bottom
                matrix[last][last-offset] =matrix[1][last];

                //top -> right
                matrix[1][last]=top; //right <-saved top
            }
        }
        return true;
    }
}
