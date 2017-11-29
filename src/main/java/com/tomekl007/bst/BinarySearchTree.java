package com.tomekl007.bst;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {
    private Node root = null;

    public boolean find(int id) {
        Node current = root;
        while (current != null) {
            if (current.data == id) {
                return true;
            } else if (current.data > id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public void insert(int id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (id < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }


    public void iterate(Node root, List<Integer> results) {
        if (root != null) {
            iterate(root.left, results);
            results.add(root.data);
            iterate(root.right, results);
        }
    }

    public List<Integer> getInOrder() {
        LinkedList<Integer> result = new LinkedList<>();
        iterate(this.root, result);
        return result;
    }

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


}
