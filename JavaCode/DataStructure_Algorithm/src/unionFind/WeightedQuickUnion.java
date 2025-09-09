package unionFind;

public class WeightedQuickUnion extends UF{
    private int[] nodeSize;

    public WeightedQuickUnion(int N){
        super(N);
        nodeSize = new int[N];
        for (int i=0;i<N;i++)
            nodeSize[i] =1;
    }

    private int getNodeSize(int p) {
        return nodeSize[p];
    }

    private void plusNodeSize(int p, int val){
        nodeSize[p] += val;
    }

    @Override
    public int find(int p) {
        while (p!=getId(p)) p=getId(p);
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (getNodeSize(pRoot)<getNodeSize(qRoot)) {
            setId(pRoot,qRoot);
            plusNodeSize(qRoot, getNodeSize(pRoot));
        }
        else {
            setId(qRoot, pRoot);
            plusNodeSize(pRoot, getNodeSize(qRoot));
        }
        minusCount();
    }
}
