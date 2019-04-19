package tju.basic_class_02;

public class Code_01_KMP {
	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int x = 0;
		int y = 0;
		int[] next = getNextArray(ms);//黑盒
		while (x < ss.length && y < ms.length) {
			if (ss[x] == ms[y]) {
				x++;
				y++;
			} else if (next[y] == -1) {//y已经跳到Str2的0位置了，x对应的字符配不上
				x++;
			} else {//y没有跳到str2的0位置，x对应的字符配不上。
				y = next[y];//跳到前缀下一个字符位置
			}
		}
		return y == ms.length ? x - y : -1;//如果y已经越界了，则说明是配出来了。
	}
	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int i = 2;//从左往右求每一个i的next数组值
		int cn = 0;//跳到的位置，需要和i-1位置字符比较的位置
		while (i < next.length) {
			if (ms[i - 1] == ms[cn]) {
				next[i++] = ++cn;
			} else if (cn > 0) {//没相等，但是cn还能往前跳，那就往前跳
				cn = next[cn];
			} else {//没相等，也没法跳了
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
