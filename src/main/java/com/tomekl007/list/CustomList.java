package com.tomekl007.list;

public class CustomList<T> {
    private Node head = null;

    public void add(T elem) {
        if (head == null) {
            head = new Node(elem, null);
            return;
        }
        Node prev = head;
        for (Node v = head; v != null; v = v.next) {
            prev = v;
        }
        prev.next = new Node(elem, null);
    }


    //    O(N)
    public T get(int index) {
        int currentIndex = 0;
        for (Node v = head; v != null; v = v.next) {
            if (currentIndex == index) {
                return v.value;
            }
            currentIndex++;
        }
        return null;
    }

    public int size() {
        int size = 0;
        for (Node v = head; v != null; v = v.next) {
            size = +1;
        }
        return size;
    }

    public T peekFirst() {
        return head.value;
    }

    private class Node {
        private T value;
        private Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
