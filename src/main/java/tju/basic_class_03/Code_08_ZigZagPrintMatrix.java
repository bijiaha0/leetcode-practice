package tju.basic_class_03;
/*
* 宏观的调度思路：
“之”字形打印矩阵
【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这个矩阵，例如: 1234
5678
9 10 11 12 “之”字形打印的结果为:1，2，5，9，6，3，4，7，10，11，8，12
【要求】 额外空间复杂度为O(1)。
* */
public class Code_08_ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] matrix) {
		int row1 = 0;
		int col1 = 0;
		int row2 = 0;
		int col2 = 0;
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		boolean fromUp = false;
		while (row1 != endR + 1) {//说明没走到结尾
			printLevel(matrix, row1, col1, row2, col2, fromUp);
			row1 = col1 == endC ? row1 + 1 : row1;
			col1 = col1 == endC ? col1 : col1 + 1;
			col2 = row2 == endR ? col2 + 1 : col2;
			row2 = row2 == endR ? row2 : row2 + 1;
			fromUp = !fromUp;
		}
		System.out.println();
	}
	//对角线走的方式(有两种方式)
	public static void printLevel(int[][] m, int row1, int col1, int row2, int col2,
			boolean f) {
		if (f) {
			while (row1 <= row2 ) {
				System.out.print(m[row1++][col1--] + " ");
			}
		} else {
			while (row2 >= row1 ) {
				System.out.print(m[row2--][col2++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}

}
