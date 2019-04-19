package advanced_class_04;
//字符串到数字
public class Code_07_ConvertStringToInteger {

	public static int convert(String str) {
		if (str == null || str.equals("")) {
			return 0; // can not convert
		}
		char[] chas = str.toCharArray();
		if (!isValid(chas)) {
			return 0; // can not convert
		}
		boolean positive = chas[0] == '-' ? false : true;// 该数是否为正数
		int minq = Integer.MIN_VALUE / 10;// -214748364   *  10 => min
		int minr = Integer.MIN_VALUE % 10;// -8
		int res = 0;
		int cur = 0;
		for (int i = positive ? 0 : 1; i < chas.length; i++) {
			cur = '0' - chas[i];
			if ((res < minq) || (res == minq && cur < minr)) {
				return 0; // can not convert
			}
			res = res * 10 + cur;
		}
		if (positive && res == Integer.MIN_VALUE) {
			return 0; // can not convert
		}
		return positive ? -res : res;
	}

	public static boolean isValid(char[] str) {
		if (str[0] != '-' && (str[0] < '0' || str[0] > '9')) {
			return false;
		}
		if (str[0] == '-' && (str.length == 1 || str[1] == '0')) {
			return false;
		}
		if (str[0] == '0' && str.length > 1) {
			return false;
		}
		for (int i = 1; i < str.length; i++) {
			if (str[i] < '0' || str[i] > '9') {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String test1 = "2147483647"; // max in java
		System.out.println(convert(test1));

		String test2 = "-2147483648"; // min in java
		System.out.println(convert(test2));

		String test3 = "2147483648"; // overflow
		System.out.println(convert(test3));

		String test4 = "-2147483649"; // overflow
		System.out.println(convert(test4));

		String test5 = "-123";
		System.out.println(convert(test5));
		
		
		String str = "2147483648";
		
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println(String.valueOf("1231a2"));
		

	}

}
