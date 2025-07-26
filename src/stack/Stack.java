package stack;

import linkedlist.LinkedList;

public class Stack<T> {
    LinkedList<T> stack = new LinkedList<>();

    public void push(T value) {
        stack.addFirst(value);
    }

    public T pop() {
        return stack.removeFirst();
    }
}