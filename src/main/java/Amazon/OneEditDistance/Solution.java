package Amazon.OneEditDistance;
/*
* https://www.lintcode.com/problem/one-edit-distance/description
* */
public class Solution {
    public boolean isOneEditDistance(String s, String t){
        if(s.length() > t.length()){
            String tmp = s;
            s =t;
            t = tmp;
        }
        //t是长的，s是短的
        int dif = t.length()-s.length();
        if(dif > 1)
            return false;
        if(dif == 0){
            int cut = 0;
            for(int i = 0; i < s.length();i++){
                if(t.charAt(i)!=s.charAt(i)){
                    cut++;
                }
            }
            return cut == 1;
        }
        if(dif == 1){
            for(int i = 0; i < s.length();i++){
                if(t.charAt(i)!=s.charAt(i)){
                    return s.substring(i).equals(t.substring(i));
                }
            }
        }
        return true;
    }
}
