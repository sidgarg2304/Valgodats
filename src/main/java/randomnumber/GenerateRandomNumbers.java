package randomnumber;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GenerateRandomNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();

		int  n = rand.nextInt(10) + 1;
		String s = "/vishal/page/sales-by-date";
		Set<String> dic = new HashSet<>();
		dic.add("cat");
		dic.add("dat");
		dic.add("dot");
		dic.add("dog");
		System.out.println(getTheMinimus("cat", "dog", dic));
	}
	
	public static int getTheMinimus(String start,String end,Set<String> dic){
	   Set<String> reached = new HashSet<>();
	    reached.add(start);
	    dic.add(end);
	    int distance = 1;
	    while(!reached.contains(end)){
	      Set<String> add = new HashSet<>();
	      
	      for(String each : reached){ // {cat, cot, pat, sat, dat, dot, dog, pot}
	         for(int i = 0;i < each.length();i++){
	            char[] chars = each.toCharArray();
	           for(char ch = 'a';ch <= 'z';ch++){
	              chars[i] = ch;
	              String word = new String(chars);
	              if(dic.contains(word)){
	                add.add(word);
	                dic.remove(word);
	              }
	           }
	         }
	      }
	      distance++;
	      if(add.size() == 0) return 0;
	      reached = add;
	    }
	    return distance;
	  }

}
