import java.util.function.Consumer;

public class LinkedListTail {
    private Node head;
    private Node tail;
    private int size;
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
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

    public void addFirst(int number) {
        // 1. Create node
        Node newNode = new Node(number);
        if (!isEmpty()) {
            newNode.next = head;
        } else {
            tail = newNode;
        }
        // 2. Head = new node
        head = newNode;
        // 3. size++
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Can't remove from empty list!");
        }
        int valueToRemove = head.value;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return valueToRemove;
    }

    public int get(int index) {
        validateIndex(index);
        int currentIndex = 0;
        Node currentNode = head;

        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }

        return currentNode.value;
    }

    public void addLast(int number) {
        if (isEmpty()) {
            addFirst(number);
            return;
        }

        Node newNode = new Node(number);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public int removeLast() {
        if (size < 2) {
            return removeFirst();
        }

        Node currentNode = head;

        //Loop while we get to the penultimate node
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        int valueToReturn = currentNode.next.value; //Get the value of the last node
        currentNode.next = null;
        tail = currentNode;
        size--;
        return valueToReturn;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        int[] arr = new int[size];
        int counter = 0;
        Node currentNode = head;
        while (currentNode != null) {
            arr[counter] = currentNode.value;
            counter++;
            currentNode = currentNode.next;
        }
        return arr;
    }
}

