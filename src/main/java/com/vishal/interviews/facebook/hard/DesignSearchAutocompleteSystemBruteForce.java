package com.vishal.interviews.facebook.hard;

import java.util.*;


/**
 * 642. Design Search Autocomplete System
 * 
 * Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#'). For each character they type except '#', you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed. Here are the specific rules:

The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
If less than 3 hot sentences exist, then just return as many as you can.
When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
Your job is to implement the following functions:

The constructor function:

AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is historical data. Sentences is a string array consists of previously typed sentences. Times is the corresponding times a sentence has been typed. Your system should record these historical data.

Now, the user wants to input a new sentence. The following function will provide the next character the user types:

List<String> input(char c): The input c is the next character typed by the user. The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). Also, the previously typed sentence should be recorded in your system. The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.


Example:
Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2]) 
The system have already tracked down the following sentences and their corresponding times: 
"i love you" : 5 times 
"island" : 3 times 
"ironman" : 2 times 
"i love leetcode" : 2 times 
Now, the user begins another search: 

Operation: input('i') 
Output: ["i love you", "island","i love leetcode"] 
Explanation: 
There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored. 

Operation: input(' ') 
Output: ["i love you","i love leetcode"] 
Explanation: 
There are only two sentences that have prefix "i ". 

Operation: input('a') 
Output: [] 
Explanation: 
There are no sentences that have prefix "i a". 

Operation: input('#') 
Output: [] 
Explanation: 
The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search. 

Note:
The input sentence will always start with a letter and end with '#', and only one blank space will exist between two words.
The number of complete sentences that to be searched won't exceed 100. The length of each sentence including those in the historical data won't exceed 100.
Please use double-quote instead of single-quote when you write test cases even for a character input.
Please remember to RESET your class variables declared in class AutocompleteSystem, as static/class variables are persisted across multiple test cases. Please see here for more details.
 *
 */

/**
 * Approach #1 Brute Force [Time Limit Exceeded]
In this solution, we make use of a HashMap mapmap which stores entries in the form (sentence_i, times_i)(sentence
​i
​​ ,times
​i
​​ ). Here, times_itimes
​i
​​  refers to the number of times the sentence_isentence
​i
​​  has been typed earlier.

AutocompleteSystem: We pick up each sentence from sentencessentences and their corresponding times from the timestimes, and make their entries in the mapmap appropriately.

input(c): We make use of a current sentence tracker variable, cur_sencur
​s
​​ en, which is used to store the sentence entered till now as the input. For cc as the current input, firstly, we append this cc to cur_sencur
​s
​​ en and then iterate over all the keys of mapmap to check if a key exists whose initial characters match with cur_sencur
​s
​​ en. We add all such keys to a listlist. Then, we sort this listlist as per our requirements, and obtain the first three values from this listlist.
 * 
 * 
 * Performance Analysis

AutocompleteSystem() takes O(k*l)O(k∗l) time. This is because, putting an entry in a hashMap takes O(1)O(1) time. But, to create a hash value for a sentence of average length kk, it will be scanned atleast once. We need to put ll such entries in the mapmap.

input() takes O\big(n+mlog(m)\big)O(n+mlog(m)) time. We need to iterate over the list of sentences, in mapmap, entered till now(say with a count nn), taking O(n)O(n) time, to populate the listlist used for finding the hot sentences. Then, we need to sort the listlist of length mm, taking O\big(mlog(m)\big)O(mlog(m)) time.
 *
 */
public class DesignSearchAutocompleteSystemBruteForce {
	HashMap<String, Integer> map = new HashMap<>();

	class Node {
		Node(String st, int t) {
			sentence = st;
			times = t;
		}

		String sentence;
		int times;
	}

	public DesignSearchAutocompleteSystemBruteForce(String[] sentences, int[] times) {
		for (int i = 0; i < sentences.length; i++)
			map.put(sentences[i], times[i]);
	}

	String cur_sent = "";

	public List<String> input(char c) {
		List<String> res = new ArrayList<>();
		if (c == '#') {
			map.put(cur_sent, map.getOrDefault(cur_sent, 0) + 1);
			cur_sent = "";
		} else {
			List<Node> list = new ArrayList<>();
			cur_sent += c;
			for (String key : map.keySet())
				if (key.indexOf(cur_sent) == 0) {
					list.add(new Node(key, map.get(key)));
				}
			Collections.sort(list, (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
			for (int i = 0; i < Math.min(3, list.size()); i++)
				res.add(list.get(i).sentence);
		}
		return res;
	}
}
