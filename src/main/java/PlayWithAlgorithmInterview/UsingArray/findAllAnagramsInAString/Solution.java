package PlayWithAlgorithmInterview.UsingArray.findAllAnagramsInAString;
import java.util.ArrayList;
import java.util.List;
/**
 * Author: bijiaha0
 * Date: 2019-02-17
 * Time: 10:59 PM
 * Email: clickgwas@gmail.com
 */
/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
* Input:
s: “cbaebabacd” p: “abc”
Output:
[0, 6]
* */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        if(s.length() < p.length())
            return result;
        int[] freq_p = new int[26];
        for (char c : p.toCharArray())
            freq_p[c - 'a'] += 1;
        int[] freq_s = new int[26];
        int left = 0, right = -1; //Sliding window: s[l, r]
        char[] sc = s.toCharArray();
        while (right + 1 < s.length()) {
            right++;
            freq_s[sc[right] - 'a'] ++;
            if(right - left + 1 > p.length())
                freq_s[sc[left++] - 'a'] --;
            if (right - left + 1 == p.length() && same(freq_p,freq_s))
                result.add(left);
        }
        return result;
    }
    public boolean same(int[] freq_p, int[] frep_s){
        for(int i = 0; i < 26; i++)
            if(frep_s[i] != freq_p[i]){
                return false;
            }
            return true;
    }
}
