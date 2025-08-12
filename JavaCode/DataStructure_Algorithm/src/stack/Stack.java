/**
 * 下压堆栈，链表实现
 */
package stack;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    private Node first = null; // 栈顶
    private int N = 0; // 元素数量

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    void push(T aItem) {
        if (first == null) {
            first = new Node();
            first.item = aItem;
            first.next = null;
        } else {
            Node oldfirst = first;
            first = new Node();
            first.item = aItem;
            first.next = oldfirst;
        }
        N++;
    }

    public T pop() {
        if (first == null) return null;
        T temp = first.item;
        first = first.next;
        N--;
        return temp;
    }

    public String toString() {
        String name = getClass().getName() + "[";
        while (first != null) {
            name += first.item + ", ";
            first = first.next;
        }
        return name + "]";

    }

    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class Node {
        T item; // 元素
        Node next; // 结点指向
    }

    private class StackIterator implements Iterator<T> {
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
