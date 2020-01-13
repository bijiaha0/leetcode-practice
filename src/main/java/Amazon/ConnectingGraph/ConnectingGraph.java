package Amazon.ConnectingGraph;
public class ConnectingGraph {
    private int[] father = null;
    public ConnectingGraph(int n) {
        father = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            father[i] = i;
        }
    }
    // 带路径压缩
    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }
    // 合并
    public void connect(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            father[root_a] = root_b;
        }
    }
    // 查询
    public boolean query(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        return root_a == root_b;
    }
}
