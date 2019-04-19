package Amazon.WallsAndGates;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Author: bijiaha0
 * Date: 2019-02-23
 * Time: 3:32 PM
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/walls-and-gates/solution
 *
 * 0是注水点
 * -1是平原
 * inf是盆地
 */
public class Solution {
    public void wallsAndGates(int[][] rooms) {
        // Write your code here
        int n = rooms.length;
        if (n == 0) {
            return;
        }
        int m = rooms[0].length;

        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    qx.offer(i);
                    qy.offer(j);
                }
            }
        }

        while (!qx.isEmpty()) {
            int cx = qx.poll();
            int cy = qy.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m
                        && rooms[nx][ny] == Integer.MAX_VALUE) {
                    qx.offer(nx);
                    qy.offer(ny);
                    rooms[nx][ny] = rooms[cx][cy] + 1;
                }
            }
        }
    }
}
