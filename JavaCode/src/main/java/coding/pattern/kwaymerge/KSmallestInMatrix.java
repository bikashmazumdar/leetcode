package coding.pattern.kwaymerge;

import java.util.*;

public class KSmallestInMatrix {

    public static int smallest(int [][] matrix, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int  i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                treeSet.add(matrix[i][j]);
                if (treeSet.size() > k) {
                    treeSet.removeLast();
                }
            }
        }
        return treeSet.getLast();
    }

    public static void main(String[] args) {
        int [][] matrix = {
                {1,3,5,9},
                {4,5,6,7},
                {6,8,9,10},
                {8,10,12,16}
        };
        Set<Integer> list = new TreeSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                list.add(matrix[i][j]);
            }
        }
        list.stream().sorted();

        System.out.println(smallest(matrix, 8));
        System.out.println(list);

    }
}
