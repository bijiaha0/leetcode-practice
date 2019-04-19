package tju.basic_class_03;
/*
 转圈打印矩阵
【题目】
给定一个整型矩阵matrix，请按照转圈的方式打印它。
例如:
1234
5678
9 10 11 12
13 14 15 16 打印结果为:1，2，3，4，8，12，16，15，14，13，9，5，6，7，11， 10
【要求】 额外空间复杂度为O(1)。
* */
public class Code_07_PrintMatrixSpiralOrder {

	public static void spiralOrderPrint(int[][] matrix) {
		int row1 = 0;
		int col1 = 0;
		int row2 = matrix.length - 1;
		int col2 = matrix[0].length - 1;
		while (row1 <= row2 && col1 <= col2) {//while
			printEdge(matrix, row1++, col1++, row2--, col2--);//宏观调度
		}
	}

	public static void printEdge(int[][] m, int row1, int col1, int row2, int col2) {
		if (row1 == row2) { // 矩阵只有一行
			for (int i = col1; i <= col2; i++) {
				System.out.print(m[row1][i] + " ");
			}
		} else if (col1 == col2) { // 矩阵只有一列
			for (int i = row1; i <= row2; i++) {
				System.out.print(m[i][col1] + " ");
			}
		} else {
			int curC = col1;
			int curR = row1;
			while (curC != col2) {
				System.out.print(m[row1][curC] + " ");
				curC++;
			}
			while (curR != row2) {
				System.out.print(m[curR][col2] + " ");
				curR++;
			}
			while (curC != col1) {
				System.out.print(m[row2][curC] + " ");
				curC--;
			}
			while (curR != row1) {
				System.out.print(m[curR][col1] + " ");
				curR--;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		spiralOrderPrint(matrix);

	}

}
