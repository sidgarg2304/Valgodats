package com.vishal.interviews.veeva;

/**
 * I/P: X-Ray for Chest-1
 * 
 * so in above code form will get X-Ray for Chest-1 I want output as
 * 
 * formOrdinalNumber=1 formName="X-Ray for Chest"
 * 
 * @author vkotha
 *
 */
public class StringConversion {

	public static void main(String[] args) {
		StringConversion s = new StringConversion();
		System.out.println(s.convert("X-Ray for Chest-1"));
	}

	String convert(String s) {
		StringBuilder res = new StringBuilder();

		int lastNum = -1;
		int i = s.length() - 1;
		while (i >= 0) {
			char c = s.charAt(i);
			if (c == '-') {
				lastNum = Integer.parseInt(s.substring(i + 1));
				break;
			}
			i--;
		}

		res.append("formOrdinalNumber=" + lastNum);
		res.append("\n");
		res.append(s.substring(0, i));
		return res.toString();
	}

}
