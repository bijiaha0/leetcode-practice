package Amazon.NumberOfIslands;
/**
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/number-of-islands/description
 * 并查集九章模板
 */
class UnionFind {
    private int[] father = null;
    private int count;

    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }

    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; ++i) {
            father[i] = i;
        }
    }

    public void connect(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            father[root_a] = root_b;
            count--;
        }
    }

    public int query() {
        return count;
    }

    public void set_count(int total) {
        count = total;
    }
}

public class Solution1 {
    public int numIslands(boolean[][] grid) {
        int count = 0;
        int n = grid.length;
        if (n == 0)
            return 0;
        int m = grid[0].length;
        if (m == 0)
            return 0;
        UnionFind union_find = new UnionFind(n * m);

        //初始化岛屿的个数
        int total = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j])
                    total++;

        union_find.set_count(total);
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j]) {
                    if (i > 0 && grid[i - 1][j]) {
                        union_find.connect(i * m + j, (i - 1) * m + j);
                    }
                    if (i + 1 < n && grid[i + 1][j]) {
                        union_find.connect(i * m + j, (i + 1) * m + j);
                    }
                    if (j > 0 && grid[i][j - 1]) {
                        union_find.connect(i * m + j, i * m + j - 1);
                    }
                    if (j + 1 < m && grid[i][j + 1]) {
                        union_find.connect(i * m + j, i * m + j + 1);
                    }
                }
        return union_find.query();
    }
}
