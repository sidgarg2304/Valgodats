package com.vishal.algorithms.maths.number;

public class NumbersCountAlgorithms {

	public static void main(String[] args) {
		testFindMissingPositiveInteger();
	}
	
	public static void testFindMissingPositiveInteger(){
		int [] a = {1,2,-1,4};
		
		System.out.println(findMissingPositiveInteger(a));
	}
	
	//find missing positive number in the sequence 1 to n
	public static int findMissingPositiveInteger(int [] a){
		
		for(int i = 0;i<a.length;i++){
			
			while(a[i] != i+1){				
				if(a[i] <=0 || a[i] >= a.length){
					break;
				}				
				
				int temp = a[i];
				a[i] = a[temp-1];
				a[temp-1] = temp;
			}
			
		}
		
		for(int i = 0; i< a.length;i++){
			if(a[i] != i+1){
				return i+1;
			}
		}
		
		return -1;
	}

}
