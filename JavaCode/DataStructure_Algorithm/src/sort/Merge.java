/**
 * 归并排序
 * O(NlogN)
 */
package sort;

public class Merge extends Sort{
    private static Comparable[] aux;

    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i =lo;
        int j = mid+1;
        for (int k=lo; k<=hi; k++)
            aux[k] = a[k];
        for (int k =lo;k<=hi;k++){
            if (i>mid) a[k] = aux[j++];
            else if (j>hi) a[k] = aux[i++];
            else if (less(aux[j],aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        this.sort(a, 0, a.length-1);
    }

    public void sort(Comparable[]a, int lo, int hi){
        if(lo>=hi) return;
        int mid = (hi-lo)/2+lo;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        if(less(a[mid+1],a[mid]))
            merge(a, lo, mid, hi);
    }
}
