package tju.recursion;
/*
*********************************暴力递归**********************************
给定两个数组w和v，两个数组长度相等，
w[i]表示第i件商品的 重量，v[i]表示第i件商品的价值。
再给定一个整数bag，要求你挑选商品的重量加起来一定不能超过bag，
返回满足这个条件下，你能获得的最大价值。
* */
public class Code_09_Knapsack {
	/*
	* 暴力递归
	* */
	public static int maxValue1(int[] c, int[] p, int bag) {
		return process1(c, p, 0, 0, bag);
	}
	public static int process1(int[] weights, int[] values, int i, int alreadyWeight, int bag) {
		if (alreadyWeight > bag) {
			return Integer.MIN_VALUE;//无效值
		}
		if (i == weights.length) {
			return 0;
		}
		return Math.max(process1(weights, values, i + 1, alreadyWeight, bag), values[i] + process1(weights, values, i + 1, alreadyWeight + weights[i], bag));
	}








	public static int maxValue2(int[] weight, int[] value, int bag) {
		int[][] dp = new int[weight.length + 1][bag + 1];
		for (int i = weight.length - 1; i >= 0; i--) {
			for (int j = bag; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j];//确定初始状态
				if (j + weight[i] <= bag) {
					dp[i][j] = Math.max(dp[i+1][j], value[i] + dp[i + 1][j + weight[i]]);
				}
			}
		}
		return dp[0][0];
	}
	public static void main(String[] args) {
		int[] c = { 3, 2, 4, 7 ,9,10,20,100,300};
		int[] p = { 5, 6, 3, 19,24,33,22 ,30,55};
		int bag = 44;
		System.out.println(maxValue1(c, p, bag));
		System.out.println(maxValue2(c, p, bag));
	}
}
