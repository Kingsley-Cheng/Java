package unionFind;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;

public class UFTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./DataStructure_Algorithm/src/unionFind/largeUF.txt");
        String[] data = Files.readString(path).split("\n");
        long start = System.currentTimeMillis();
        int N = Integer.parseInt(data[0]);
//        var QF = new QuickFind(N);
//        var QU = new QuickUnion(N);
        var WQU = new WeightedQuickUnion(N);

        for (int i = 1; i < data.length - 1; i++) {
            int p = Integer.parseInt(data[i].split(" ")[0]);
            int q = Integer.parseInt(data[i].split(" ")[1]);

//            if (QF.connected(p, q)) continue;
//            QF.union(p, q);
//            if(QU.connected(p,q)) continue;
//            QU.union(p, q);
            if (WQU.connected(p, q)) continue;
            WQU.union(p, q);

            System.out.println(p + " " + q);
        }
        double time = (System.currentTimeMillis()-start)/1000.;
//        System.out.println(QF.getCount() + " components");
//        System.out.println(QU.getCount() + " components");
        System.out.println(WQU.getCount() + " components");

        System.out.println(time);
    }
}
