package leet.code.top150.medium;

/*
    Ref - https://leetcode.com/problems/rotate-image/

    Steps:
        1. Transpose the matrix
        2. Reverse each row of the matrix
            |1|2|3|     |1|4|7|     |7|4|1|
            |4|5|6| =>  |2|5|8| =>  |8|5|2|
            |7|8|9|     |3|6|9|     |9|6|3|
 */
public class RotateImage {

    public void rotate(int[][] matrix) {

        for(int i = 0; i < matrix.length; i++ ) {
            for(int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < matrix.length; i++ ) {
            for(int j = 0, k = matrix[0].length - 1; j < k; j++, k--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
    }
}
