package com.vishal.interviews.facebook.medium;

import java.util.*;
import com.vishal.interviews.util.TrieNode;

public class AddandSearchWordDatastructuredesign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	TrieNode root;
	AddandSearchWordDatastructuredesign(){
		root = new TrieNode();
	}
	
	public void addWord(String word) {
		TrieNode p = root;
		
		for(int i = 0; i< word.length();i++){			
			int pos = word.charAt(i)- 'a';
			if(p.children[pos] == null){
				p.children[pos] = new TrieNode();
			}
			p = p.children[pos];
		}
		p.word = word;			
	}
	
	boolean search(String word){
		return match(word, root, 0);
	}
	
	boolean match(String word, TrieNode t, int s) {

		if (s == word.length()) {
			return t.word != null;
		}

		if (word.charAt(s) != '.') {
			return t.children[word.charAt(s) - 'a'] != null && match(word, t.children[word.charAt(s) - 'a'], s + 1);
		}

		for (int i = 0; i< t.children.length ; i++) {

			if(t.children[i] == null){
				continue;
			}
			if (match(word, t.children[i], s + 1)) {
				return true;
			}

		}

		return false;

	}

}
