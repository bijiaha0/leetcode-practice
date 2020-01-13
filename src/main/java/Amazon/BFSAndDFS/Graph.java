package Amazon.BFSAndDFS;
import java.util.LinkedList;
import java.util.Queue;
public class Graph {
    int v;
    LinkedList<Integer>[] adj;
    Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    void addEdge(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }
    //BFS------>
    public void bfs(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[v];
        visited[s]=true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print1(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }
    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if (t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }
    private void print1(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if(t==s){
            return;
        }
        print(prev, s, prev[t]);
        System.out.print(t + " ");
    }
    //DFS------>
    boolean found = false; // 全局变量或者类成员变量
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }
    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(3,4);graph.addEdge(4,5);graph.addEdge(4,6);graph.addEdge(5,7);graph.addEdge(6,7);
        graph.bfs(0,7);
    }
}
