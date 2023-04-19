import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Custom implementation of ArrayList<> data structure
 */
public class SmartArray<T> implements Iterable<T> {

    private class SmartArrayIterator implements Iterator<T> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            return get(index++);
        }
    }

    private Object[] data;
    private int size;


    public SmartArray() {
        this.size = 0;
        this.data = new Object[4];
    }

    private Object[] grow() {
        int newLength = data.length * 2;

        Object[] newData = new Object[newLength];
        System.arraycopy(data, 0, newData, 0, data.length);

        return newData;
    }

    private Object[] shrink() {
        int newLength = data.length / 2;

        Object[] newData = new Object[newLength];
        System.arraycopy(data, 0, newData, 0, size);

        return newData;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }

    public void add(T element) {
        if (size == data.length) {
            data = grow();
        }
        data[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        validateIndex(index);
        return (T) data[index];
    }

    public int size() {
        return size;
    }

    public T remove(int index) {
        T removedElement = get(index);

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


    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            T next = get(i);
            if (element.equals(next)) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, T element) {
        T lastElement = get(size - 1);

        for (int i = size - 1; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = element;
        add(lastElement);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new SmartArrayIterator();
    }

}