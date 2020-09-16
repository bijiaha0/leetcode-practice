package Amazon.NearestExit;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 您将获得一个使用这三个可能值初始化的 m×n 2D 网格。
 * -1 - 墙壁或障碍物。
 * 0 - 门。
 * INF - Infinity是一个空房间。我们使用值 2 ^ 31 - 1 = 2147483647 来表示INF，您可以假设到门的距离小于 2147483647。
 * 在代表每个空房间的网格中填入到距离最近门的距离。如果不可能到达门口，则应填入 INF。
 * <p>
 * <p>
 * 2D网络为：
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * 0  -1 INF INF
 * 答案为：
 * 3  -1   0   1
 * 2   2   1  -1
 * 1  -1   2  -1
 * 0  -1   3   4
 */
public class Solution {
    static final int INF = Integer.MAX_VALUE;
    int n, m;

    public void wallsAndGates(int[][] rooms) {
        n = rooms.length;
        if (n == 0) {
            return;
        }
        m = rooms[0].length;

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
                if (0 <= nx && nx < n && 0 <= ny && ny < m && rooms[nx][ny] == INF) {
                    qx.offer(nx);
                    qy.offer(ny);
                    rooms[nx][ny] = rooms[cx][cy] + 1;
                }
            }
        }
    }
}
