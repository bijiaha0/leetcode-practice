package LeetCode.GroupAnagrams;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {return new ArrayList<List<String>>();}
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            map.getOrDefault(keyStr,new ArrayList<>()).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
