package Amazon.WordSearchII;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class TrieNode {
    String word;
    HashMap<Character, TrieNode> children;
    public TrieNode() {
        word = null;
        children = new HashMap<>();
    }
}
class TrieTree{
    TrieNode root;
    public TrieTree(TrieNode TrieNode) {
        root = TrieNode;
    }
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.children.containsKey(word.charAt(i))) {
                node.children.put(word.charAt(i), new TrieNode());
            }
            node = node.children.get(word.charAt(i));
        }
        node.word = word;
    }
}
public class Solution {
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};
    public void search(char[][] board, int x, int y, boolean[][] visited,TrieNode root, List<String> results) {
        if (!root.children.containsKey(board[x][y])) return;
        TrieNode child = root.children.get(board[x][y]);
        if (child.word != null) {
            if (!results.contains(child.word)) {
                results.add(child.word);
            }
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            if (!isValid(board, x + dx[i], y + dy[i],visited)) {
                continue;
            }
            search(board, x + dx[i], y + dy[i],visited, child, results);
        }
        visited[x][y] = false;
    }
    private boolean isValid(char[][] board, int x, int y,boolean[][] visited) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        return visited[x][y] == false;
    }
    public List<String> findWords(char[][] board, List<String> words) {
        List<String> results = new ArrayList<String>();
        TrieTree tree = new TrieTree(new TrieNode());
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (String word : words){
            tree.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                search(board, i, j, visited,tree.root, results);
            }
        }
        return results;
    }
}
