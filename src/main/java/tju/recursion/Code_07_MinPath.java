package tju.recursion;
/*
给你一个二维数组，二维数组中的每个数都是正数，要求从左上
角走到右下角，  每一步只能向右或者向下。沿途经过的数字要累
加起来。返回最小的路径和。
* */
public class Code_07_MinPath {
	public static int minPath1(int[][] matrix) {
		return process1(matrix, 0, 0);
	}
	//当前从(row,col)出发，到达最右下角位置，最小路径和是多少
	public static int process1(int[][] matrix, int row, int col) {
		int res = matrix[row][col];
		//走到右下角
		if (row == matrix.length-1 && col == matrix[0].length-1) {
			return res;
		}
		//走到最后一行
		if (row == matrix.length-1) {
			return res + process1(matrix, row, col +1);
		}
		//走到最后一列
		if (col == matrix[0].length-1) {
			return res + process1(matrix, row + 1, col);
		}
		//往下走，或者往右走，选一种
		return res + Math.min(process1(matrix, row, col + 1), process1(matrix, row + 1, col));
	}
	public static int minPath2(int[][] m) {
		//边界条件
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		dp[row-1][col-1] = m[row-1][col-1];//填充最后到达的那个值
		//填充最后一列
		for (int i = row-2; i >=0; i--) {
			dp[i][col-1] = dp[i + 1][col-1] + m[i][col-1];
		}
		//填充最后一行
		for (int j = col-2; j >= 0; j--) {
			dp[row-1][j] = dp[row-1][j + 1] + m[row-1][j];
		}
		//填充剩余
		for (int i = row-2; i >= 0; i--) {
			for (int j = col-2; j >= 0; j--) {
				dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + m[i][j];
			}
		}
		return dp[0][0];
	}
	// for test
	public static int[][] generateRandomMatrix(int rowSize, int colSize) {
		if (rowSize < 0 || colSize < 0) {
			return null;
		}
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				result[i][j] = (int) (Math.random() * 10);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		System.out.println(minPath1(m));
		System.out.println(minPath2(m));
		m = generateRandomMatrix(6, 7);
		System.out.println(minPath1(m));
		System.out.println(minPath2(m));
	}
}
