public class LinkedListDeque<T> implements Deque<T>{
    private Node sentFront;
    private Node sentBack;
    private int size;

    private class Node {
        private T item;
        private Node prev;
        private Node next;
    }

    public LinkedListDeque() {
        size = 0;

        sentFront = new Node();
        sentBack = new Node();

        sentFront.next = sentBack;
//        sentFront.prev = sentBack;

//        sentBack.next = sentFront;
        sentBack.prev = sentFront;
    }

    @Override
    /** Add an item of type T to the front of the deque. */
    public void addFirst(T item) {
        size++;

        Node newNode = new Node();
        newNode.item = item;

        newNode.next = sentFront.next;
        sentFront.next = newNode;
        newNode.prev = newNode.next.prev;
        newNode.next.prev = newNode;
    }

    @Override
    /** Add an item of type T to the back of the deque. */
    public void addLast(T item) {
        size++;

        Node newNode = new Node();
        newNode.item = item;

        newNode.next = sentBack;
        newNode.prev = sentBack.prev;
        sentBack.prev = newNode;
        newNode.prev.next = newNode;
    }

    @Override
    /** Return ture if deque is empty. */
    public boolean isEmpty() {
        if (sentFront.next == sentBack) {
            return true;
        }
        return false;
    }

    @Override
    /** Return the number of items in the deque. */
    public int size() {
        return size;
    }

    @Override
    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        Node t = sentFront.next;
        while (t != sentBack) {
            System.out.print(t.item + " ");
            t = t.next;
        }
        System.out.println();
    }

    @Override
    /** Removes and returns the item at the front of the deque.
     *  If no such item exists, returns null.
     */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        size--;

        T res = sentFront.next.item;
        sentFront.next = sentFront.next.next;
        sentFront.next.prev = sentFront;

        return res;
    }

    @Override
    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        size--;

        T res = sentBack.prev.item;
        sentBack.prev = sentBack.prev.prev;
        sentBack.prev.next = sentBack;

        return res;
    }

    @Override
    /** Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null.
     * Must not alter the deque
     */
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node t = sentFront.next;
        for (int i = 0; i < index; i++) {
            t = t.next;
        }
        return t.item;
    }

    /** Same as get, but uses recursion. */
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursion(index, sentFront.next);
    }

    private T getRecursion(int index, Node t) {
        if (index == 0) {
            return t.item;
        }
        return getRecursion(index - 1, t.next);
    }
}

