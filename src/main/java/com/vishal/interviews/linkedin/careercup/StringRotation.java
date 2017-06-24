package com.vishal.interviews.linkedin.careercup;

/**
 * String Rotation. Given two string check if String1 is rotating match for String2


# Given two strings. Write a function that will return true if one string is a rotation of the other string.
# e.g. 'bca' and 'cab' are rotations of 'abc' and the function should return true
# 'barbazfoo', 'oobarbazf' and 'rbazfooba' are rotations of 'foobarbaz'

def is_rotation(string1, string2):
 *
 */
public class StringRotation {

	public static void main(String[] args) {

		System.out.println(isStringRotation("bca","cab"));
		System.out.println(isStringRotation("bca","bac"));
	}
	
	static boolean isStringRotation(String a, String b){
		return (a + a).contains(b);
	}

}
