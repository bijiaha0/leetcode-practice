package Amazon.WordSquares;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bijh@tsingyun.net
 * @date 2020/9/16 3:16 PM
 *
 *
 * DFS back tracking + Trie
 * DFS+Trie，老顽童老师讲的标准的TrieNode结构：Map<Character, TrieNode> children
 */
public class Solution2 {

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if(words==null || words.length==0){
            return res;
        }

        //1.initialize words dictionary Trie
        Trie dictionary = new Trie(words);

        //2.dfs back tracking build result
        int len = words[0].length();

        for(String word: words){
            List<String> curComb = new ArrayList<>();
            curComb.add(word);
            dfs(curComb, res, len, dictionary);
            curComb.remove(curComb.size()-1);
        }
        return res;
    }

    private void dfs(List<String> curComb, List<List<String>> res, int len, Trie dict){
        if(curComb.size() == len){
            res.add(new ArrayList<>(curComb));//pay attention! DFS add here should be DEEP COPY, otherwise curComb is keeping adding and removing, modifying by reference will make elements in res empty!
            return;
        }
        //当前curComb中的单词是已经拼好的几个词，通过curComb中的单词来build前缀，取每个单词的第index位组成前缀，where index = curComb.size()。because we are going to find the words based on the words currently exist in the curComb
        int index = curComb.size();
        // System.out.println("curComb: "+curComb);
        StringBuilder prefSB = new StringBuilder();
        for(String s: curComb){
            prefSB.append(s.charAt(index));
        }
        List<String> startWith = dict.searchPrefix(prefSB.toString());
        // System.out.println("prefix: "+ prefSB.toString() + " : "+startWith);
        for(String sw : startWith){
            curComb.add(sw);
            dfs(curComb, res, len, dict);
            curComb.remove(curComb.size()-1);
        }
    }

    class TrieNode {
        char val;
        Map<Character, TrieNode> children;
        boolean isWord;
        List<String> startWith;
        public TrieNode(char val){
            this.val = val;
            this.isWord = false;
            this.children = new HashMap<>();
            this.startWith = new ArrayList<>();
        }
        public TrieNode(){//for dummy node -- root
            this.isWord = false;
            this.children = new HashMap<>();
            this.startWith = new ArrayList<>();
        }
    }

    class Trie {

        private TrieNode root;

        /**
         * Initialize Trie with word dictionary
         */
        public Trie(String[] words){
            this.root = new TrieNode();
            for(String word: words){
                insert(word);
            }
        }

        private void insert(String word){
            TrieNode cur = this.root;
            Map<Character, TrieNode> curChildren = this.root.children;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(!curChildren.containsKey(c)){
                    TrieNode newNode = new TrieNode(c);
                    curChildren.put(c, newNode);
                }
                cur = curChildren.get(c);
                cur.startWith.add(word);//Used when prefix is found in Trie, return all words that start with the prefix. Save time when find the prefix and then get all words.
                curChildren = cur.children;
            }
            cur.isWord = true;
        }

        /**
         * Search if prefix exists in Trie,
         *  if exists, return all words with that prefix
         */
        public List<String> searchPrefix(String prefix){
            List<String> res = new ArrayList<>();
            TrieNode cur = root;
            Map<Character, TrieNode> curChildren = root.children;
            for(int i=0; i<prefix.length(); i++){
                char p = prefix.charAt(i);
                if(!curChildren.containsKey(p)){
                    return res;
                }else{
                    cur = curChildren.get(p);
                    curChildren = cur.children;
                }
            }
            res.addAll(cur.startWith);

            return res;
        }
    }













}
