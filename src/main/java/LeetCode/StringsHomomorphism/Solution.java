package LeetCode.StringsHomomorphism;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 0) {
                map[s.charAt(i)] = t.charAt(i);
            } else {
                if(map[s.charAt(i)]!=t.charAt(i)){
                    return false;
                }
            }
        }


        int[] map1 = new int[256];
        for (int i = 0; i < t.length(); i++) {
            if (map1[t.charAt(i)] == 0) {
                map1[t.charAt(i)] = s.charAt(i);
            } else {
                if(map1[t.charAt(i)]!=s.charAt(i)){
                    return false;
                }
            }
        }

        return true;


    }
}
