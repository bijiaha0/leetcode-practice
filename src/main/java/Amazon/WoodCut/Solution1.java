package Amazon.WoodCut;
/**
 * 二分
 * 时间复杂度：nlog(max)
 * https://www.jiuzhang.com/solutions/wood-cut/
 */
public class Solution1 {
    public static double woodCut(int[] L, int k) {
        double l = 1;
        double r = 0;
        for (int item : L) {
            r = Math.max(r, (double) item);
        }

        while (l + 1 < r) {

            double mid = l + (r - l) / 2.0;
            if (count(L, mid) >= k) {//切的太长了
                l = mid;
            } else {//
                r = mid;
            }
        }

        if (count(L, r) >= k) {//先验证大的值能不能取到
            return r;
        }

        if (count(L, l) >= k) {//先验证小的值能不能取到
            return l;
        }
        return 0;
    }

    private static int count(int[] L, double len) {
        int sum = 0;
        for (int item : L) {
            sum += ((item-(item % len)) / len);
        }
        return sum;
    }

    public static void main(String[] args) {
        /*Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();//N根原始的绳子
        int M = scan.nextInt();//最终需要M根绳子数
        scan.nextLine();
        String s = scan.nextLine();
        int[] test = new int[N];
        String[] split = s.split(" ");
        for(int k = 0; k < split.length; k++){
            test[k] =Integer.valueOf(split[k]);
        }
        System.out.println(woodCut(test, M));*/
        System.out.println(5/2.0);
    }
}
