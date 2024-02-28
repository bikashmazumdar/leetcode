package leet.code.top150.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
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

  private void rightSideView(TreeNode root, List<Integer> result, int level) {
        if (root == null) {
            return;
        }
        if(level == result.size()) {
            result.add(root.val);
        }
        rightSideView(root.right, result, level + 1);
        rightSideView(root.left, result, level + 1);
  }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView(root, result, 0);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        List<Integer> rightViewNodes = binaryTreeRightSideView.rightSideView(root);
        System.out.println(rightViewNodes);
    }
}
