/**
 * 插入排序
 * 将后续元素插入前面已排序元素的正确位置
 * <p>
 * 适用于部分有序的数组：
 * 1.数组中每个元素距离它的最终位置都不远
 * 2.一个有序的大数组接一个小数组
 * 3.数组中只有几个元素的位置不正确
 * O(N*N)
 */
package sort;

public class Insertion extends Sort {
    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
    }
}