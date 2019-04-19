package Amazon.ConnectingGraph;
/**
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/connecting-graph-ii/description
 */
public class ConnectingGraph2 {
    private int[] father = null;
    private int[] size = null;//统计当前组里的人数
    //路径压缩
    private int find(int x) {
        if(father[x]==x){
            return x;
        }
        return father[x] = find(father[x]);
    }
    public ConnectingGraph2(int n) {
        father = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            father[i] = i;
            size[i] = 1;
        }
    }
    public void connect(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            father[root_a] = root_b;
            size[root_b] += size[root_a];
        }
    }
    public int query(int a) {
        int root_a = find(a);
        return size[root_a];
    }
}
