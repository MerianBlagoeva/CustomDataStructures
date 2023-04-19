import java.lang.reflect.Array;
import java.util.function.Consumer;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public static class Node<T> {
        public T value;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }

    public void addFirst(T element) {
        // 1. Create node
        Node<T> newNode = new Node<>(element);
        if (!isEmpty()) {
            newNode.next = head;
        }
        // 2. Head = new node
        head = newNode;
        // 3. size++
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Can't remove from empty list!");
        }
        T valueToRemove = head.value;
        head = head.next;
        size--;
        return valueToRemove;
    }

    public T get(int index) {
        validateIndex(index);
        int currentIndex = 0;
        Node<T> currentNode = head;

        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }

        return currentNode.value;
    }

    public void addLast(T element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }

        Node<T> newNode = new Node<>(element);
        Node<T> currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        size++;
    }

    public T removeLast() {
        if (size < 2) {
            return removeFirst();
        }

        Node<T> currentNode = head;

        //Loop while we get to the penultimate node
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        T valueToReturn = currentNode.next.value; //Get the value of the last node
        currentNode.next = null;
        size--;
        return valueToReturn;
    }

    public void forEach(Consumer<T> consumer) {
        Node<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(Class<T> clazz) {
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) Array.newInstance(clazz, size); // create array of type T
        int counter = 0;
        Node<T> currentNode = head;
        while (currentNode != null) {
            arr[counter] = currentNode.value;
            counter++;
            currentNode = currentNode.next;
        }
        return arr;
    }
}
