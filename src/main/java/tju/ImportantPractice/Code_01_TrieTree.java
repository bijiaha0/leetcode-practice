package tju.ImportantPractice;
//前缀树
public class Code_01_TrieTree {
	public static class TrieNode {
		public int pass;//有多少个节点划过我
		public int end;//我是多少个字符串结尾这个概念
		public TrieNode[] next;//下级的路
		public TrieNode() {
			pass = 0;
			end = 0;
			next = new TrieNode[26];//a-z总共26个
		}
	}
	public static class Trie {
		private TrieNode root;//头
		public Trie() {
			root = new TrieNode();
		}
		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';//0 ~ 25;a-->0,b--->1
				if (node.next[index] == null) {//之前没路
					node.next[index] = new TrieNode();//建路
				}
				node = node.next[index];
				node.pass++;
			}
			node.end++;
		}
		//在前缀树上删除word
		public void delete(String word) {
			if (search(word)!=0) {
				char[] chs = word.toCharArray();
				TrieNode node = root;
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					if (--node.next[index].pass == 0) {
						node.next[index] = null;
						return;
					}
					node = node.next[index];
				}
				node.end--;
			}
		}
		//查询word加入过几次
		public int search(String word) {
			if (word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.next[index] == null) {//中途发生了没路，则表示这个word没有加入过
					return 0;
				}
				node = node.next[index];
			}
			return node.end;//end表示这个word加入过几次
		}

		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.next[index] == null) {
					return 0;
				}
				node = node.next[index];
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
