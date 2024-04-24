package coding.pattern.kwaymerge;

import java.util.*;

public class MergeKSortedLists {

    static class Node implements Comparable<Node>{
        Integer data;
        Node next;

        public Node(Integer data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public int compareTo(Node o) {
            return o.data.compareTo(this.data);
        }
    }

    public static Node merge(List<Node> lists) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(Node n : lists) {
            queue.offer(n);
        }

        Node head = null, current, traverse = null;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (head == null) {
                head = current;
                traverse = head;
            } else {
                traverse.next = current;
                traverse = traverse.next;
            }
            if (current.next != null) {
                queue.offer(current.next);
            }
        }
        return head;
    }


    public static Node kSmallestNode(List<Node> lists, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Collections.reverseOrder());
        TreeSet<Node> result = new TreeSet<>();
        for(Node n : lists) {
            queue.offer(n);
        }

        Node head = null, current, traverse = null;
        while (!queue.isEmpty() && result.size() < k) {
            current = queue.poll();
            if (head == null) {
                head = current;
                traverse = head;
            } else {
                traverse.next = current;
                traverse = traverse.next;
            }
            if (current.next != null) {
                queue.offer(current.next);
            }
            result.add(current);

        }
        result.forEach(node -> {
            System.out.print(node.data +" ");
        });
        return result.getFirst();
    }

    private static void print(Node head) {
        System.out.println("Merged list: ");
        while (head != null) {
            System.out.print(head.data +" ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(6);
        list.add(l1);

        Node l2 = new Node(1);
        l2.next = new Node(5);
        list.add(l2);

        Node l3 = new Node(1);
        l3.next = new Node(1);
        l3.next.next = new Node(3);
        l3.next.next.next = new Node(7);
        list.add(l3);

        Node l4 = new Node(8);
        list.add(l4);

        //Node head = merge(list);
        //print(head);

        Node node = kSmallestNode(list, 2);
        System.out.println("Node->" + node.data);

    }

}
