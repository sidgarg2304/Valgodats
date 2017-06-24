package com.vishal.interviews.util;

import java.util.List;

public class NestedInteger {

	public int val;
	public List<NestedInteger> nestedIntegers;
	
	public boolean isInteger(){
		return nestedIntegers == null || nestedIntegers.isEmpty();
	}
}
