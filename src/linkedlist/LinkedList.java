package linkedlist;

import java.util.NoSuchElementException;

public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addBefore(T value, T referenceValue) {
        if (head == null) {
            addFirst(value);
            return;
        }

        Node<T> temp = head;
        while (temp.next != null && !temp.next.value.equals(referenceValue)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            Node<T> newNode = new Node<>(value);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        } else {
            System.out.println("Reference value not found in the list.");
        }
    }

    public void addLast(T value) {
        if (head == null) {
            addFirst(value);
            return;
        }

        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node<>(value);
        size++;
    }
    public void remove(T value) {
        ensureNotEmpty();

        if (head.value.equals(value)) {
            head = head.next;
            size--;
            return;
        }
        Node<T> temp = head;

        while (temp.next != null) {
            if(temp.next.value.equals(value)) {
                temp.next = temp.next.next;
                size--;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Value not found in the list.");
    }

    public void removeFirst() {
        ensureNotEmpty();
        head = head.next;
        size--;
    }

    public void removeLast() {
        ensureNotEmpty();

        if (head.next == null) {
            head = null;
            size--;
        } else {
            Node<T> temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            size--;
        }
    }

    public void display() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index);
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    public int size() {
        return size;
    }

    private void ensureNotEmpty() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
}
