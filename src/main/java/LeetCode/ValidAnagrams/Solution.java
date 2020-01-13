package LeetCode.ValidAnagrams;
public class Solution {
    public boolean isAnagrams(String s, String t){
        if(s==null||t==null){
            return false;
        }
        if(s.length()!=t.length()){
            return false;
        }
        int[] map = new int[128];
        for(int i=0; i < s.length();i++){
            map[s.charAt(i)]++;
            map[t.charAt(i)]--;
        }
        for(int tmp:map){
            if(tmp!=0){
                return false;
            }
        }
        return true;
    }
}
