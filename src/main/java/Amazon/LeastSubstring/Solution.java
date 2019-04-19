package Amazon.LeastSubstring;
/**
 * Email: clickgwas@gmail.com
 * amazon
 */
/*
* https://www.lintcode.com/problem/least-substring/description?_from=ladder&&fromId=69
* */
/*
input: s = "aabbbc", k = 3
Output: 3
we can get "aa", "bbb", "c" three substring.

Input: s = "aabbbc", k = 2
Output: 4
Explanation:
we can get "aa", "bb", "b", "c" four substring.
* */
public class Solution {
    public int getAns (String s, int k) {
        int n = s.length(), ans = 1, cnt = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt (i) == s.charAt (i - 1) && cnt < k) {
                cnt++;
            } else {
                ans++;
                cnt = 1;
            }
        }
        return ans;
    }

    public int  getRes(String s , int k){
        int ans =1, cur =1;
        for(int i =1;i < s.length();i++){
            if(s.charAt(i)==s.charAt(i-1) && cur<k){
                cur++;
            }else {
                ans++;
                cur=1;
            }
        }
        return ans;
    }















}
