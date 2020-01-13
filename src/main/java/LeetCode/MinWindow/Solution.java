package LeetCode.MinWindow;

public class Solution {
    public String minWindow(String s,String t){
        if(s==null||t==null||s.length()==0||t.length()==0){
            return new String();
        }
        int[] map = new int[128];
        for(char tmp:t.toCharArray()){
            map[tmp]++;
        }
        char[] sChar = s.toCharArray();
        int start = 0, end =0,count = s.length(),minLen = Integer.MAX_VALUE,startIndex=0;
        while (end < sChar.length){
            if(map[sChar[end++]]-->0){
                count--;
            }
            while (count==0){
                if(end-start+1<minLen){
                    minLen =end-start+1;
                    startIndex = start;
                }
                if(map[sChar[start++]]==0){
                    count++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE?new String():new String(sChar,startIndex,minLen);
    }
}
