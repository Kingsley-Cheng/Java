package unionFind;

public class QuickUnion extends UF{
    public QuickUnion(int N){
        super(N);
    }

    @Override
    public int find(int p) {
        while (p!=getId(p)) p=getId(p);
        return p;
    }

    @Override
    public void union(int p, int q) {
        int qRoot = find(q);
        int pRoot = find(p);
        setId(qRoot,pRoot);
        minusCount();
    }
}
