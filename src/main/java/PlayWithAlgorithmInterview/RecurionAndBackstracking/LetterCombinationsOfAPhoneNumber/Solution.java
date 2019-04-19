package PlayWithAlgorithmInterview.RecurionAndBackstracking.LetterCombinationsOfAPhoneNumber;
import java.util.List;
import java.util.ArrayList;
// 93
// 131
/// 17. Letter Combinations of a Phone Number
/// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
/// 时间复杂度: O(2^len(s))
/// 空间复杂度: O(len(s))
class Solution {
    private static String letterMap[] = {
                " ",    //0
                "",     //1
                "abc",  //2
                "def",  //3
                "ghi",  //4
                "jkl",  //5
                "mno",  //6
                "pqrs", //7
                "tuv",  //8
                "wxyz"  //9
    };
    private static ArrayList<String> res;
    public static List<String> letterCombinations(String digits) {
        res = new ArrayList<String>();
        if(digits.equals(""))
            return res;
        findCombination(digits, 0, "");
        return res;
    }
    // s中保存了此时从digits[0...index-1]翻译得到的一个字母字符串
    // 寻找和digits[index]匹配的字母, 获得digits[0...index]翻译得到的解
    private static void findCombination(String digits, int index, String s){
        if(index == digits.length()){
            res.add(s);
            return;
        }
        Character c = digits.charAt(index);//数字字符
        String letters = letterMap[c - '0'];//对应的ASCII做差
        for(int i = 0 ; i < letters.length() ; i ++){
            findCombination(digits, index+1, s + letters.charAt(i));
        }
    }
    public static void main(String[] args) {
        System.out.println(letterCombinations("234").toString());
    }
}
