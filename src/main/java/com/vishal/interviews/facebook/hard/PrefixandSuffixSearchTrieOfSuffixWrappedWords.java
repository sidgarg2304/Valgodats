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


/**
 * Approach #3: Trie of Suffix Wrapped Words [Accepted]
Intuition and Algorithm

Consider the word 'apple'. For each suffix of the word, we could insert that suffix, followed by '#', followed by the word, all into the trie.

For example, we will insert '#apple', 'e#apple', 'le#apple', 'ple#apple', 'pple#apple', 'apple#apple' into the trie. Then for a query like prefix = "ap", suffix = "le", we can find it by querying our trie for le#ap.

Complexity Analysis

Time Complexity: O(NK^2 + QK)O(NK
​2
​​ +QK) where NN is the number of words, KK is the maximum length of a word, and QQ is the number of queries.

Space Complexity: O(NK^2)O(NK
​2
​​ ), the size of the trie.
 * @author vkotha
 *
 */
public class PrefixandSuffixSearchTrieOfSuffixWrappedWords {
	TrieNode trie;
   public PrefixandSuffixSearchTrieOfSuffixWrappedWords(String[] words) {
       trie = new TrieNode();
       for (int weight = 0; weight < words.length; ++weight) {
           String word = words[weight] + "{";
           for (int i = 0; i < word.length(); ++i) {
               TrieNode cur = trie;
               cur.weight = weight;
               for (int j = i; j < 2 * word.length() - 1; ++j) {
                   int k = word.charAt(j % word.length()) - 'a';
                   if (cur.children[k] == null)
                       cur.children[k] = new TrieNode();
                   cur = cur.children[k];
                   cur.weight = weight;
               }
           }
       }
   }
   public int f(String prefix, String suffix) {
       TrieNode cur = trie;
       for (char letter: (suffix + '{' + prefix).toCharArray()) {
           if (cur.children[letter - 'a'] == null) return -1;
           cur = cur.children[letter - 'a'];
       }
       return cur.weight;
   }
   
   private class TrieNode {
      TrieNode[] children;
      int weight;
      public TrieNode() {
          children = new TrieNode[27];
          weight = 0;
      }
   }
}



