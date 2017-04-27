package com.vishal.interviews.util;

public class TrieNode {

	public String word;
	public TrieNode[] children;
	
	public TrieNode(){
		children = new TrieNode[26];
	}
}
