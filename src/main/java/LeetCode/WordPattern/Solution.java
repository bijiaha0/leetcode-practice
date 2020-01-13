package LeetCode.WordPattern;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * https://www.cnblogs.com/grandyang/p/4857022.html
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0) {
            return false;
        }
        //space
        if (pattern.length() == 1 && str.length() == 1) {
            return true;
        }
        HashMap<Character, String> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();
        String[] arr = str.split(" ");
        for (int i = 0; i < pattern.length(); i++) {
            Character tmp = pattern.charAt(i);
            hashSet.add(arr[i]);
            if (!hashMap.containsKey(tmp)) {
                hashMap.put(tmp, arr[i]);
            } else if (!hashMap.get(tmp).equals(arr[i])) {
                return false;
            }
        }
        return hashMap.size() == hashSet.size();
    }
}
