package Amazon.LongestSubstringWithAtMostKDistinctCharacters;
import java.util.HashMap;
import java.util.Map;
/**
 * Email: clickgwas@gmail.com
 * Longest Substring with At Most K Distinct Characters
 */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k){
        int len = 0;
        int i = 0, j = 0;
        Map<Character,Integer> hs = new HashMap<>();
        for(i = 0; i< s.length(); i++){
            while(j < s.length()){
                if(hs.containsKey(s.charAt(j))){
                   hs.put(s.charAt(j), hs.get(s.charAt(j))+1);
                }else {
                    if(hs.size() == k){
                        break;
                    }
                    hs.put(s.charAt(j), 1);
                }
                j++;
            }
            len = Math.max(len,j-i);
            if(hs.containsKey(s.charAt(i))){
                if(hs.get(s.charAt(i))>1){
                    hs.put(s.charAt(i), hs.get(s.charAt(i))-1);
                }else {
                    hs.remove(s.charAt(i));
                }
            }
        }
        return len;
    }
}