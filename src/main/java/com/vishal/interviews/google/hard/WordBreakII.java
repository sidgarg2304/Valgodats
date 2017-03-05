package com.vishal.interviews.google.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 140. Word Break II
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is a
 * valid dictionary word. You may assume the dictionary does not contain
 * duplicate words.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * 
 * s = "catsanddog",
 * 
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * UPDATE (2017/1/4): The wordDict parameter had been changed to a list of
 * strings (instead of a set of strings). Please reload the code definition to
 * get the latest changes.
 *
 */
public class WordBreakII {

	public static void main(String[] args) {

	}

	/**
	 * My concise JAVA solution based on memorized DFS
	 * 
	 * Explanation
	 * 
	 * Using DFS directly will lead to TLE, so I just used HashMap to save the
	 * previous results to prune duplicated branches, as the following:
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public List<String> wordBreak(String s, Set<String> wordDict) {
		return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
	}

	// DFS function returns an array including all substrings derived from s.
	List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
		if (map.containsKey(s))
			return map.get(s);

		LinkedList<String> res = new LinkedList<String>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
				for (String sub : sublist)
					res.add(word + (sub.isEmpty() ? "" : " ") + sub);
			}
		}
		map.put(s, res);
		return res;
	}

	public List<String> wordBreakConcise(String s, Set<String> dict) {
		List<String> result = new ArrayList<String>();
		for (int j = s.length() - 1; j >= 0; j--) {
			if (dict.contains(s.substring(j)))
				break;
			else {
				if (j == 0)
					return result;
			}
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (dict.contains(s.substring(0, i + 1))) {
				List<String> strs = wordBreak(s.substring(i + 1, s.length()), dict);
				if (strs.size() != 0)
					for (Iterator<String> it = strs.iterator(); it.hasNext();) {
						result.add(s.substring(0, i + 1) + " " + it.next());
					}
			}
		}
		if (dict.contains(s))
			result.add(s);
		return result;
	}

}
