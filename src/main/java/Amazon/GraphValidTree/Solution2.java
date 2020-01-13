package Amazon.GraphValidTree;
import java.util.HashMap;
public class Solution2 {
    //并查集
    public class Solution {
        class UnionFind {
            HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
            UnionFind(int n) {
                for (int i = 0; i < n; i++) {
                    father.put(i, i);
                }
            }
            // 压缩
            int compressed_find(int x) {
                int parent = father.get(x);
                while (parent != father.get(parent)) {
                    father.put(parent,father.get(father.get(parent)));
                    parent = father.get(parent);
                }
                return parent;
            }
            //合并
            void union(int x, int y) {
                int fa_x = compressed_find(x);
                int fa_y = compressed_find(y);
                if (fa_x != fa_y)
                    father.put(fa_x, fa_y);
            }
        }
        public boolean validTree(int n, int[][] edges) {
            // tree should have n nodes with n-1 edges
            if (n - 1 != edges.length) {
                return false;
            }

            UnionFind uf = new UnionFind(n);

            for (int i = 0; i < edges.length; i++) {
                //说明有环存在
                if (uf.compressed_find(edges[i][0]) == uf.compressed_find(edges[i][1])) {
                    return false;
                }
                uf.union(edges[i][0], edges[i][1]);//合并
            }
            return true;
        }
    }
}
