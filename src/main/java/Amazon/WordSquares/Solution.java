package Amazon.WordSquares;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/word-squares/description
 */
public class Solution {
    void initPrefix(String[] words, Map<String, List<String>> hash) {
        for (String item : words) {
            //如果给定的key不存在（或者key对应的value为null），关联给定的key和给定的value，并返回null；如果存在，返回当前值（不会把value放进去）；
            hash.putIfAbsent("", new ArrayList<>());
            hash.get("").add(item);

            String prefix = "";
            for (char c : item.toCharArray()) {
                prefix += c;
                hash.putIfAbsent(prefix, new ArrayList<>());
                hash.get(prefix).add(item);
            }
        }
    }
    boolean checkPrefix(int l, String nextWord, int wordLen, Map<String, List<String>> hash, List<String> squares) {
        for (int j = l + 1; j < wordLen; j++) {
            String prefix = "";
            //k是竖着往下走
            for (int k = 0; k < l; k++) {
                prefix += squares.get(k).charAt(j);
            }
            prefix += nextWord.charAt(j);
            if (!hash.containsKey(prefix)) {
                return false;
            }
        }
        return true;
    }
    //squares用的是滚动的方式
    void dfs(int l, int wordLen, Map<String, List<String>> hash, List<String> squares, List<List<String>> ans) {
        if (l == wordLen) {//退出条件
            ans.add(new ArrayList<>(squares));
            return;
        }
        String prefix = "";
        for (int i = 0; i < l; i++) {
            prefix += squares.get(i).charAt(l);
        }
        //冗余1
        for (String item : hash.get(prefix)) {
            //冗余2
            if (!checkPrefix(l, item, wordLen, hash, squares)) {
                continue;
            }
            squares.add(item);
            dfs(l + 1, wordLen, hash, squares, ans);
            squares.remove(squares.size() - 1);
        }
    }
    public List<List<String>> wordSquares(String[] words) {
        // Write your code here
        List<List<String>> ans = new ArrayList<>();
        if (words.length == 0) {
            return ans;
        }
        Map<String, List<String>> hash = new HashMap<>();
        //预处理
        initPrefix(words, hash);
        List<String> squares = new ArrayList<>();
        dfs(0, words[0].length(), hash, squares, ans);
        return ans;
    }
}
