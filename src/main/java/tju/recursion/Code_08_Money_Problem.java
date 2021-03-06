package tju.recursion;
/*
给你一个数组arr，和一个整数aim。
如果可以任意选择arr中的数字，能不能累加得到aim，
返回true或者false
* */
public class Code_08_Money_Problem {
	public static boolean money1(int[] arr, int aim) {
		return process1(arr, 0, 0, aim);
	}
	public static boolean process1(int[] arr, int i, int preSum, int aim) {
		if (i == arr.length) {
			return preSum == aim ? true : false;
		}
		//要第i个数字和不要第i个数字
		return process1(arr, i + 1, preSum, aim) || process1(arr, i + 1, preSum + arr[i], aim);//有一个true，就是true。
	}
	public static boolean money2(int[] arr, int aim) {
		boolean[][] dp = new boolean[arr.length + 1][aim + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][aim] = true;
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = aim - 1; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j];
				if (j + arr[i] <= aim) {
					dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
				}
			}
		}
		return dp[0][0];
	}
	public static void main(String[] args) {
		int[] arr = { 1, 4, 8 };
		int aim = 12;
		System.out.println(money1(arr, aim));
		System.out.println(money2(arr, aim));
	}

}
