package tju.TrieTree;
//前缀树，p是每次经过都加1，到结尾了e加1
//字符放在路上，而不是放在点上
public class TrieTree {
	public static class Node {
		public int pass; // 这个节点在加字符串的时候到达过多少次
		public int end; // 有多少个字符串是以这个节点结尾的
		public Node[] nexts; // 下级的路  HashMap<Char, Node> map   ('a',XXX)

		public Node() {
			pass = 0;
			end = 0;
			 // next[0] == null 说明没有走向'a'的路
			 // next[0] != null 说明有走向'a'的路
			nexts = new Node[26];
		}
	}

	public static class Trie {
		private Node root;// 头

		public Trie() {
			root = new Node();
		}
		//在前缀树上增加word
		public void insert(String word) {
			if (word == null) {
				return;
			}
			root.pass++;
			char[] chs = word.toCharArray();//单词变成字符类型的数组
			Node cur = root;//根节点
			int index = 0; // 哪条路
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a'; // 0 ~ 25
				if (cur.nexts[index] == null) {//表示当前没有走向index（index对应着一个字母）的路
					cur.nexts[index] = new Node();
				}
				cur = cur.nexts[index];
				cur.pass++;
			}
			cur.end++;
		}
		// 在前缀树上删除word
		public void delete(String word) {
			if (search(word) != 0) {
				root.pass--;
				char[] chs = word.toCharArray();
				Node node = root;
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					if (--node.nexts[index].pass == 0) {//当走到某一个节点的时候，pass变成了0，这个时候不用走了，后续部分直接扔掉。
						node.nexts[index] = null;
						return;
					}
					node = node.nexts[index];
				}
				node.end--;
			}
		}

		// 查询word加入过几次
		public int search(String word) {
			if (word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			Node node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {//中途没有路了
					return 0;
				}
				node = node.nexts[index];
			}
			return node.end;
		}

		// 查询有多少个加入过的字符串以pre开头的
		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			Node node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.pass;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		trie.insert("zuo");
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuoa");
		trie.insert("zuoac");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNumber("zuo"));

	}

}
