package Amazon.UnionFind;

// 并查集完整模板
public class uf {

    private int[] father;

    public uf(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    //寻找father
    public int find(int x){
        if(father[x]==x){
            return x;
        }
        father[x] = find(father[x]);//递归----路径压缩
        return father[x] ;
    }

    //合并
    public void union(int a , int b){
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b){
            father[root_a] = root_b;
        }
    }

    public boolean connected(int p ,int q){
        return find(p)==find(q);
    }

}
