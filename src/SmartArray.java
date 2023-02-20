public class SmartArray {
    private int[] data;
    private int size;


    public SmartArray() {
        this.size = 0;
        this.data = new int[16];
    }

    public void add(int element) {
        if (size == data.length) {
            data = grow();
        }
        data[size++] = element;
    }

    private int[] grow() {
        int newLength = data.length * 2;

        int[] newData = new int[newLength];
        System.arraycopy(data, 0, newData, 0, data.length);

        return newData;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        return data[index];
    }
    public int size() {
        return size;
    }


    public int remove(int index) {
        return 2;
    }

}