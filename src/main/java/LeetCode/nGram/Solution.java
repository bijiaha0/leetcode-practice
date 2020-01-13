package LeetCode.nGram;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> ngrams(int n, String str) {
        List<String> res = new ArrayList<>();
        String[] strings = str.split(" ");
        for (int i = 0; i < strings.length - n + 1; i++) {
            res.add(concat(i,i+n-1,strings));
        }
        return res;
    }
    public static String concat(int start, int end, String[] strings) {
        String res = "";
        for (int i = start; i <= end; i++) {
            res = res+(i==start?strings[i]:" "+strings[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        for(int i = 1; i <=3;i++){
            System.out.println(ngrams(i,"my name is bjh"));
        }
    }

}
