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

}