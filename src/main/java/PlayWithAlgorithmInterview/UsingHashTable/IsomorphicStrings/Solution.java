package PlayWithAlgorithmInterview.UsingHashTable.IsomorphicStrings;
/**
 Input : s = "egg", t = "add"
 Output : true
 Explanation :
 e -> a, g -> d.
 https://www.lintcode.com/problem/isomorphic-strings/solution
 数组实现优势，代码短，key可以方便的顺序访问
 劣势：只能在被hash的对象是数字或者字符时使用，
 且受内存大小限制：被hash数字取值范围不能太大，   1000万int约等于128M的内存。
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Write your code here
        int[] map = new int[256];  // ASCII 的范围是0-255
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (map[sc[i]] == 0) {
                map[sc[i]] = tc[i];
            } else {
                if (map[sc[i]] != tc[i]) {
                    return false;
                }
            }
        }
        int[] map2 = new int[256];
        for (int i = 0; i < t.length(); i++) {
            if (map2[tc[i]] == 0) {
                map2[tc[i]] = sc[i];
            } else {
                if (map2[tc[i]] != sc[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
