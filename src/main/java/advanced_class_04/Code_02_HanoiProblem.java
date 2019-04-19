package advanced_class_04;

public class Code_02_HanoiProblem {
	public static void hanoi(int n) {
		if (n > 0) {
			func(n, "left", "mid", "right");
		}
	}

	// 1~n, 此时都在from上，
	// 1~n 全部从from，到to上，另一个杆是other
	public static void func(int n, String from, String other, String to) {
		if (n == 1) { // base
			System.out.println("move 1 from " + from + " to " + to);
		} else {
			func(n - 1, from, to, other);
			System.out.println("move "+ n +" from " + from + " to " + to);
			func(n - 1, other, from, to);
		}
	}

	public static int step1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		return process(arr, arr.length - 1, 1, 2, 3);
	}

	// 0号圆盘，是最上面的圆盘
	// 0~i, 目标：from -> to, 另一个杆叫other, 第几步？
	public static int process(int[] arr, int i, int from, int other, int to) {
		if (i == 0) { // base case 只剩一个圆盘的时候
			return  arr[0] == from ? 0 : (arr[0]==to ? 1 : -1);
		}
		// 不仅剩一个圆盘
		if (arr[i] != from && arr[i] != to) { // 无效状态
			return -1;
		}
		// 不仅剩一个圆盘，并且最后一个圆盘(i)状态有效
		if (arr[i] == from) {
			//第一大步走到什么程度，就代表整体走到什么程度
			int rest =  process(arr, i - 1, from, to, other);
			if (rest == -1) {
				return -1;
			}
			return rest;
		} else { // arr[i] == to，第一大步和第二步已经走完，目前在走第三大步
			int rest = process(arr, i - 1, other, from, to); // 第三大步走到了什么程度
			if (rest == -1) {
				return -1;
			}
			return (1 << i) + rest; // 2^i + rest
		}
	}

	public static int step2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int from = 1;
		int mid = 2;
		int to = 3;
		int i = arr.length - 1;
		int res = 0;
		int tmp = 0;
		while (i >= 0) {
			if (arr[i] != from && arr[i] != to) {
				return -1;
			}
			if (arr[i] == to) {
				res += 1 << i;
				tmp = from;
				from = mid;
			} else {
				tmp = to;
				to = mid;
			}
			mid = tmp;
			i--;
		}
		return res;
	}

	public static void main(String[] args) {
//		int n = 5;
//		hanoi(n);

		int[] arr = { 3, 3, 2, 1 };
		System.out.println(step1(arr));
		System.out.println(step2(arr));

	}
}
