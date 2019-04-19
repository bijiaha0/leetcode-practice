package Amazon.ConnectingGraph;
/**
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/connecting-graph-iii/description
 */
public class ConnectingGraph3 {
    private int[] father = null;
    private int count;//统计当前连通块的个数
    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    public ConnectingGraph3(int n) {
        father = new int[n + 1];
        count = n;
        for (int i = 1; i <= n; ++i) {
            father[i] = i;
        }
    }
    public void connect(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            father[root_a] = root_b;
            count --;
        }
    }
    public int query() {
        return count;
    }
}
