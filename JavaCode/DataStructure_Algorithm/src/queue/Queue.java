/**
 * 先进先出队列，链表实现
 */
package queue;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private Node first = null; // 记录头节点
    private Node last = null; // 记录尾节点
    private int N = 0; // 记录数组元素

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enQueue(T aItem) {
        if (last == null) {
            first = new Node();
            first.item = aItem;
            last = first;
        } else {
            Node oldLast = last;
            last = new Node();
            last.item = aItem;
            oldLast.next = last;
        }
        N++;
    }

    public T deQueue() {
        if (first == null) return null;
        T tmp = first.item;
        first = first.next;
        N--;
        return tmp;
    }

    public Iterator<T> iterator() {
        return new QueueIterator();
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

    private class QueueIterator implements Iterator<T> {
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
