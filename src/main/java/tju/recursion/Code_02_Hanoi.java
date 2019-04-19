package tju.recursion;
/*
汉诺塔问题 打印n层汉诺塔从最左边移动到最右边的全部过程
* */
public class Code_02_Hanoi {

	public static void hanoi(int n) {
		if (n > 0) {
			func(n, "left","right", "mid");
		}
	}
	public static void func(int n, String from, String to, String help) {
		if (n == 1) {
			System.out.println("move " + 1 + " from " + from + " to " + to);
		} else {
			func(n - 1, from, help, to);//to是辅助
			System.out.println("move " + n + " from " + from + " to " + to);
			func(n - 1, help, to, from);//from是辅助
		}
	}

	public static void main(String[] args) {
		int n = 3;
		hanoi(n);
	}
}
