package Amazon.CourseScheduleII;
import java.util.*;
/**
 * Email: clickgwas@gmail.com
 * https://www.jiuzhang.com/solution/course-schedule-ii/
 */
class DirecedGraphNode{
    int label;
    ArrayList<DirecedGraphNode> neighbors;
    DirecedGraphNode(int label){
        this.label = label;
        neighbors = new ArrayList<>();
    }

}
public class Solution1 {
    public static List<DirecedGraphNode> topSort(List<DirecedGraphNode> graph){
        //最终返回的结果
        List<DirecedGraphNode> res = new ArrayList<>();
        HashMap<DirecedGraphNode,Integer> map= new HashMap<>();
        //将所有的邻居节点放入map中
        for(DirecedGraphNode node : graph){
            for(DirecedGraphNode neigh : node.neighbors){
                if(!map.containsKey(neigh)){
                    map.put(neigh,1);
                }else {
                    map.put(neigh,map.get(neigh)+1);
                }
            }
        }
        //队列
        Queue<DirecedGraphNode> que = new LinkedList<>();
        //处理没有邻居的节点
        for(DirecedGraphNode node : graph){
            if(!map.containsKey(node)){
                que.offer(node);
                res.add(node);
            }
        }
        while (!que.isEmpty()){
            DirecedGraphNode poll = que.poll();
            for (DirecedGraphNode neigh:poll.neighbors){
                map.put(neigh,map.get(neigh)-1);
                if(map.get(neigh)==0){
                    res.add(neigh);
                    que.offer(neigh);
                }
            }
        }
        return res;
    }
    public static List<DirecedGraphNode> relation(int k,int[][] prerequisites){
        List<DirecedGraphNode> nodes = new ArrayList<>();
        for(int i = 0; i < k; i++){
            nodes.add(new DirecedGraphNode(i));
        }
        for(int j =0; j < prerequisites.length; j++){
            DirecedGraphNode temp1 = nodes.get(prerequisites[j][1]);
            temp1.neighbors.add(nodes.get(prerequisites[j][0]));
        }
        return nodes;
    }

    public static void main(String[] args) {
        int[][] prerequisites =  {{1,2},{2,0},{3,1},{3,2}};
        relation(4,prerequisites);
        for(DirecedGraphNode node:topSort(relation(4,prerequisites))){
            System.out.println(node.label);
        }
    }
}
