package Amazon.MaximumSwap;
public class Solution {

    public static  void Swap(char[] s, int i, int j) {
        char temp  = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static int maximumSwap(int num) {
        char[] ss = String.valueOf(num).toCharArray();
        int res = num;
        for(int i =0; i < ss.length;i++){
            for(int j=i+1; j < ss.length; j++){
                Swap(ss,i,j);
                res = Math.max(res,Integer.valueOf(String.valueOf(ss)));
                Swap(ss,i,j);
            }
        }
        return res;
    }
    public int maximumSwap1(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        char[] back = new char[arr.length];
        for(int i = arr.length-2;i >=0 ; i--){
            back[i]  = Character.forDigit(Math.max(arr[i]-'0',back[i+1]-'0'),10);
        }
        for(int i = 0;i < arr.length ; i++){
            if(arr[i] == back[i]){
                continue;
            }
            for(int j =arr.length-1; j >= 0; j--){
                if(arr[j] == back[i]){
                    char temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    return Integer.valueOf(String.valueOf(arr));
                }
            }
        }
        return Integer.valueOf(String.valueOf(arr));
    }
    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
    }
}
