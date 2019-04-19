package tju.jinJieBan.advanced_class_07;
//给定一个长度大于1的字符串，我们可以把这个字符串分成两个非空的部分， 并且每个部分还能细分下去，
//并且可以用二叉树的形式来表达，比如
//字符串 s1 = "great": 可以分解成这么一个样子(这只是其中一种分解结构)
//great /\
//gr eat /\/\
//g r e at /\
//at 我们说s1的搅乱串，指的是在任意一种分解结构中，随意交换某个节点的左
//右两个孩子所形成的字符串。
//比如我们可以选择在上面的分解结构中，交换“gr”这个节点的孩子节点，形 成的树为:
//rgeat /\
//rg eat /\/\
//r g e at /\
//at 那么“rgeat”，是“great”的搅乱串。
//同样，我们可以继续交换“eat”节点的左右孩子，形成:
//rgtae /\
//rg tae /\/\
//r g ta e /\
//t a 那么“rgtae”，是“great”的搅乱串。
//所以一个字符串的搅乱串是非常之多的，分解结构本身就有很多种， 而且每一种分解结构都可以随意交换任意一个节点的左右孩子。
//给定两个字符串s1和s2，判断s2是不是s1的搅乱串。
public class Code_01_Scramble_String {

	public static boolean isScramble1(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.equals(s2)) {
			return true;
		}
		int N = s1.length();
		// return func1(s1.toCharArray(), s2.toCharArray(), 0, N - 1, 0, N - 1);
		return func2(s1.toCharArray(), s2.toCharArray(), 0, 0, N);
	}

	public static boolean func1(char[] chs1, char[] chs2, int L1, int R1,
			int L2, int R2) {
		if (L1 == R1) {
			return chs1[L1] == chs2[L2];
		}
		for (int i = 0; i < (R1 - L1); i++) {
			if ((func1(chs1, chs2, L1, L1 + i, L2, L2 + i) && func1(chs1, chs2,
					L1 + i + 1, R1, L2 + i + 1, R2))
					|| (func1(chs1, chs2, L1, L1 + i, R2 - i, R2) && func1(
							chs1, chs2, L1 + i + 1, R1, L2, R2 - i - 1))) {
				return true;
			}
		}
		return false;
	}

	public static boolean func2(char[] chs1, char[] chs2, int L1, int L2,
			int size) {
		if (size == 1) {
			return chs1[L1] == chs2[L2];
		}
		for (int part = 1; part < size; part++) {
			if ((func2(chs1, chs2, L1, L2, part) && func2(chs1, chs2,
					L1 + part, L2 + part, size - part))
					|| (func2(chs1, chs2, L1, L2 + size - part, part) && func2(
							chs1, chs2, L1 + part, L2, size - part))) {
				return true;
			}
		}
		return false;
	}

	public static boolean isScramble2(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.equals(s2)) {
			return true;
		}
		int N = s1.length();
		char[] chs1 = s1.toCharArray();
		char[] chs2 = s2.toCharArray();
		boolean[][][] dp = new boolean[N][N][N + 1];
		for (int L1 = 0; L1 < N; L1++) {
			for (int L2 = 0; L2 < N; L2++) {
				dp[L1][L2][1] = chs1[L1] == chs2[L2];
			}
		}
		for (int size = 2; size <= N; size++) {
			for (int L1 = 0; L1 <= N - size; L1++) {
				for (int L2 = 0; L2 <= N - size; L2++) {
					for (int p = 1; p < size; p++) {
						if ((dp[L1][L2][p] && dp[L1 + p][L2 + p][size - p])
								|| (dp[L1][L2 + size - p][p] && dp[L1 + p][L2][size
										- p])) {
							dp[L1][L2][size] = true;
							break;
						}
					}
				}
			}
		}
		return dp[0][0][N];
	}

	public static void main(String[] args) {
		String test1 = "bcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcde";
		String test2 = "cebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebd";
		// System.out.println(isScramble1(test1, test2));
		System.out.println(isScramble2(test1, test2));
	}

}
