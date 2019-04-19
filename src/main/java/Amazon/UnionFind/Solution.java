package Amazon.UnionFind;
/*
* 并查集代码模板
* */
public class Solution {
    private int[] father =null;
    //寻找father
    public int find(int x){
        if(father[x]==x){
            return x;
        }
        return father[x] = find(father[x]);
    }
    //合并
    public void union(int a , int b){
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b){
            father[root_a] = root_b;
        }
    }
}
