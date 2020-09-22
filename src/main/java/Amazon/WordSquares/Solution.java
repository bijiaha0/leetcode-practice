package Amazon.WordSquares;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给出一系列 不重复的单词，找出所有用这些单词能构成的 单词矩阵。
 * 一个有效的单词矩阵是指, 如果从第 k 行读出来的单词和第 k 列读出来的单词相同(0 <= k < max(numRows, numColumns))，那么就是一个单词矩阵.
 * 例如，单词序列为 ["ball","area","lead","lady"] ,构成一个单词矩阵。因为对于每一行和每一列，读出来的单词都是相同的。
 * <p>
 * 输入:
 * ["area","lead","wall","lady","ball"]
 * 输出:
 * [["wall","area","lead","lady"],["ball","area","lead","lady"]]
 * <p>
 * 解释:
 * 输出包含 两个单词矩阵，这两个矩阵的输出的顺序没有影响(只要求矩阵内部有序)。
 * <p>
 * https://www.jiuzhang.com/solutions/word-squares/
 */

public class Solution {

    void initPrefix(String[] words, Map<String, List<String>> hash) {

        for (String item : words) {
            hash.getOrDefault("", new ArrayList<>()).add(item);

            String prefix = "";
            for (char c : item.toCharArray()) {
                prefix += c;
                hash.getOrDefault(prefix, new ArrayList<>()).add(item);
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

        //退出条件
        if (l == wordLen) {
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
