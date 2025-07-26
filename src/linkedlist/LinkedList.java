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

        Node<T> current = head;
        while (current.next != null && !current.next.value.equals(referenceValue)) {
            current = current.next;
        }

        if (current.next != null) {
            Node<T> newNode = new Node<>(value);
            newNode.next = current.next;
            current.next = newNode;
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

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(value);
        size++;
    }
    public void remove(T value) {
        ensureNotEmpty();

        if (head.value.equals(value)) {
            head = head.next;
            size--;
            return;
        }
        Node<T> current = head;

        while (current.next != null) {
            if(current.next.value.equals(value)) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
        System.out.println("Value not found in the list.");
    }

    public T removeFirst() {
        ensureNotEmpty();
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public T removeLast() {
        ensureNotEmpty();

        if (head.next == null) {
            T value = head.value;
            head = null;
            size--;
            return value;
        } else {
            Node<T> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            T value = current.next.value;
            current.next = null;
            size--;
            return value;
        }
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public int size() {
        return size;
    }

    public boolean contains(T value) {
        ensureNotEmpty();
        Node<T> current = head;
        for(int i = 0; i < size; i++) {
            System.out.println(current.value + " --> " + value);
            if(current.value == value) {
                return true;
            }
            else current = current.next;
        }
        return false;
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
