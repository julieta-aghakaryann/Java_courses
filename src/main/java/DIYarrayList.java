import java.util.*;

public class DIYarrayList<T> implements List<T>, Iterable<T> {
    private int capacity;
    private T[] genericArray;
    private static final int THE_DEFAULT_SIZE = 10;

    public DIYarrayList() {
        this(THE_DEFAULT_SIZE);
    }

    public DIYarrayList(int size) {
        if (size <= 0) {
            throw new IndexOutOfBoundsException("no negative size for list");
        }
        genericArray = (T[]) new Object[size];

    }

    @Override
    public void add(int index, T element) {

    }

    private void increaseCapacity(int size) {
        genericArray = Arrays.copyOf(this.genericArray, capacity + size);
    }


    @Override
    public boolean add(T t) {
        if (capacity >= genericArray.length) {
            increaseCapacity(THE_DEFAULT_SIZE);
        }
        genericArray[capacity++] = t;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> t) {
        increaseCapacity(t.size());
        boolean isAddedAll = false;
        for (T element : t) {
            isAddedAll = this.add(element);
        }
        return isAddedAll;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > capacity) {
            throw new IndexOutOfBoundsException("You cannot get the element at index: " + index);
        }
        return genericArray[index];
    }


    @Override
    public Iterator<T> iterator() {
        return new DIYarrayIterator<>(genericArray, capacity);
    }

    @Override
    public ListIterator<T> listIterator() {
        return new DIYarrayIterator<>(genericArray, capacity);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }


    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return genericArray.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        return Arrays.asList(genericArray).contains(o);
    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(genericArray, size());
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(int index, T t) {
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, capacity));
        }
        genericArray[index] = t;
        return t;
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    private static final class DIYarrayIterator<T> implements ListIterator<T> {

        private final T[] array;
        private final int size;
        private int index;

        public DIYarrayIterator(T[] array, int size) {
            this.array = array;
            this.size = size;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            return array[index++];
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException();
        }

        @Override
        public T previous() {
            return array[index - 1];
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T t) {
            array[index - 1] = t;
        }

        @Override
        public void add(T t) {
            throw new UnsupportedOperationException();
        }
    }

}