/**
 * 选择排序
 * 首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置
 * 再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置
 * <p>
 * 特点：1.运行时间和输入无关 2.数据移动最少
 * O(N*N)
 */

package sort;

public class Selection extends Sort {
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) min = j;
            }
            swap(a, i, min);
        }
    }
}