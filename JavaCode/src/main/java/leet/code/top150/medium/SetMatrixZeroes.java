package leet.code.top150.medium;

import java.util.HashSet;
import java.util.Set;

/*
    Ref - https://leetcode.com/problems/set-matrix-zeroes/

 */
public class SetMatrixZeroes {

    /*
        steps:
            1. store the row and col positions if 0 is found. Set is used to avoid duplicate
                entries for row & col.
            2. Iterate through the rows and columns and marked them 0.
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for(Integer row : rowSet) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }

        for(Integer col : colSet) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0 ;
            }
        }
    }

    /*
        we have used 1st row and column to hold the status instead of map
        - only problem we see in [0,0] so a variable is used to keep track of its status

        Steps:
            1. First we go through the matrix and mark row=0, col = j and row=i, column 0
               column as zero
            2. In the next loop we update the matrix except row[0] and column [0] based on the
               outcome of step 1.
            3. We update the row[0] if [0][i] index is set to 0
            4. Similarly, we update the col [i][0] if col0 = 0
     */
    public void setZeroesOptimized(int[][] matrix) {

        int col0 = 1;
        // matrix[0][j] -> row 0 -> columns matrix[i][0] -> col 0 -> rows
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j]  = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] != 0) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(col0 == 0) {

            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

}
