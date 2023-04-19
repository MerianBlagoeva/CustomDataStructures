import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public static class Node<T> {
        public T value;
        public Node<T> next;
        public Node<T> prev;

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
            head.prev = newNode;
            newNode.next = head;
        } else {
            tail = newNode;
        }
        // 2. Head = new node
        head = newNode;
        // 3. size++
        size++;
    }

    public void addLast(T element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }

        Node<T> newNode = new Node<>(element);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
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
        if (size > 1) {
            head.prev = null;
        }
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return valueToRemove;
    }

    public T removeLast() {
        if (size < 2) {
            return removeFirst();
        }
        T lastElement = tail.value; //Get the value of the last node
        tail = tail.prev;
        tail.next = null;
        size--;
        return lastElement;
    }

    public T get(int index) {
        validateIndex(index);

        Node<T> currentNode;
        if (index > size / 2) {  //search from tail to head
            currentNode = tail;

            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        } else { //search from head to tail
            currentNode = head;

            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        }
        return currentNode.value;
    }

    public void forEach(Consumer<T> consumer) {
        Node<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public T[] toArray(Class<T> clazz) {
        List<T> result = new ArrayList<>();
        forEach(result::add);
        return result.toArray((T[]) Array.newInstance(clazz, result.size()));
    }
}

