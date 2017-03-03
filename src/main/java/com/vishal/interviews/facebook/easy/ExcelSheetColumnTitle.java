package com.vishal.interviews.facebook.easy;

/**
 * 168. Excel Sheet Column Title
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 * 1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 *
 */
public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String convertToTitleOneLine(int n) {
		return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
	}
	
	public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
	
	/**
	 * My easy to understand JAVA solution
	 * Instead of 1 -> A, 26 -> Z, we can assume that 0 -> A, 25 -> Z, and then here comes the base 26 representation, 
	 * it's similar when you convert a number from base 10 to base 2
	 */
	
	public String convertToTitle2(int n) {
	    String res = "";
	    while(n != 0) {
	        char ch = (char)((n - 1) % 26 + 65);
	        n = (n - 1) / 26;
	        res = ch + res;
	    }
	    return res;
	}
	

}
