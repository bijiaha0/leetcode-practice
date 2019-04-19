package advanced_class_06;
//数组中子数组的最大累乘积
public class Code_06_SubArrayMaxProduct {
	public static double maxProduct(double[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		double max = arr[0]; // 每一步的i-1尾大
		double min = arr[0]; // 每一步的i-1尾小
		double res = arr[0]; // 答案
		double p1 = 0;
		double p2 = 0;
		double p3 = 0;
		for (int i = 1; i < arr.length; ++i) {
			p1 = arr[i];
			p2 = max * arr[i];
			p3 = min * arr[i];
			max = Math.max(Math.max(p2, p3), p1);
			min = Math.min(Math.min(p2, p3), p1);
			res = Math.max(res, max);
		}
		return res;
	}
	public static void main(String[] args) {
		double[] arr = { -2.5, 4, 0, 3, 0.5, 8, -1 };
		System.out.println(maxProduct(arr));
	}
}
