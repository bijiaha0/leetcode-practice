package advanced_class_05;
//字符串转IP
public class Code_05_ConvertStringToIP {
	public static int convertNum1(String str) {
		if (str == null || str.length() < 4 || str.length() > 12) {
			return 0;
		}
		char[] chas = str.toCharArray();
		return process(chas, 0, 0);
	}
	//str[i..N-1]去转化ipv4，str[0..i-1]已经形成的有效部分数量为parts
	// 返回有多少种有效的
	public static int process(char[] str, int i, int parts) {
		if (parts > 4) { // base case 1  IP是四段
			return 0;
		}
		if (i == str.length) { // [0..i-1]已经做完决定了 base case 2
			return parts == 4 ? 1 : 0;
		}
		// 剩下的东西还有得转
		// 决定一
		int res = process(str, i + 1, parts + 1);// 当前块儿为（i）单独组成
		// 决定二 : 决定，让i和i+1位置字符，共同构成当前的ipv4块
		// 一定没有决定二的场景
		if (str[i] == '0' || i == str.length-1) {//IP里面没有01-09
			return res;
		}
		// 包含决定二的场景
		res += process(str, i + 2, parts + 1); // 当前块儿为（i,i+1）共同组成
		// 决定三 : 决定，让i、i+1和i+2位置字符，共同构成当前的ipv4块。。。要求小于256
		if (i + 2 < str.length) { // 有三个字符的时候
			int sum = (str[i] - '0') * 100 + (str[i + 1] - '0') * 10 + (str[i + 2] - '0');
			if (sum < 256) {
				return res + process(str, i + 3, parts + 1);
			} else {
				return res;
			}
		} else {
			return res;
		}
	}
	// 动态规划的方法
	public static int getValidIpv4s(String s) {
		//先洗一下无效参数
		if(s==null || s.length() < 4 || s.length() > 12) {
			return 0;
		}
		char[] str = s.toCharArray();
		int size = str.length;
		int[][] dp = new int[size + 1][5];
		dp[size][4] = 1; 
		for(int i = size - 1; i >= 0;i--) {// 从下往上考虑所有行
			for(int parts = 3;parts >= 0; parts--) {// 从右往左，考虑所有列
				dp[i][parts] = dp[i+1][parts+1];
				if (str[i] != '0' && i != str.length-1) {
					dp[i][parts] += dp[i + 2][ parts + 1];
				}
				if (i + 2 < str.length) { 
					int sum = (str[i] - '0') * 100 + (str[i + 1] - '0') * 10 + (str[i + 2] - '0');
					if (sum < 256) {
						dp[i][parts] += dp[i + 3][ parts + 1];
					} 
			    }
		     }
		}
		return dp[0][0];
	}

	public static int convertNum2(String str) {
		if (str == null || str.length() < 4 || str.length() > 12) {
			return 0;
		}
		char[] chas = str.toCharArray();
		int size = chas.length;
		int[][] dp = new int[size + 3][5];
		dp[size][4] = 1;
		for (int parts = 3; parts >= 0; parts--) {
			for (int i = Math.min(size - 1, parts*3); i >= parts ; i--) {
				dp[i][parts] = dp[i + 1][parts + 1];
				if (chas[i] != '0') {
					dp[i][parts] += dp[i + 2][parts + 1];
					if (i + 2 < chas.length) {
						int sum = (chas[i] - '0') * 100 + (chas[i + 1] - '0') * 10 + (chas[i + 2] - '0');
						if (sum < 256) {
							dp[i][parts] += dp[i + 3][parts + 1];
						}
					}
				}
			}
		}
		return dp[0][0];
	}

	public static String getRandomNumberString() {
		char[] chas = new char[(int) (Math.random() * 10) + 3];
		for (int i = 0; i < chas.length; i++) {
			chas[i] = (char) (48 + (int) (Math.random() * 10));
		}
		return String.valueOf(chas);
	}

	public static void main(String[] args) {
//		String test = "101101";
//		System.out.println(convertNum2(test));
//		System.out.println(getValidIpv4s(test));
		int testTime = 3000000;
		boolean hasErr = false;
		for (int i = 0; i < testTime; i++) {
			String test = getRandomNumberString();
			if (convertNum1(test) != convertNum2(test)) {
				hasErr = true;
			}
		}
		if (hasErr) {
			System.out.println("233333");
		} else {
			System.out.println("666666");
		}
	}
}
