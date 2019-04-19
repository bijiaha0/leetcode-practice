package Amazon.IsomorphicStrings;

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        for(int i =0; i < s.length();i++){
            if(map1[ss[i]] == 0){
                map1[ss[i]] = tt[i];
            }else{
                if(map1[ss[i]] != tt[i]){
                    return false;
                }
            }
        }
        for(int i =0; i < t.length();i++){
            if(map2[tt[i]] == 0){
                map2[tt[i]] = ss[i];
            }else{
                if(map2[tt[i]] != ss[i]){
                    return false;
                }
            }
        }
        return true;
    }
}
