package Amazon.UniqueWordAbbreviation;
import java.util.HashMap;
import java.util.Map;
/**
 * https://www.lintcode.com/problem/unique-word-abbreviation/solution
 *
 * 缩写的规则为：
 *
 * 对于长度小于等于2的字符串，其缩写等于其本身；
 * 对于长度大于2的字符串，其缩写等于其 首字母 + 单词长度减2.tostring() + 尾字母 。
 */
public class ValidWordAbbr {
    Map<String, Integer> dict = new HashMap<>();
    Map<String, Integer> abbr = new HashMap<>();
    // @param dictionary a list of word
    public ValidWordAbbr(String[] dictionary) {
        // Write your code here
        for (String d : dictionary) {
            dict.put(d, dict.getOrDefault(d, 0) + 1);
            String a = getAbbr(d);
            abbr.put(a, abbr.getOrDefault(a, 0) + 1);
        }
    }
    public boolean isUnique(String word) {
        // Write your code here
        String a = getAbbr(word);
        return dict.get(word) == abbr.get(a);
    }
    //掐头去尾找中间
    String getAbbr(String str) {
        if (str.length() <= 2) {
            return str;
        }
        return "" + str.charAt(0) + (str.length() - 2) + str.charAt(str.length() - 1);
    }
}
