package com.vishal.interviews.facebook.easy;

public class RepeatedStringMatch {

	public static void main(String[] args) {

	}
	
	public int repeatedStringMatch(String a, String b) {
		String as = a;
		for(int rep = 1; rep <= b.length()/a.length() + 2; rep++){			
			if(as.indexOf(b) != -1){
				return rep;
			}
			as += a;
		}
		return -1;
	}

}
