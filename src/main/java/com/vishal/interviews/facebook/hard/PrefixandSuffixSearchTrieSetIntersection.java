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
 */

/**
 * Approach #1: Trie + Set Intersection [Time Limit Exceeded]
Intuition and Algorithm

We use two tries to separately find all words that match the prefix, plus all words that match the suffix. Then, we try to find the highest weight element in the intersection of these sets.

Of course, these sets could still be large, so we might TLE if we aren't careful.
 *
 *
 *Complexity Analysis

Time Complexity: O(NK + Q(N+K))O(NK+Q(N+K)) where NN is the number of words, KK is the maximum length of a word, and QQ is the number of queries. If we use memoization in our solution, we could produce tighter bounds for this complexity, as the complex queries are somewhat disjoint.

Space Complexity: O(NK)O(NK), the size of the tries.
 */
public class PrefixandSuffixSearchTrieSetIntersection {

	public static void main(String[] args) {

	}
	
	TrieNodeCurrent trie1, trie2;
   public PrefixandSuffixSearchTrieSetIntersection(String[] words) {
       trie1 = new TrieNodeCurrent();
       trie2 = new TrieNodeCurrent();
       int wt = 0;
       for (String word: words) {
           char[] ca = word.toCharArray();

           TrieNodeCurrent cur = trie1;
           cur.weight.add(wt);
           for (char letter: ca) {
               if (cur.children[letter - 'a'] == null)
                   cur.children[letter - 'a'] = new TrieNodeCurrent();
               cur = cur.children[letter - 'a'];
               cur.weight.add(wt);
           }

           cur = trie2;
           cur.weight.add(wt);
           for (int j = ca.length - 1; j >= 0; --j) {
               char letter = ca[j];
               if (cur.children[letter - 'a'] == null)
                   cur.children[letter - 'a'] = new TrieNodeCurrent();
               cur = cur.children[letter - 'a'];
               cur.weight.add(wt);
           }
           wt++;
       }
   }

   public int f(String prefix, String suffix) {
       TrieNodeCurrent cur1 = trie1, cur2 = trie2;
       for (char letter: prefix.toCharArray()) {
           if (cur1.children[letter - 'a'] == null) return -1;
           cur1 = cur1.children[letter - 'a'];
       }
       char[] ca = suffix.toCharArray();
       for (int j = ca.length - 1; j >= 0; --j) {
           char letter = ca[j];
           if (cur2.children[letter - 'a'] == null) return -1;
           cur2 = cur2.children[letter - 'a'];
       }

       int ans = -1;
       for (int w1: cur1.weight)
           if (w1 > ans && cur2.weight.contains(w1))
               ans = w1;

       return ans;
   }

}

class TrieNodeCurrent{
	TrieNodeCurrent[] children;
   Set<Integer> weight;
   public TrieNodeCurrent() {
       children = new TrieNodeCurrent[26];
       weight = new HashSet();
   }
}
