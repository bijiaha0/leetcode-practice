package Amazon.LongestPalindromicSubstring;
/**
 * Email: clickgwas@gmail.com
 */
public class Solution3 {
    public static String longestPalindrome(String s){
        int start = 0, longest = 0;
        for(int i = 0; i < s.length(); i++ ){
            for(int j = i; j < s.length(); j++ ){
                if(j-i+1 > longest && palindrome(s,i,j)){
                    longest = j-i+1;
                    start = i;
                }//abad   i =0  longest = 3
            }
        }
        return s.substring(start, start + longest);
    }
    public static boolean palindrome(String s,int i, int j){
        while (i < j && s.charAt(i)==s.charAt(j)){
            i+=1;
            j-=1;
        }
        return i>=j;
    }

    public static void main(String[] args) {
        String saddaaaa = longestPalindrome("saddaaaa");
        System.out.println(saddaaaa);
    }
}
