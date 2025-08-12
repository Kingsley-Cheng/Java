/**
 * 背包，只进不出，链表实现
 */
package bag;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
    private Node first = null;
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(T aItem) {
        if (first == null) {
            first = new Node();
            first.item = aItem;
        } else {
            Node oldfirst = first;
            first = new Node();
            first.item = aItem;
            first.next = oldfirst;
        }
        N++;
    }

    public Iterator<T> iterator() {
        return new BagIterator();
    }

    public String toString() {
        Node current = first;
        String name = getClass().getName() + "[";
        while (current != null) {
            name += current.item + ", ";
            current = current.next;
        }
        return name + "]";
    }

    private class Node {
        T item;
        Node next;
    }

    private class BagIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T tmp = current.item;
            current = current.next;
            return tmp;
        }

        @Override
        public void remove() {
        }
    }
}
