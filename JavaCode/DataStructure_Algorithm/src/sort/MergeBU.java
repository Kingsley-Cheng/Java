package sort;

public class MergeBU extends Sort{
    private static Comparable[] aux;

    public static void merge(Comparable a[], int lo, int mid, int hi){
        int i =lo, j = mid+1;
        for (int k=0; k<=hi; k++)
            aux[k] = a[k];
        for (int k =lo; k<=hi; k++){
            if (i>mid+1) a[k] = aux[j++];
            else if (j>hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        for (int sz=1; sz<a.length; sz*=2)
            for (int lo=0; lo<a.length-sz;lo+=2*sz)
                merge(a,lo,lo+sz-1,Math.min(lo+2*sz-1,a.length-1));
    }
}
