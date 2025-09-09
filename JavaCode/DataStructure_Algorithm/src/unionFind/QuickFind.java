package unionFind;

public class QuickFind extends UF {
    private final int length;

    QuickFind(int N) {
        super(N);
        length = N;
    }

    @Override
    public int find(int p) {
        return getId(p);
    }

    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        for (int i = 0; i < length; i++) {
            if (find(i) == pID) setId(i, qID);
        }
        minusCount();
    }
}
