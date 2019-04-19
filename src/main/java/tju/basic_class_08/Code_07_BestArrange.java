package tju.basic_class_08;
import java.util.Arrays;
import java.util.Comparator;
/*
一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目 的宣讲。 给你每一个项目开始的时间和结束的时间(给你一个数组，里面 是一个个具体的项目)，你来安排宣讲的日程，要求会议室进行 的宣讲的场次最多。返回这个最多的宣讲场次。
最大的leftMax与rightMax之差的绝对值
【题目】 给定一个长度为N(N>1)的整型数组arr，
可以划分成左右两个 部分，左部分为arr[0..K]，
右部分为arr[K+1..N-1]，K可以取 值的范围是[0,N-2]。
求这么多划分方案中，左部分中的最大值 减去右部分最大值的绝对值中，
最大是多少? 例如:[2,7,3,1,1]，当左部分为[2,7]，右部分为[3,1,1]时，
 左部分中的最大值减去右部分最大值的绝对值为4。
 当左部分为 [2,7,3]，右部分为[1,1]时，
 左部分中的最大值减去右部分最大 值的绝对值为6。
 还有很多划分方案，但最终返回6。
* */
public class Code_07_BestArrange {
	public static class Program {
		public int start;
		public int end;
		public Program(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	public static class ProgramComparator implements Comparator<Program> {
		@Override
		public int compare(Program o1, Program o2) {
			return o1.end - o2.end;//哪个项目的结束时间小，哪个项目就排在前面。
		}
	}
	//start表示现在的时间点
	public static int bestArrange(Program[] programs, int start) {
		Arrays.sort(programs, new ProgramComparator());
		int result = 0;
		for (int i = 0; i < programs.length; i++) {
			if (start <= programs[i].start) {//依次安排结束时间早的项目
				result++;
				start = programs[i].end;//杀死掉那些已经错过的项目
			}
		}
		return result;
	}
	public static void main(String[] args) {
	}
}
