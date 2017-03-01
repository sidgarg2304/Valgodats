package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 271. Encode and Decode Strings
 * 
 * Design an algorithm to encode a list of strings to a string. The encoded
 * string is then sent over the network and is decoded back to the original list
 * of strings.
 * 
 * Machine 1 (sender) has the function:
 * 
 * string encode(vector<string> strs) {
 * 
 * // ... your code
 * 
 * return encoded_string;
 * 
 * }
 * 
 * Machine 2 (receiver) has the function:
 * 
 * vector<string> decode(string s) {
 * 
 * //... your code
 * 
 * return strs;
 * 
 * }
 * 
 * So Machine 1 does:
 * 
 * string encoded_string = encode(strs);
 * 
 * and Machine 2 does:
 * 
 * vector<string> strs2 = decode(encoded_string);
 * 
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 * 
 * Implement the encode and decode methods.
 * 
 * Note:
 * 
 * 1. The string may contain any possible characters out of 256 valid ascii
 * characters. Your algorithm should be generalized enough to work on any
 * possible characters.
 * 
 * 2. Do not use class member/global/static variables to store states. Your
 * encode and decode algorithms should be stateless.
 * 
 * 3. Do not rely on any library method such as eval or serialize methods. You
 * should implement your own encode/decode algorithm.
 */
public class EncodeandDecodeStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class CodecACSolution {

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s.length()).append('/').append(s);
		}
		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> ret = new ArrayList<String>();
		int i = 0;
		while (i < s.length()) {
			int slash = s.indexOf('/', i);
			int size = Integer.valueOf(s.substring(i, slash));
			ret.add(s.substring(slash + 1, slash + size + 1));
			i = slash + size + 1;
		}
		return ret;
	}
}

/**
 * Double any hashes inside the strings, then use standalone hashes (surrounded
 * by spaces) to mark string endings. For example:
 * 
 * {"abc", "def"} => "abc # def # "
 * 
 * {'abc', '#def'} => "abc # ##def # "
 * 
 * {'abc##', 'def'} => "abc#### # def # "
 * 
 * For decoding, just do the reverse: First split at standalone hashes, then
 * undo the doubling in each string.
 * 
 */
class CodecWithEscaping {
	public String encode(List<String> strs) {
		StringBuffer out = new StringBuffer();
		for (String s : strs)
			out.append(s.replace("#", "##")).append(" # ");
		return out.toString();
	}

	public List<String> decode(String s) {
		List<String> strs = new ArrayList<>();
		String[] array = s.split(" # ", -1);
		for (int i = 0; i < array.length - 1; ++i)
			strs.add(array[i].replace("##", "#"));
		return strs;
	}
}

/**
 * with streaming:
 *
 */
class CodecWithstreaming {
	public String encode(List<String> strs) {
		return strs.stream().map(s -> s.replace("#", "##") + " # ").collect(Collectors.joining());
	}

	public List<String> decode(String s) {
		List<String> strs = Stream.of(s.split(" # ", -1)).map(t -> t.replace("##", "#")).collect(Collectors.toList());
		strs.remove(strs.size() - 1);
		return strs;
	}
}

/**
 * Java solution, pretty straight-forward
 */
class CodecStraightForward {
	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		return strs.stream().map(s -> s.replace("/", "//").replace("*", "/*") + "*").collect(Collectors.joining());
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> res = new ArrayList<>();
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '/') {
				str.append(s.charAt(++i));
			} else if (s.charAt(i) == '*') {
				res.add(str.toString());
				str.setLength(0);
			} else {
				str.append(s.charAt(i));
			}
		}

		return res;
	}
}
