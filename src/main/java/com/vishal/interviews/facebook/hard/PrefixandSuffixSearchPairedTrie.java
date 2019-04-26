package com.vishal.interviews.facebook.hard;

import java.util.*;

/**
 * 745. Prefix and Suffix Search
 * 
 * 
 * Given many words, words[i] has weight i.

Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.

Examples:
Input:
WordFilter(["apple"])
WordFilter.f("a", "e") // returns 0
WordFilter.f("b", "") // returns -1
Note:
words has length in range [1, 15000].
For each test case, up to words.length queries WordFilter.f may be made.
words[i] has length in range [1, 10].
prefix, suffix have lengths in range [0, 10].
words[i] and prefix, suffix queries consist of lowercase letters only.
 *
 *
 *Approach #2: Paired Trie [Accepted]
Intuition and Algorithm

Say we are inserting the word apple. We could insert ('a', 'e'), ('p', 'l'), ('p', 'p'), ('l', 'p'), ('e', 'a') into our trie. Then, if we had equal length queries like prefix = "ap", suffix = "le", we could find the node trie['a', 'e']['p', 'l'] in our trie. This seems promising.

What about queries that aren't equal? We should just insert them like normal. For example, to capture a case like prefix = "app", suffix = "e", we could create nodes trie['a', 'e']['p', None]['p', None].

After inserting these pairs into our trie, our searches are straightforward.

Complexity Analysis

Time Complexity: O(NK^2 + QK)O(NK
​2
​​ +QK) where NN is the number of words, KK is the maximum length of a word, and QQ is the number of queries.

Space Complexity: O(NK^2)O(NK
​2
​​ ), the size of the trie.
 */
public class PrefixandSuffixSearchPairedTrie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	PariedTrieNode trie;
   public PrefixandSuffixSearchPairedTrie(String[] words) {
       trie = new PariedTrieNode();
       int wt = 0;
       for (String word: words) {
           PariedTrieNode cur = trie;
           cur.weight = wt;
           int L = word.length();
           char[] chars = word.toCharArray();
           for (int i = 0; i < L; ++i) {

               PariedTrieNode tmp = cur;
               for (int j = i; j < L; ++j) {
                   int code = (chars[j] - '`') * 27;
                   if (tmp.children.get(code) == null)
                       tmp.children.put(code, new PariedTrieNode());
                   tmp = tmp.children.get(code);
                   tmp.weight = wt;
               }

               tmp = cur;
               for (int k = L - 1 - i; k >= 0; --k) {
                   int code = (chars[k] - '`');
                   if (tmp.children.get(code) == null)
                       tmp.children.put(code, new PariedTrieNode());
                   tmp = tmp.children.get(code);
                   tmp.weight = wt;
               }

               int code = (chars[i] - '`') * 27 + (chars[L - 1 - i] - '`');
               if (cur.children.get(code) == null)
                   cur.children.put(code, new PariedTrieNode());
               cur = cur.children.get(code);
               cur.weight = wt;

           }
           wt++;
       }
   }

   public int f(String prefix, String suffix) {
       PariedTrieNode cur = trie;
       int i = 0, j = suffix.length() - 1;
       while (i < prefix.length() || j >= 0) {
           char c1 = i < prefix.length() ? prefix.charAt(i) : '`';
           char c2 = j >= 0 ? suffix.charAt(j) : '`';
           int code = (c1 - '`') * 27 + (c2 - '`');
           cur = cur.children.get(code);
           if (cur == null) return -1;
           i++; j--;
       }
       return cur.weight;
   }

}

class PariedTrieNode {
   Map<Integer, PariedTrieNode> children;
   int weight;
   public PariedTrieNode() {
       children = new HashMap();
       weight = 0;
   }
}
