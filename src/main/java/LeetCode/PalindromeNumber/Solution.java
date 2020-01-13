package LeetCode.PalindromeNumber;

public class Solution {
    public boolean isOrNot(int num){
        if(num<0){
            return false;
        }
        if(num==1){
            return true;
        }
        int  y =0;
        int x = num;
        while (x!=0){
            y = y*10+x%10;
            x = x/10;
        }
        if(y == num){
            return true;
        }
        return false;
    }
}
