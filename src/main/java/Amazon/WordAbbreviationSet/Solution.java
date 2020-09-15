package Amazon.WordAbbreviationSet;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.jiuzhang.com/solutions/word-abbreviation-set/
 * 假设你有一个字典和给你一个单词，判断这个单词的缩写在字典中是否是唯一的。
 * 当字典中的其他单词的缩写均与它不同的时候， 这个单词的缩写是唯一的.
 */
public class Solution {
    Map<String, Integer> dict = new HashMap<>();
    Map<String, Integer> abbr = new HashMap<>();

    public void ValidWordAbbr(String[] dictionary) {
        for (String d : dictionary) {
            dict.put(d, dict.getOrDefault(d, 0) + 1);
            String a = getAbbr(d);
            abbr.put(a, abbr.getOrDefault(a, 0) + 1);
        }
    }

    public boolean isUnique(String word) {
        String a = getAbbr(word);
        return dict.get(word) == abbr.get(a);
    }

    String getAbbr(String str) {
        if (str.length() <= 2) {
            return str;
        }
        return "" + str.charAt(0) + (str.length() - 2) + str.charAt(str.length() - 1);
    }
}
