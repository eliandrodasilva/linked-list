package linkedlist;

public class GenericLinkedList<T> {

    private Node<T> head;

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
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
    }

    public void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
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
