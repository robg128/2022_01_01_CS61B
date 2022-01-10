public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private final int INIT_CAPACITY = 8;

    public ArrayDeque() {
        items = (T[]) new Object[INIT_CAPACITY];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (nextFirst > nextLast) {
            System.arraycopy(items, nextFirst + 1, a, 0, items.length - 1 - nextFirst);
            System.arraycopy(items, 0, a, items.length - 1 - nextFirst, nextLast);
        } else {
            System.arraycopy(items, nextFirst + 1, a, 0, items.length - 2);
        }
        items = a;

        nextFirst = items.length - 1;
        nextLast = size;
    }

    private void resizeDown() {
        resize(items.length / 2);
    }

    public void addFirst(T item) {
//        if (nextFirst == (nextLast + 1) % size) {
        if (size == items.length - 2) {
            resize(items.length * 2);
        }
        size++;
        items[nextFirst] = item;
        nextFirst--;
        if (nextFirst == -1) {
            nextFirst = items.length - 1;
        }
    }

    public void addLast(T item) {
        if (size == items.length - 2) {
            resize(items.length * 2);
        }
        size++;
        items[nextLast] = item;
        nextLast++;
        if (nextLast == items.length) {
            nextLast = 0;
        }
    }

    public boolean isEmpty() {
        if ((nextFirst + 1) % items.length == nextLast) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = (nextFirst + 1) % items.length; i % items.length != nextLast; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        size--;
        T res = items[(nextFirst + 1) % items.length];
        items[(nextFirst + 1) % items.length] = null;
        nextFirst = (nextFirst + 1) % items.length;

        if (size < (items.length) * 0.25 && items.length > 8) {
            resizeDown();
        }

        return res;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        size--;
        int lastIndex = nextLast - 1;
        if (lastIndex == -1) {
            lastIndex = items.length - 1;
        }
        T res = items[lastIndex];
        items[lastIndex] = null;
        nextLast = lastIndex;

        if (size < (items.length) * 0.25 && items.length > 8) {
            resizeDown();
        }

        return res;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int i = (nextFirst + 1) % items.length;
        for ( ; index != 0; index--) {
            i = (i + 1) % items.length;
        }
        return items[i];
    }
}










