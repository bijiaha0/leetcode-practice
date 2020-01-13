package Amazon.LongestCommonPrefix;
public class Solution {
    String longestCommonPrefix(String[] strs) {
        int i,n = strs.length;
        if(n==0) return "";
        String pre = strs[0];
        for(i = 1; i < n; i++){
            while(strs[i].indexOf(pre)!=0){
                pre = pre.substring(0,pre.length()-1);
            }
        }
        return pre;
    }
}
