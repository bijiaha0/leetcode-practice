package Amazon.AddAndSearchWord;

/**
 * https://www.jiuzhang.com/solution/add-and-search-word/
 */
class TrieNode {

    public TrieNode[] children;
    public boolean hasWord;

    public TrieNode() {

        children = new TrieNode[26];

        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }

        hasWord = false;

    }

}

/**
 * 设计一个包含下面两个操作的数据结构：addWord(word), search(word)。
 *
 * addWord(word)会在数据结构中添加一个单词。
 *
 * search(word)则支持普通的单词查询或是只包含.和a-z的简易正则表达式的查询。一个.可以代表一个任何的字母。
 *
 */
public class WordDictionary {

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode now = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (now.children[c - 'a'] == null) {
                now.children[c - 'a'] = new TrieNode();
            }
            now = now.children[c - 'a'];
        }

        now.hasWord = true;

    }

    boolean find(String word, int index, TrieNode now) {

        if (index == word.length()) {
            return now.hasWord;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (int i = 0; i < 26; ++i) {
                if (now.children[i] != null) {
                    if (find(word, index + 1, now.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else if (now.children[c - 'a'] != null) {
            return find(word, index + 1, now.children[c - 'a']);
        } else {
            return false;
        }
    }

    public boolean search(String word) {
        return find(word, 0, root);
    }



}

