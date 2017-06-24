package com.vishal.interviews.programcreek.math;

public class AddDigits {

	public static void main(String[] args) {

	}
	
	public int addDigits(int num) {
		
		if(num < 10){
			return num;
		}
    
		String s = String.valueOf(num);
		
		int sum = 0;
		for(int i = 0; i< s.length(); i++){
			sum += s.charAt(i) - '0';
		}
				
		
		return addDigits(sum);
   }

}
