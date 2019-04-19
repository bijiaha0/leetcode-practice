package advanced_class_04;

import java.util.List;
//最大快乐值
public class Code_04_MaxHappy {
	public static int maxHappy(int[][] matrix) {
		int[][] dp = new int[matrix.length][2];
		boolean[] visited = new boolean[matrix.length];
		int root = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (i == matrix[i][0]) {
				root = i;
			}
		}
		process(matrix, dp, visited, root);
		return Math.max(dp[root][0], dp[root][1]);
	}

	public static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
		visited[root] = true;
		dp[root][1] = matrix[root][1];
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == root && !visited[i]) {
				process(matrix, dp, visited, i);
				dp[root][1] += dp[i][0];
				dp[root][0] += Math.max(dp[i][1], dp[i][0]);
			}
		}
	}
	
	
	
	public static class Node{
		public int happy;
		
		public List<Node> nexts;
	}
	
	
	public static int getMaxHappy(Node head) {
		ReturnType data = process(head);
		return Math.max(data.bu_lai_max_happy, data.lai_max_happy);
	}
	
	
	public static class ReturnType{
		public int lai_max_happy;
		public int bu_lai_max_happy;
		
		public ReturnType(int lai_max_happy, int bu_lai_max_happy) {
			this.lai_max_happy = lai_max_happy;
			this.bu_lai_max_happy= bu_lai_max_happy;
		}
	}
	
	public static ReturnType process(Node x) {
		if(x.nexts.isEmpty()) {
			return new ReturnType(x.happy, 0);
		}
		int lai = x.happy;
		int bu_lai = 0;
		for(Node next : x.nexts) {
			ReturnType nextData = process(next);
			lai += nextData.bu_lai_max_happy;
			bu_lai+= Math.max(nextData.bu_lai_max_happy, nextData.lai_max_happy);
		}	
		return new ReturnType(lai, bu_lai);
	}
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		int[][] matrix = { { 1, 8 }, { 1, 9 }, { 1, 10 } };
		System.out.println(maxHappy(matrix));
	}
}
