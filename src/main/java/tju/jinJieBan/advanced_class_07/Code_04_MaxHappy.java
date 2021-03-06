package tju.jinJieBan.advanced_class_07;
//某公司要举办一次晚会，每个参加晚会的人都不希望见到自己的直接上
//司，每个人有自己的活跃度，和上下级的关系，
//求邀请哪些人能使晚会的活跃度最大，最后返回活跃度即可。
//例子:给定一个矩阵， 18
//19
//1 10
//第0个数组为[1,8]，表示0号员工的直接上级是1号员工，活跃度是8 第1个数组为[1,9]，表示1号员工的直接上级是1号员工(大老板，头节 点)，活跃度是9 第2个数组为[1,10]，表示2号员工的直接上级是1号员工，活跃度是10
//为了使气氛最活跃，应该1不来，0和2来，活跃度为18，返回18
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

	public static void main(String[] args) {
		int[][] matrix = { { 1, 8 }, { 1, 9 }, { 1, 10 } };
		System.out.println(maxHappy(matrix));
	}
}
