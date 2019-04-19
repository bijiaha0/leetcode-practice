package advanced_class_06;
//是否互为旋变字符串
public class Code_06_Scramble_String {

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

	// str1[L1..R1] 和 str2[L2..R2] 一定是等长的。
	// 返回这两段上的字符串，是否互为旋变字符串
	public static boolean func1(char[] str1, char[] str2, int L1, int R1,
			int L2, int R2) {
		if (L1 == R1) { // base case 各自只有一个字符
			return str1[L1] == str2[L2];
		}
		// L1+i是前缀的末尾位置   L1+i+1就是后缀的开始位置
		for (int i = 0; i < (R1 - L1); i++) {
			
			
			if ((
					// 左对左，右对右
					func1(str1, str2, L1, L1 + i, L2, L2 + i) 
					&& func1(str1, str2,L1 + i + 1, R1, L2 + i + 1, R2))
					
				|| 
				// 左对右，右对左
				    (  func1(str1, str2, L1, L1 + i, R2 - i, R2) 
				    && func1(str1, str2, L1 + i + 1, R1, L2, R2 - i - 1))) {
				return true;
			}
		}
		return false;
	}

	
	// str1[L1..L1+size-1]  和 str2[L2..L2+size-1] 一定是等长的。
	// 返回这两段上的字符串，是否是交错组成串
	// func2(str1, str2, 0, 0, str1.size);
	//L1和L2是开始的位置，size是从L1和L2开始，往右要拿出多少字符。
	public static boolean func2(char[] chs1, char[] chs2, int L1, int L2,
			int size) {
		if (size == 1) {
			return chs1[L1] == chs2[L2];
		}
		for (int leftPart = 1; leftPart < size; leftPart++) {
			if (
					(func2(chs1, chs2, L1, L2, leftPart) 
				  && func2(chs1, chs2, L1 + leftPart, L2 + leftPart, size - leftPart))
			|| 
			        (func2(chs1, chs2, L1, L2 + size - leftPart, leftPart) 
			      && func2(chs1, chs2, L1 + leftPart, L2, size - leftPart))) {
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
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		boolean[][][] dp = new boolean[N][N][N + 1]; // (L1, L2, size)
		// 立方体中，第一层的表
		for (int L1 = 0; L1 < N; L1++) {
			for (int L2 = 0; L2 < N; L2++) {
				dp[L1][L2][1] = str1[L1] == str2[L2];
			}
		}
		// 依次填好每一层的表(size)
		for (int size = 2; size <= N; size++) {
			
			// 对于每一层上的二维表，填好，但是有些点无意义
			for (int L1 = 0; L1 <= N - size; L1++) {
				for (int L2 = 0; L2 <= N - size; L2++) {
					
					
					
					for (int part = 1; part < size; part++) {
						if ((dp[L1][L2][part] 
						  && dp[L1 + part][L2 + part][size - part])
					||       
					        (dp[L1][L2 + size - part][part] 
					      && dp[L1 + part][L2][size - part])) {
							
							
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
