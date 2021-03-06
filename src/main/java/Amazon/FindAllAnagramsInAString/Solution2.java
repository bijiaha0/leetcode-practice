package Amazon.FindAllAnagramsInAString;
import java.util.ArrayList;
import java.util.List;
/**
 * Author: bijiaha0
 * Date: 2019-02-23
 * Time: 10:06 AM
 * Email: clickgwas@gmail.com
 */
public class Solution2 {
    public static  List<Integer> findAnagrams( String s, String p){
        List<Integer> ans = new ArrayList<>();
        int[] cns = new int[256];
        int[] cnp = new int[256];
        if(s.length() < p.length()){
            return ans;
        }
        for(int i=0; i < p.length();i++){
            cns[s.charAt(i)]++;
            cnp[p.charAt(i)]++;
        }
        if(cns==cnp){//O(256)
            ans.add(0);
        }
        for(int i = p.length();i< s.length();i++){
            cns[s.charAt(i)]++;
            cns[s.charAt(i-p.length())]++;
            if(cns==cnp){
                ans.add(i-p.length()+1);
            }
        }
        return ans;
    }
}
