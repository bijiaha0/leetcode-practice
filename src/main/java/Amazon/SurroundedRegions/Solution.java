package Amazon.SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给一个二维的矩阵，包含 'X' 和 'O', 找到所有被 'X' 围绕的区域，并用 'X' 替换其中所有的 'O'。
 * <p>
 * https://www.jiuzhang.com/solutions/surrounded-regions/
 * <p>
 * 输入:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 输出:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * --------------
 * 输入:
 * X X X X
 * X O O X
 * X O O X
 * X O X X
 * 输出:
 * X X X X
 * X O O X
 * X O O X
 * X O X X
 */
public class Solution {

    public void surroundedRegions(char[][] board) {

        int n = board.length;

        if (n == 0) {
            return;
        }

        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            bfs(board, i, 0);
            bfs(board, i, m - 1);
        }

        for (int j = 0; j < m; j++) {
            bfs(board, 0, j);
            bfs(board, n - 1, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'W') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    void bfs(char[][] board, int sx, int sy) {

        if (board[sx][sy] != 'O') {
            return;
        }

        int n = board.length;
        int m = board[0].length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(sx);
        qy.offer(sy);

        board[sx][sy] = 'W'; // 'W' -> Water
        while (!qx.isEmpty()) {
            int cx = qx.poll();
            int cy = qy.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && board[nx][ny] == 'O') {
                    board[nx][ny] = 'W'; // 'W' -> Water
                    qx.offer(nx);
                    qy.offer(ny);
                }
            }
        }

    }
}