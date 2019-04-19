package Amazon.MinimumSpanningTree;
import java.util.*;
/**
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/minimum-spanning-tree/solution
 */
class Connection {
    public String city1, city2;
    public int cost;
    public Connection(String city1, String city2, int cost) {
        this.city1 = city1;
        this.city2 = city2;
        this.cost = cost;
    }
}
public class Solution {
    int n = 0;
    public List<Connection> lowestCost(List<Connection> connections) {
        List<Connection> ans = new ArrayList<>();
        UFS ufs = new UFS(connections.size() * 2);
        //排序
        Collections.sort(connections, new Comparator<Connection>() {
            public int compare(Connection a, Connection b) {
                if (a.cost != b.cost) {
                    return a.cost - b.cost;
                }
                if (a.city1.equals(b.city1)) {
                    return a.city2.compareTo(b.city2);
                }
                return a.city1.compareTo(b.city1);
            }
        });
        for (Connection item : connections) {
            int c1 = getID(item.city1);
            int c2 = getID(item.city2);
            if (ufs.find(c1) != ufs.find(c2)) {//没有成环
                ans.add(item);
                ufs.union(c1, c2);//合并
            }
        }
        if (ans.size() == n - 1) {//n个点，返回n-1个边
            return ans;
        } else {
            return new ArrayList<>();
        }
    }
    Map<String, Integer> name2ID = new HashMap<>();
    public int getID(String name) {
        if (name2ID.containsKey(name)) {
            return name2ID.get(name);
        } else {
            name2ID.put(name, n++);
            return n - 1;//索引
        }
    }
    //并查集
    public class UFS {
        int[] f;          // father
        public UFS(int n) {
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = -1;//初始化
            }
        }
        //查找
        public int find(int x) {
            if (f[x] < 0) {
                return x;
            }
            f[x] = find(f[x]);
            return f[x];
        }
        //合并
        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (f[a] < f[b]) {//合并到a上
                f[a] += f[b];
                f[b] = a;
            } else {//合并到b上
                f[b] += f[a];
                f[a] = b;
            }
        }
    }
}
