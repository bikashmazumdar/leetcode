package leet.code.top150.easy;

import java.util.ArrayList;
import java.util.List;

/*
    Ref - https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinAbsDifference {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }

    private void inOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }

    /*
        I performed an in order traversal, which gives me a sorted list
        in sorted list I am comparing the difference between adjacent values with
        current min.

        Steps:
            1. Get the sorted values by doing in order traversal
            2. Get the difference between two adjacent values
            3. Take the min of current and adjacent difference.
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        inOrder(root, result);

        for (int i = 1; i < result.size(); i++) {
            min = Math.min(min, result.get(i) - result.get(i-1));
        }
        return min;
    }

    /*
        Storage optimized approach
     */
    Integer prev = null;
    int min = Integer.MAX_VALUE;

    private void minDiffHelper(TreeNode node) {
        if(node == null) return;
        minDiffHelper(node.left);
        if (prev != null) {
            min = Math.min(min, Math.abs(prev - node.val));
        }
        prev = node.val;
        minDiffHelper(node.right);
    }
    public int minDiff(TreeNode node) {
        minDiffHelper(node);
        return min;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        MinAbsDifference minAbsDifference = new MinAbsDifference();
        System.out.println(minAbsDifference.getMinimumDifference(root));
        System.out.println(minAbsDifference.minDiff(root));
    }
}
