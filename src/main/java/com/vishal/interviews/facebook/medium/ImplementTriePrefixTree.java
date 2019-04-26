package com.vishal.interviews.facebook.medium;

import com.vishal.interviews.util.TrieNode;

/**
 * 208. Implement Trie (Prefix Tree)
 * 
 * Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
 *
 */
public class ImplementTriePrefixTree {

	TrieNode root;
   /** Initialize your data structure here. */
   public ImplementTriePrefixTree() {
       root = new TrieNode();
   }
   
   /** Inserts a word into the trie. */
   public void insert(String s) {
       TrieNode t = root;
		for(int i = 0; i< s.length();i++){
			char c = s.charAt(i);
			int p = c - 'a';
			if(t.children[p] == null){
				t.children[p] = new TrieNode();
			}
			t = t.children[p];
		}
		t.word = s;
   }
   
   /** Returns if the word is in the trie. */
   public boolean search(String s) {
       TrieNode t = root;
		for(int i = 0; i< s.length();i++){
			char c = s.charAt(i);
			int p = c - 'a';
			if(t.children[p] == null){
				return false;
			}
			t = t.children[p];
		}
		return s.equals(t.word);
   }
   
   /** Returns if there is any word in the trie that starts with the given prefix. */
   public boolean startsWith(String s) {
       TrieNode t = root;
		for(int i = 0; i< s.length();i++){
			char c = s.charAt(i);
			int p = c - 'a';
			if(t.children[p] == null){
				return false;
			}
			t = t.children[p];
		}
		return true;
   }
	

}
