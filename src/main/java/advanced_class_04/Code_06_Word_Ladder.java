package advanced_class_04;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
//字符串的转换路径问题
public class Code_06_Word_Ladder {
	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		wordList.add(beginWord);//把beginWord加入到wordList中去
		// 生成邻居表
		HashMap<String, ArrayList<String>> nexts = getNexts(wordList);
		// 从start开始，进行宽度优先遍历，求每一个字符串到start的最短距离
		HashMap<String, Integer> distances = getDistances(beginWord, nexts);
		// 深度优先遍历收集答案
		LinkedList<String> pathList = new LinkedList<>();
		List<List<String>> res = new ArrayList<>();
		getShortestPaths(beginWord, endWord, nexts, distances, pathList, res);
		return res;
	}
	//得到nexts的信息
	public static HashMap<String, ArrayList<String>> getNexts(List<String> words) {
		Set<String> dict = new HashSet<>(words); // list -> set
		// 结果
		HashMap<String, ArrayList<String>> nexts = new HashMap<>();
		// 建立记录，但是不填值
		for (int i = 0; i < words.size(); i++) {
			nexts.put(words.get(i), new ArrayList<>());
		}
		// 对每一个记录，填值
		for (int i = 0; i < words.size(); i++) {
			nexts.put(words.get(i), getNext(words.get(i), dict));
		}
		return nexts;
	}
	//得到单个next的信息
	private static ArrayList<String> getNext(String word, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		char[] chs = word.toCharArray();
		// a~z 都尝试
		for (char cur = 'a'; cur <= 'z'; cur++) {
			// 每个位置都这么尝试
			for (int i = 0; i < chs.length; i++) {
				// 不尝试原始的字符
				if (chs[i] != cur) {
					char tmp = chs[i];
					chs[i] = cur;
					if (dict.contains(String.valueOf(chs))) {
						res.add(String.valueOf(chs));
					}
					chs[i] = tmp;
				}
			}
		}
		return res;
	}

	public static HashMap<String, Integer> getDistances(String begin,
			HashMap<String, ArrayList<String>> nexts) {
		HashMap<String, Integer> distances = new HashMap<>();
		distances.put(begin, 0);
		Queue<String> queue = new LinkedList<String>();
		queue.add(begin);
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			for (String str : nexts.get(cur)) { // str就是cur的具体一个孩子
				if (!distances.containsKey(str)) {
					distances.put(str, distances.get(cur) + 1);
					queue.add(str);
				}
			}
		}
		return distances;
	}

	private static void getShortestPaths(String cur, String end,
			HashMap<String, ArrayList<String>> nexts,
			HashMap<String, Integer> distances, LinkedList<String> solution,
			List<List<String>> res) {
		solution.add(cur);
		if (end.equals(cur)) {
			res.add(new LinkedList<String>(solution));
		} else {
			for (String next : nexts.get(cur)) { // 每一个next都是cur的孩子
				if (distances.get(next) == distances.get(cur) + 1) {
					getShortestPaths(next, end, nexts, distances, solution, res);
				}
			}
		}
		solution.pollLast();
	}

}
