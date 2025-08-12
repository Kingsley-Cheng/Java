/**
 * 下压（LIFO）栈，可自动扩容，数组实现
 */
package resizingArrayStack;

import java.util.Iterator;

public class ResizingArrayStack<T> implements Iterable<T> {
    private final int INIT_CAPACITY = 5; // 默认数组初始大小
    private T[] items; // 数组
    private int N; // 元素数量

    public ResizingArrayStack() {
        items = (T[]) new Object[INIT_CAPACITY];
        N = 0;
    }

    public ResizingArrayStack(int initCapacity) {
        items = (T[]) new Object[initCapacity];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void resize(int capacity) {
        if (N > capacity) return; // must be larger than current size
        T[] temp = (T[]) new Object[capacity];
        if (N >= 0) System.arraycopy(items, 0, temp, 0, N);
        items = temp;
    }

    // add element to the end
    public void push(T aItem) {
        if (N >= items.length) resize(2 * N);
        items[N++] = aItem;
    }

    // delete the end element
    public T pop() {
        if (N <= 0) return null;
        T temp = items[--N];
        items[N] = null;
        if (N > 0 && N <= items.length / 4)
            resize(items.length / 2);
        return temp;
    }

    public String toString() {
        String result = getClass().getName() + "[";

        for (int i = N - 1; i >= 0; i--) {
            result += items[i].toString() + ", ";
        }
        return result + "]";
    }

    public Iterator<T> iterator() {
        return new ResizingArrayStackIterator();
    }

    private class ResizingArrayStackIterator implements Iterator<T> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return items[--i];
        }

        @Override
        public void remove() {
        }
    }
}