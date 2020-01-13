package Amazon.StringToIntegerAtoi;
public class Solution {
    public int myAtoi(String str) {
        int index = 0, sign = 1, n = str.length();
        long res = 0;
        char[] sc = str.toCharArray();
        if(n == 0) return (int) res;
        while(index < n && sc[index] == ' ') index ++;
        if(index < n && (sc[index] == '+' || sc[index] == '-')){
            if(sc[index]=='-') sign = -1;
            index ++;
        }
        while(index < n){
            int val = sc[index]-'0';
            if(val < 0||val > 9){
                break;
            }
            res = res * 10 + val;
            if(sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign == -1 &&(sign * res) < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            index ++;
        }
        return (int) res * sign;
    }
}
