public class LinkedList {
    private Node head;
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

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Can't remove from empty list!");
        }
        int valueToRemove = head.value;
        head = head.next;
        size--;
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
        Node currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
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
        size--;
        return valueToReturn;
    }
}
