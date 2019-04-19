package advanced_class_08;
//判断一个点是否在三角形内部
public class Code_04_OneNumber {
	public static int solution1(int num) {
		if (num < 1) {
			return 0;
		}
		int count = 0;
		for (int i = 1; i <= num; i++) {
			count += get1Nums(i);
		}
		return count;
	}
	public static int get1Nums(int num) {
		int res = 0;
		while (num != 0) { // 把num每一个10进制位置的数字拿到
			if (num % 10 == 1) {
				res++;
			}
			num /= 10;
		}
		return res;
	}

	// 135679
	public static int solution2(int num) {
		if (num < 1) {
			return 0;
		}
		int len = getLenOfNum(num);
		if (len == 1) {
			return 1;
		}
		int tmp1 = powerBaseOf10(len - 1); // 100000
		int first = num / tmp1; // first -> 最高位的数字
		int firstOneNum = first == 1 ? ((num % tmp1) + 1) : tmp1; // 最高位为1的个数
		// tmp1 / 10 = 10000    135679 -> x1abcd
		int otherOneNum = first * (tmp1 / 10);// 单独一位上（非最高位）1的个数
		int obj = (len - 1);// 除去最高位之外，一共有多少位
		int otherOneNumAll = otherOneNum * obj;// 除去最高位，其他位上是1的个数;
		return firstOneNum + otherOneNumAll + solution2(num % tmp1);
	}

	public static int getLenOfNum(int num) {
		int len = 0;
		while (num != 0) {
			len++;
			num /= 10;
		}
		return len;
	}

	public static int powerBaseOf10(int base) {
		return (int) Math.pow(10, base);
	}

	public static void main(String[] args) {
		int num = 50000000;
		long start1 = System.nanoTime();
		System.out.println(solution1(num));
		long end1 = System.nanoTime();
		System.out.println("cost time: " + (end1 - start1) + " ns");

		long start2 = System.nanoTime();
		System.out.println(solution2(num));
		long end2 = System.nanoTime();
		System.out.println("cost time: " + (end2 - start2) + " ns");

	}
}
