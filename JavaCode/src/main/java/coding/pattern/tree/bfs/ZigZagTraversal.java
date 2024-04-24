package coding.pattern.tree.bfs;

import java.util.*;

public class ZigZagTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static List<List<Integer>> zigZag(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int level = 1;
        TreeNode current;

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0 ; i < size; i++) {

                if (level % 2 == 1) {
                    current = deque.pollFirst();
                    list.add(current.val);

                    if(current.right != null) {
                        deque.offerLast(current.right);
                    }
                    if(current.left != null) {
                        deque.offerLast(current.left);
                    }

                } else {
                    current = deque.pollLast();
                    list.add(current.val);

                    if(current.left != null) {
                        deque.offerFirst(current.left);
                    }

                    if(current.right != null) {
                        deque.offerFirst(current.right);
                    }
                }
            }
            result.add(list);
            level++;

        }
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode current;

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

    public static Map<Integer, Double> levelOrderAverage(TreeNode root) {
        Map<Integer, Double> result = new TreeMap<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode current;
        int level = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for(int i = 0; i < size; i++) {
                current = queue.poll();
                sum = sum + current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            double average = 0.0;
            if (sum != 0) {
                average = (double) sum / size;
            }
            result.put(level, average);
            level++;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        zigZag(root).stream().forEach(System.out::println);
        Map<Integer, Double> levelAverage = levelOrderAverage(root);
        levelAverage.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey() +" =>" + entry.getValue());
        });

    }
}
