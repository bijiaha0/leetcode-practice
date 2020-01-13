package LeetCode.WordSearch;
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (checkGrid(board, i, j, 0, visited, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkGrid(char[][] board, int i, int j, int position, boolean[][] visited, String word) {
        if (i < 0 || i > board.length || j < 0 || j > board[0].length) {
            return false;
        }
        if (position == word.length() - 1 && !visited[i][j]) {
            return board[i][j] == word.charAt(position);
        }
        if (board[i][j] == word.charAt(position) && !visited[i][j]) {
            visited[i][j] = true;
            boolean res = checkGrid(board, i - 1, j, position + 1, visited, word) ||
                    checkGrid(board, i + 1, j, position + 1, visited, word) ||
                    checkGrid(board, i, j - 1, position + 1, visited, word) ||
                    checkGrid(board, i, j + 1, position + 1, visited, word);
            visited[i][j] = false;
            return res;
        }
        return false;
    }
}
