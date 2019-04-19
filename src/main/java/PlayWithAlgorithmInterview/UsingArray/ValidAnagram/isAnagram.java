package PlayWithAlgorithmInterview.UsingArray.ValidAnagram;
/**
 * Author: bijiaha0
 * Date: 2019-02-18
 * Time: 1:25 AM
 * Email: clickgwas@gmail.com
 */
// https://leetcode.com/problems/valid-anagram/
public class isAnagram {
    public boolean isOrNo(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] freq = new int[26];
        for(int i = 0 ; i < s.length() ;i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i = 0 ; i < t.length() ;i++){
            freq[t.charAt(i)-'a']--;
            if(freq[t.charAt(i)-'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
