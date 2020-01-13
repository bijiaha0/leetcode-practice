package Amazon.WallsAndGates;
import java.util.LinkedList;
import java.util.Queue;
public class Solution {
    void wallsAndGates(int[][] rooms) {
        int r = rooms.length;
        int c = rooms[0].length;
        bfs(rooms,r,c);
    }
    void bfs(int[][] rooms,int r, int c){
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        Queue<Integer> queue_x = new LinkedList<>();
        Queue<Integer> queue_y = new LinkedList<>();
        for(int i = 0; i < r;i++){
            for(int j = 0; j < c;j++){
                if(rooms[i][j]==0){
                    queue_x.offer(i);
                    queue_y.offer(j);
                    rooms[i][j]=0;
                }
            }
        }
        while (!queue_x.isEmpty()){
            int xx = queue_x.poll();
            int yy = queue_y.poll();
            for(int ii=0;ii<4;ii++){
                int n_x = xx+dx[ii];
                int n_y = yy+dy[ii];
                if(n_x >= 0 && n_x < r && n_y >= 0 && n_y < c && rooms[n_x][n_y] == Integer.MAX_VALUE){
                    queue_x.offer(n_x);
                    queue_y.offer(n_y);
                    rooms[n_x][n_y] = rooms[xx][yy]+1;
                }
            }
        }
    }
}
