package advanced_class_01;
public class Code_01_KMP {
	// KMP
	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] str1 = s.toCharArray();
		char[] str2 = m.toCharArray();
		int X = 0;
		int Y = 0;
		int[] nextArr = getNextArray(str2); // 得到str2的nextArr -> O(?)
		while (X < str1.length && Y < str2.length) {
			if (str1[X] == str2[Y]) {
				X++;
				Y++;
			} else if (nextArr[Y] == -1) { // Y已经到了str2的0位置了
				X++;
			} else {
				Y = nextArr[Y]; // Y减小
			}
		}
		return Y == str2.length ? X - Y : -1;
	}
	public static int[] getNextArray(char[] str2) {
		if (str2.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[str2.length];
		next[0] = -1;
		next[1] = 0;
		int i = 2;
		int cn = 0;
		while (i < next.length) {
			if (str2[i - 1] == str2[cn]) {
				next[i++] = ++cn;
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[i++] = 0;
			}
		}
		return next;
	}
	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
		System.out.println(getIndexOf(str, match));
	}
}
