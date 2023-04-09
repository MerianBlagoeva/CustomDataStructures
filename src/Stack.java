import java.util.function.Consumer;

/**
 * Custom implementation of LIFO data structure
 */

public class Stack {
    private static class Node {
        private final int element;
        private Node previous;

        private Node(int element) {
            this.element = element;
        }
    }

    private Node top;
    private int size;

    public void push(int element) {
        Node newNode = new Node(element);
        newNode.previous = top;
        top = newNode;
        size++;
    }

    public int pop() {
        ensureNotEmpty();

        int toRemove = top.element;
        top = top.previous;
        size--;
        return toRemove;
    }

    private void ensureNotEmpty() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty!");
        }
    }

    public int peek() {
        ensureNotEmpty();
        return top.element;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node current = top;

        while (current != null) {
            consumer.accept(current.element);
            current = current.previous;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
