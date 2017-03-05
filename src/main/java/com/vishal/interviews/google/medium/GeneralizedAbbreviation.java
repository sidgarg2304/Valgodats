package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 320. Generalized Abbreviation
 * 
 * Write a function to generate the generalized abbreviations of a word.
 * 
 * Example: Given word = "word", return the following list (order does not
 * matter):
 * 
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1",
 * "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */
public class GeneralizedAbbreviation {

	public static void main(String[] args) {
	}

	/**
	 * Java backtracking solution
	 * 
	 * The idea is: for every character, we can keep it or abbreviate it. To keep
	 * it, we add it to the current solution and carry on backtracking. To
	 * abbreviate it, we omit it in the current solution, but increment the
	 * count, which indicates how many characters have we abbreviated. When we
	 * reach the end or need to put a character in the current solution, and
	 * count is bigger than zero, we add the number into the solution.
	 * 
	 * @param word
	 * @return
	 */
	public List<String> generateAbbreviationsBackTracking(String word) {
		List<String> ret = new ArrayList<String>();
		backtrack(ret, word, 0, "", 0);

		return ret;
	}

	private void backtrack(List<String> ret, String word, int pos, String cur, int count) {
		if (pos == word.length()) {
			if (count > 0)
				cur += count;
			ret.add(cur);
		} else {
			backtrack(ret, word, pos + 1, cur, count + 1);
			backtrack(ret, word, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
		}
	}

	/**
	 * Java 14ms beats 100% For each char c[i], either abbreviate it or not.
	 * 
	 * Abbreviate: count accumulate num of abbreviating chars, but don't append
	 * it yet.
	 * 
	 * Not Abbreviate: append accumulated num as well as current char c[i].
	 * 
	 * In the end append remaining num.
	 * 
	 * Using StringBuilder can decrease 36.4% time.
	 * 
	 * This comes to the pattern I find powerful:
	 * 
	 * int len = sb.length(); // decision point
	 * 
	 * ... backtracking logic ...
	 * 
	 * sb.setLength(len); // reset to decision point
	 * 
	 * @param word
	 * @return
	 */
	public List<String> generateAbbreviationsSol2(String word) {
		List<String> res = new ArrayList<>();
		DFS(res, new StringBuilder(), word.toCharArray(), 0, 0);
		return res;
	}

	public void DFS(List<String> res, StringBuilder sb, char[] c, int i, int num) {
		int len = sb.length();
		if (i == c.length) {
			if (num != 0)
				sb.append(num);
			res.add(sb.toString());
		} else {
			DFS(res, sb, c, i + 1, num + 1); // abbr c[i]

			if (num != 0)
				sb.append(num); // not abbr c[i]
			DFS(res, sb.append(c[i]), c, i + 1, 0);
		}
		sb.setLength(len);
	}
	
	public List<String> generateAbbreviationsEasy(String word) {
      List<String> res = new ArrayList<String>();
      int len = word.length();
      res.add(len==0 ? "" : String.valueOf(len));
      for(int i = 0 ; i < len ; i++)
          for(String right : generateAbbreviationsEasy(word.substring(i+1))){
              String leftNum = i > 0 ? String.valueOf(i) : "";
              res.add( leftNum + word.substring(i,i + 1) + right );
          }
      return res;
  }
}

class GeneralizedAbbreviationSolutionLong {
   public List<String> generateAbbreviations(String word) {
       List<String> res = new LinkedList<>();
       recurse(res, word, 0);
       return res;
   }
   private void recurse(List<String> res, String word, int pos){
       if(pos==word.length()){ 
       	res.add(word);
       	return;
       	}
       /* The current position does not abbreviate to 1 and call the recursion with the next position */

       recurse(res, word, pos+1);
       String nstring = word.substring(0,pos)+"1"+word.substring(pos+1);

     /* Abbreviate the current position and we have to check the position prior to this position.
      If the position prior to this position is a number, we have to combine them together. 
     But there is still a little tricky to deal with the output because if the combined output is 
     those 9, 99, 999, then the next position should be pos+1 with recursion call. If not,
    the next position should remain the same pos. */

       if(pos>0 && Character.isDigit(word.charAt(pos-1))){
           int count = 0;

          /*count the prior characters which is digits and we should combine them with 1 */

           while((pos-count-1)>=0 && Character.isDigit(word.charAt(pos-count-1))){
               count++;
           }
           int num = Integer.parseInt(word.substring(pos-count, pos));
           num = num+1;
           String nnum = num+"";
           if(nnum.length()>count){
               nstring = word.substring(0, pos-count)+nnum+word.substring(pos+1);
               recurse(res, nstring, pos+1);
           }else{
               nstring = word.substring(0, pos-count)+nnum+word.substring(pos+1);
               recurse(res, nstring, pos);
           }
       }else{
           recurse(res, nstring, pos+1);
       }
   }
}
