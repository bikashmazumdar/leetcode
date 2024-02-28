package leet.code.top150.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    Ref - https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageValueLevelWise {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
        steps:
            1. perform level order traversal
            2. sum the values at each leave
            3. store the average at each level.

     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode current;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum  = 0;

            for(int i = 0; i < size; i++) {
                current = queue.poll();
                sum += current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            if (sum == 0) {
                result.add(0.0);
            } else {
                result.add(sum/size);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        AverageValueLevelWise averageValueLevelWise = new AverageValueLevelWise();
        List<Double> result = averageValueLevelWise.averageOfLevels(root);
        System.out.println(result);
    }
}
