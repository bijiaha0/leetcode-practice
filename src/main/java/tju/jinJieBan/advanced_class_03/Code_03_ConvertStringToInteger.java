package tju.jinJieBan.advanced_class_03;
//将整数字符串转成整数值
//【题目】 给定一个字符串str，如果str符合日常书写的整数形式，并且属于32 位整数的范围，返回str所代表的整数值，否则返回0。
//【举例】
//str="123"，返回123。 str="023"，因为"023"不符合日常的书写习惯，所以返回0。 str="A13"，返回0。
//str="0"，返回0。
//str="2147483647"，返回2147483647。 str="2147483648"，因为溢出了，所以返回0。 str="-123"，返回-123。
public class Code_03_ConvertStringToInteger {

	public static int convert(String str) {
		if (str == null || str.equals("")) {
			return 0; // can not convert
		}
		char[] chas = str.toCharArray();
		if (!isValid(chas)) {
			return 0; // can not convert
		}
		boolean posi = chas[0] == '-' ? false : true;
		int minq = Integer.MIN_VALUE / 10;
		int minr = Integer.MIN_VALUE % 10;
		int res = 0;
		int cur = 0;
		for (int i = posi ? 0 : 1; i < chas.length; i++) {
			cur = '0' - chas[i];
			if ((res < minq) || (res == minq && cur < minr)) {
				return 0; // can not convert
			}
			res = res * 10 + cur;
		}
		if (posi && res == Integer.MIN_VALUE) {
			return 0; // can not convert
		}
		return posi ? -res : res;
	}

	public static boolean isValid(char[] chas) {
		if (chas[0] != '-' && (chas[0] < '0' || chas[0] > '9')) {
			return false;
		}
		if (chas[0] == '-' && (chas.length == 1 || chas[1] == '0')) {
			return false;
		}
		if (chas[0] == '0' && chas.length > 1) {
			return false;
		}
		for (int i = 1; i < chas.length; i++) {
			if (chas[i] < '0' || chas[i] > '9') {
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

	}

}
