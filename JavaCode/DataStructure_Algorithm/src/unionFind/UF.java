package unionFind;

public abstract class UF {
    private final int[] id; // 等价类索引
    private int count; // 等价类个数

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int getId(int p) {
        return id[p];
    }

    public void setId(int p, int val) {
        id[p] = val;
    }

    public int getCount() {
        return count;
    }

    public void minusCount() {
        count--;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public abstract int find(int p);

    public abstract void union(int p, int q);
}
