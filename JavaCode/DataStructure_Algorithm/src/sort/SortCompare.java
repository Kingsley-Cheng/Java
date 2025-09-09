/**
 * 用于比较各个排序方法的平均排序时间
 */
package sort;

import java.util.Random;

public class SortCompare {
    public static Integer[] numberGenerate(int num, int min, int max) {
        Random generator = new Random();
        var results = new Integer[num];
        for (int i = 0; i < num; i++) {
            results[i] = generator.nextInt(max - min + 1) + min;
        }
        return results;
    }

    public static void timeRandomInput(Sort tool, int N, int T) {
        double total = 0.0;
        for (int i = 0; i < T; i++) {
            var test = numberGenerate(N, 0, N * 10);
            long start = System.currentTimeMillis();
            tool.sort(test);
            total += System.currentTimeMillis() - start;
        }
        total /= T * 1000;
        System.out.println(tool.getClass().getName() + ": " + total + " sec.");
    }


    public static void main(String[] args) {
        final int N = 10000;
        final int T = 10;
//        timeRandomInput(new Selection(), N, T);
//        timeRandomInput(new Insertion(), 100000, 5);
//        timeRandomInput(new Shell(), 1000000, 5);
        timeRandomInput(new Merge(),100000,5);
        timeRandomInput(new MergeBU(),10000,5);
    }
}
