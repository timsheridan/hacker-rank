package io.sheridan.hackerrank.cracking;

import java.util.LinkedHashSet;
import java.util.Set;

public final class CheckBST {

    private static class Node {
        private final int data;
        Node left;
        Node right;

        private Node(int data) {
            this.data = data;
        }
    }

    private static boolean isBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, new LinkedHashSet<>());
    }

    private static boolean isBST(Node node, int min, int max, Set<Integer> found) {
        if (node == null) {
            return true;
        }
        if (!found.add(node.data)) {
            return false;
        }
        if (node.data < min || node.data > max) {
            return false;
        }
        return isBST(node.left, min, node.data, found)
            && isBST(node.right, node.data, max, found);
    }

    public static void main(String[] args) throws Exception {
        Node five = new Node(5);
        five.left = new Node(1);

        Node two = new Node(2);
        two.left = new Node(1);
        two.right = new Node(3);

        Node six = new Node(6);
        six.left = five;
        six.right = new Node(7);

        Node four = new Node(4);
        four.left = two;
        four.right = six;

        System.out.println(isBST(four) ? "Yes" : "No");
    }
}

