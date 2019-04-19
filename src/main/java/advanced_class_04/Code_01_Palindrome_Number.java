package advanced_class_04;
import java.util.HashMap;
//判断是不是回文数
public class Code_01_Palindrome_Number {

	public static boolean isPalindrome(int n) {
		if (n == Integer.MIN_VALUE) {
			return false;
		}
		n = Math.abs(n);
		int help = 1;
		while (n / help >= 10) {
			help *= 10;
		}
		while (n != 0) {
			if (n / help != n % 10) {
				return false;
			}
			n = (n % help) / 10;
			help /= 100;
		}
		return true;
	}

	public static int getMaxAimLength(int[] arr, int aim) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);// important
		int sum = 0;
		int res = 0;
		for (int j = 0; j < arr.length; j++) {
			sum += arr[j];
			if (map.containsKey(sum - aim)) {
				int i = map.get(sum - aim);
				res = Math.max(res, j - i);
			}
			if (!map.containsKey(sum)) {
				map.put(sum, j);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Math.abs(Integer.MIN_VALUE));
	}

}
