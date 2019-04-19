package Amazon.AddStrings;
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
    * 一次性进位
    * 相加
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

    /*
    * 高精度乘法的实现
    * 数位相乘ans[i+j] +=a[i]*b[j]
    *
    * */

    public static String mutiply(String num1, String num2){
        int l1 = num1.length();
        int l2 = num2.length();
        int[] ans = new int[l1+l2+1];
        for(int  i=0;i<l1;i++){
            for(int j = 0; j < l2; j++){
                ans[i+j] += num1.charAt(i)-'0' * num2.charAt(i)-'0';
            }
        }
        for(int i =0; i < ans.length-1;i++){
            ans[i+1] += ans[i]/10;
            ans[i] = ans[i]%10;
        }
        int i = l1+l2;
        while (ans[i]==0&&i>=1){
            i--;
        }
        String str = "";
        while (i>=0){
            str+=ans[i--];
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(addStrings1("213","312"));
    }

}
