package Amazon.CourseScheduleII;
import java.util.*;
/**
 * https://www.lintcode.com/problem/course-schedule-ii/solution
 */
/*
* 有向图的拓扑排序
1.建立入度表
2.建立边表
* */
/*
Input: n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
* */
/*
 * 顶点的入度表示有多少条边指向这个顶点；
 * 顶点的出度表示有多少条边是以这个顶点为起点指向其他顶点的
 * [0,1]    <------  要想修0，得先修1。
 * */
public class Solution {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List[] edges = new ArrayList[numCourses];//邻接表
        int[] degree = new int[numCourses];//入度
        for (int i = 0; i < numCourses; i++)
            edges[i] = new ArrayList<Integer>();
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;//入度
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue queue = new LinkedList();
        //寻找入度为0的点
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int course = (int) queue.poll();
            order[count] = course;
            count++;
            int n = edges[course].size();
            for (int i = n - 1; i >= 0; i--) {
                int pointer = (int) edges[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.offer(pointer);
                }
            }
        }
        if (count == numCourses)
            return order;
        return new int[0];
    }

    //拓扑排序    adjacencyList为邻接矩阵
    public static List<Integer> topologicalSort(int n, int[][] adjacencyList) {
        List<Integer> topoRes = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int[] parent : adjacencyList) {
            for (int child : parent) {
                inDegree[child]++;
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        // start from nodes whose indegree are 0
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                deque.offer(i);
        }
        while (!deque.isEmpty()) {
            int curr = deque.poll();
            topoRes.add(curr);
            for (int child : adjacencyList[curr]) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    deque.offer(child);
                }
            }
        }
        return topoRes.size() == n ? topoRes : new ArrayList<>();
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 2}, {2, 0}, {3, 1}, {3, 2}};
        for (int v : findOrder(4, prerequisites)) {
            System.out.println(v);
        }
    }
}
