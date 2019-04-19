package Amazon.WoodCut;

import java.util.Scanner;

/*
* https://www.lintcode.com/problem/wood-cut/description
* 二分法
* */
public class Solution {

    public static int woodCut(int[] L, int k) {

        int l = 1, res = 0;
        int r = 0;
        for (int item : L) {
            r = Math.max(r, item);
        }

        while (l <= r) {
            int mid = l + (r - l) / 2; // (l + r) / 2 may overflow
            if (count(L, mid) >= k) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }

    private static int count(int[] L, int len) {
        int sum = 0;
        for (int item : L) {
            sum += item / len;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();//N根原始的绳子
        int M = scan.nextInt();//最终需要M根绳子数
        scan.nextLine();
        String s = scan.nextLine();
        int[] test = new int[N];
        String[] split = s.split(" ");
        for(int k = 0; k < split.length; k++){
            test[k] =Integer.valueOf(split[k]);
        }
        System.out.println(woodCut(test, M));
    }
}
