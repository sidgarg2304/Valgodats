package com.vishal.interviews.salesforce;

public class FirstNonRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(firstNonRepeatingChar(new char[]{'a', 'a', 'b', 'c', 'A'}));
		System.out.println(firstNonRepeatingChar(new char[]{'a', 'a', 'b', 'c', 'b'}));

	}

	static char firstNonRepeatingChar(char[] arr) {
		
		int[] cnt = new int[256];
		
		for(int i = 0; i< arr.length; i++){
			cnt[arr[i]]++;
		}
				
		for(int i = 0; i< arr.length; i++){
			if(cnt[arr[i]] == 1){
				return arr[i];
			}
		}
		return ' ';
	}

}
