package com.vishal.interviews.google.easy;

import java.util.*;

public class JewelsandStones {

	public static void main(String[] args) {

	}
	
	public int numJewelsInStones(String J, String S) {
      
      Set<Character> jewels = new HashSet<>();
      for(char c : J.toCharArray()) {
          jewels.add(c);
      }
      
      int res = 0;
      for(char c : S.toCharArray()) {
          if(jewels.contains(c)) {
              res++;
          }
      }
      return res;
  }

}
