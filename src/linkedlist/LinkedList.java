package linkedlist;

public class LinkedList {
    private Node head;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(6);
        list.addFirst(3);
        list.addLast(9);
        list.addFirst(0);
        list.addMiddle(10, 9);

        list.print();
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);

        if(head != null) {
            newNode.next = head;
        }
        head = newNode;
    }

    public void addMiddle(int value, int referenceValue) {
        if (head != null) {
            Node temp = head;
            while (temp.next != null && temp.next.value != referenceValue) {
                temp = temp.next;
            }
            if (temp.next != null) {
                Node newNode = new Node(value);
                newNode.next = temp.next;
                temp.next = newNode;
            } else {
                System.out.println("Reference value not found in the list.");
            }
        } else {
            addFirst(value);
        }
    }

    public void addLast(int value) {
        if (head != null) {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(value);
        } else {
            addFirst(value);
        }
    }

    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value +" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
