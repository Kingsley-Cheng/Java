package sort;

public class Shell extends Sort {

    public static void main(String[] args) {
        var tool = new Shell();
        Integer[] a = {5, 4, 3, 2, 1};
        tool.sort(a);
        show(a);
    }

    @Override
    public void sort(Comparable[] a) {
        int h = 1;
        while (h < a.length / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
            h /= 3;
        }
    }
}
