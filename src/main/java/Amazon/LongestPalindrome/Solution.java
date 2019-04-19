package Amazon.LongestPalindrome;
import java.util.HashSet;
import java.util.Set;
/**
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/longest-palindrome/solution
 * amazon
 * 留下一个单个的字符+出现偶数次的
 * 逆向思维
 */
public class Solution {
    public static int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c))
                set.remove(c);
            else set.add(c);
        }
        int remove = set.size();
        if (remove > 0)
            remove -= 1;//把出现单次的字母，只留下一个
        return s.length() - remove;
    }
    public static void main(String[] args) {
        int abccccdd = longestPalindrome("abccccdd");
        System.out.println(abccccdd);
    }
    public static int longPa(String s){
        char[] arr = s.toCharArray();
        Set<Character> hs = new HashSet<>();
        for(int j =0; j < arr.length; j++){
            if(hs.contains(arr[j])){
                hs.remove(arr[j]);
            }else {
                hs.add(arr[j]);
            }
        }
        int remove = hs.size();//出现奇数次的字母个数
        if(remove > 0){
            remove--;//留下一个字母
        }
        return arr.length-remove;
    }




















}
