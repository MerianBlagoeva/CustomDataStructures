import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }

    public void addFirst(int number) {
        // 1. Create node
        Node newNode = new Node(number);
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

    public void addLast(int number) {
        if (isEmpty()) {
            addFirst(number);
            return;
        }

        Node newNode = new Node(number);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
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
        if (size > 1) {
            head.prev = null;
        }
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return valueToRemove;
    }

    public int removeLast() {
        if (size < 2) {
            return removeFirst();
        }
        int lastElement = tail.value; //Get the value of the last node
        tail = tail.prev;
        tail.next = null;
        size--;
        return lastElement;
    }

    public int get(int index) {
        validateIndex(index);

        Node currentNode;
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

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        List<Integer> result = new ArrayList<>();
        forEach(result::add);
        return result.stream().mapToInt(e -> e).toArray();
    }
}

