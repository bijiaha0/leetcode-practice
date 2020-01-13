package Amazon.BigIntegerAddition;
/**
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/add-strings/description
 */
public class Solution {
    /*模拟*/
    public String addStrings(String num1, String num2) {
        String res = "";
        int carry = 0;
        for(int i =num1.length() - 1, j = num2.length() - 1; i >= 0||j >= 0;i--,j--){
            int sum =carry;
            sum += (i >= 0) ? num1.charAt(i)-'0':0;
            sum += (j >= 0) ? num2.charAt(j)-'0':0;
            res = (sum % 10) + res;
            carry = sum / 10;
        }
        if(carry!=0)
            res = carry + res;
        return res;
    }
    /*
    * 数位分离
    * */
    public static String addStrings1(String num1, String num2) {
        int l = Math.max(num1.length(),num2.length())+1;
        int[] arr=new int[l];
        int[] arr1=new int[l];
        int[] arr2=new int[l];
        for(int i = 0; i < num1.length();i++){
            arr1[i] = num1.charAt(i)-'0';
        }
        for(int i = 0; i < num2.length();i++){
            arr2[i] = num2.charAt(i)-'0';
        }
        for(int i = 0;i < l;i++){
            arr[i] = arr1[i]+arr2[i];
        }
        for(int i = 0;i < l-1;i++){
            arr[i+1]+=arr[i]/10;
            arr[i] = arr[i]%10;
        }
        int i = l-1;
        while(arr[i]==0 && i >= 1){
            i--;
        }
        String res = "";
        while (i>=0){
            res +=arr[i--];
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(addStrings1("213","312"));
    }

}
