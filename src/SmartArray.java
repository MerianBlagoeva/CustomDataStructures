import java.util.function.Consumer;

/**
 * Custom implementation of ArrayList<> data structure
 */
public class SmartArray {
    private int[] data;
    private int size;


    public SmartArray() {
        this.size = 0;
        this.data = new int[4];
    }

    private int[] grow() {
        int newLength = data.length * 2;

        int[] newData = new int[newLength];
        System.arraycopy(data, 0, newData, 0, data.length);

        return newData;
    }

    private int[] shrink() {
        int newLength = data.length / 2;

        int[] newData = new int[newLength];
        System.arraycopy(data, 0, newData, 0, size);

        return newData;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }

    public void add(int element) {
        if (size == data.length) {
            data = grow();
        }
        data[size++] = element;
    }

    public int get(int index) {
        validateIndex(index);
        return data[index];
    }

    public int size() {
        return size;
    }

    public int remove(int index) {
        int removedElement = get(index);

        if (size - 1 - index >= 0) {
            System.arraycopy(data, index + 1, data, index, size - 1 - index);
        }

        data[size - 1] = 0;
        size--;

        if (size == data.length / 4) {
            data = shrink();
        }
        return removedElement;
    }


    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            int next = data[i];
            if (element == next) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element) {
        int lastElement = data[size - 1];

        for (int i = size - 1; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = element;
        add(lastElement);
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(data[i]);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

}