package linkedlist;

public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addMiddle(T value, T referenceValue) {
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

    public void print() {
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

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
}
