package leet.code.top150.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    Ref - https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

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
            1. add all nodes in the queue. starting with root.
            2. loop through all nodes in each level
            3. add the traversed nodes in the list

     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current;
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                current = queue.poll();
                list.add(current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal trav = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = trav.levelOrder(root);
        System.out.println(result);
    }
}
