package com.algorithm.week06;

public class LeetCode_208_0100 {
  class TrieNode{
    TrieNode[] child;//记录孩子节点
    boolean is_end;//记录当前节点是不是一个单词的结束字母
    public TrieNode(){//
      child = new TrieNode[26];
      is_end = false;
    }
  }
  class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
      root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
      TrieNode ptr = root;
      for(int i = 0;i < word.length();i++){
        char c = word.charAt(i);//对于每个单词
        if(ptr.child[c - 'a'] == null){//如果c - 'a'为空，说明还没有存入
          ptr.child[c - 'a'] = new TrieNode();//存入节点
        }
        ptr = ptr.child[c - 'a'];//指向当前节点
      }
      ptr.is_end = true;//最后的节点为单词的最后一个单词，is_end设置为true
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
      TrieNode ptr = root;
      for(int i = 0;i < word.length();i++){
        char c = word.charAt(i);//对于每个字母
        if(ptr.child[c - 'a'] == null){//如果不存在于前缀树中，返回false
          return false;
        }
        ptr = ptr.child[c - 'a'];
      }
      return ptr.is_end;//如果所有字符都在前缀树中，那么判断最后一个字母结束标志是否为true，
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
      TrieNode ptr = root;
      for(int i = 0;i < prefix.length();i++){
        char c = prefix.charAt(i);//对于每个字母
        if(ptr.child[c - 'a'] == null){//如果不存在于前缀树中，返回false
          return false;
        }
        ptr = ptr.child[c - 'a'];
      }
      return true;
    }
  }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

}
