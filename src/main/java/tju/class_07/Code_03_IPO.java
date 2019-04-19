package tju.class_07;
import java.util.Comparator;
import java.util.PriorityQueue;
/*
* 做项目的最大收益问题
* 给定两个整数W和K，W代表你拥有的初始资金，K代表你最多可以做K个项目。
* */
public class Code_03_IPO {
	public static class Program {
		public int p;
		public int c;
		public Program(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}
	public static class MinCostComparator implements Comparator<Program> {
		@Override
		public int compare(Program o1, Program o2) {
			return o1.c - o2.c;
		}
	}
	public static class MaxProfitComparator implements Comparator<Program> {
		@Override
		public int compare(Program o1, Program o2) {
			return o2.p - o1.p;
		}
	}
	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Costs) {
		Program[] programs = new Program[Profits.length];
		for (int i = 0; i < Profits.length; i++) {
			programs[i] = new Program(Profits[i], Costs[i]);
		}
		PriorityQueue<Program> minCostQ = new PriorityQueue<>(new MinCostComparator());
		PriorityQueue<Program> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
		for (int i = 0; i < programs.length; i++) {
			minCostQ.add(programs[i]);
		}
		for (int i = 1; i <= k; i++) { // 1 ~ k
			while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
				maxProfitQ.add(minCostQ.poll());
			}
			if (maxProfitQ.isEmpty()) {
				return W;
			}
			W += maxProfitQ.poll().p;
		}
		return W;
	}
}
