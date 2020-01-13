package Amazon.NumberOfIslands;
// 并查集九章模板
class UnionFind {
    private int[] father = null;
    private int count;
    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        father[x] =find(father[x]);
        return father[x];
    }
    public void connect(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            //将b设为a的老大
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
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        if (m == 0) return 0;
        UnionFind union_find = new UnionFind(n * m);
        int total = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j])
                    total++;
        union_find.set_count(total);
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j]) {
                    for(int k =0; k <4;k++){
                        int new_i = i+dir[k][0];
                        int new_y = j+dir[k][1];
                        if(new_i>=0&&new_i<n&&new_y>=0&&new_y<m&&grid[new_i][new_y]){
                            union_find.connect(i * m + j, new_i * m + new_y);
                        }
                    }
                }
        return union_find.query();
    }
}
