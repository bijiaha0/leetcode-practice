package Amazon.KthSmallestElementInASortedMatrix;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * Email: clickgwas@gmail.com
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
class Pair{
    int x;
    int y;
    int val;
    Pair(int x, int y,int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
class PairComparator implements Comparator<Pair>{
    @Override
    public int compare(Pair o1, Pair o2) {
        return o1.val-o2.val;
    }
}
public class Solution {
    public int KthSmallestElementInASortedMatrix(int[][] matrix,int k){
        int[] xx = {0,1};
        int[] yy = {1,0};
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Pair> priority = new PriorityQueue<Pair>(k,new PairComparator());
        priority.add(new Pair(0 ,0, matrix[0][0]));
        for(int i =0; i < k-1; i++){
            Pair cur = priority.poll();//取出一个，加入两个。
            for(int j =0; j < 2; j++){//遍历右边和下边的两个元素。
                int next_x = cur.x + xx[j];
                int next_y = cur.y + yy[j];
                Pair nextPair = new Pair(cur.x+xx[j],cur.y+yy[j],0);
                if(next_x < n && next_y < m && !visited[next_x][next_y]){
                    visited[next_x][next_y] = true;
                    nextPair.val = matrix[next_x][next_y];
                    priority.add(nextPair);
                }
            }
        }
        return priority.poll().val;
    }
}
