package advanced_class_05;
//丑数
public class Code_01_Ugly_Number {

	public static int uglyNumber1(int index) {
		int number = 0;
		int count = 0;
		while (count < index) {
			++number;
			if (isUgly(number))
				count++;
		}
		return number;
	}

	public static boolean isUgly(int number) {
		while (number % 2 == 0)
			number = number / 2;
		while (number % 3 == 0)
			number = number / 3;
		while (number % 5 == 0)
			number = number / 5;
		return (number == 1) ? true : false;
	}

	public static int uglyNumber2(int n) {
		int[] help = new int[n];
		help[0] = 1;
		int x = 0;// 0位置 * 2
		int y = 0;// 0位置 * 3
		int z = 0;// 0位置 * 5
		int index = 1;
		while (index < n) {
			help[index] = Math.min(2 * help[x], Math.min(3 * help[y], 5 * help[z]));
			if (help[index] == 2 * help[x])
				x++;
			if (help[index] == 3 * help[y])
				y++;
			if (help[index] == 5 * help[z])
				z++;
			index++;
		}
		return help[index - 1];
	}

	public static void main(String[] args) {
		int test = 11;
		System.out.println(uglyNumber1(test));
		System.out.println(uglyNumber2(test));
	}
}
