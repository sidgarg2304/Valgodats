package com.vishal.interviews.facebook.medium;

import java.util.*;
/**
 * 640. Solve the Equation
 * 
 * Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.

If there is no solution for the equation, return "No solution".

If there are infinite solutions for the equation, return "Infinite solutions".

If there is exactly one solution for the equation, we ensure that the value of x is an integer.

Example 1:
Input: "x+5-3+x=6+x-2"
Output: "x=2"
Example 2:
Input: "x=x"
Output: "Infinite solutions"
Example 3:
Input: "2x=x"
Output: "x=0"
Example 4:
Input: "2x+3x-6x=x+2"
Output: "x=-1"
Example 5:
Input: "x=x+2"
Output: "No solution"

 *
 */
public class SolvetheEquation {

	public static void main(String[] args) {

	}
	
	public String solveEquationLikeCalculator(String equation) {

		if (equation == null || equation.length() == 0) {
			return "";
		}

		int side = 1;
		int xCoEff = 0;
		int val = 0;

		int sign = 1;		
		equation = equation.replaceAll("\\s", "");

		int i = 0;
		while (i < equation.length()) {
			char c = equation.charAt(i);

			if (c == '=') {
				side = -1;
				sign = 1;
				i++;
			} else if (c == 'x') {
				xCoEff += side * sign;
				i++;
			} else if (Character.isDigit(c)) {
				int en = i;
				int curVal = 0;
				while (en < equation.length() && Character.isDigit(equation.charAt(en))) {
					curVal *= 10;
					curVal += equation.charAt(en) - '0';
					en++;
				}
				if (en < equation.length() && equation.charAt(en) == 'x') {
					en++;
					xCoEff += curVal * side * sign;
				} else {
					val += sign * side * curVal;
				}
				i = en;
			} else {
				sign = c == '-' ? -1 : 1;
				i++;
			}
		}
		
		if (xCoEff == 0 && val != 0) {
			return "No solution";
		}
		if (xCoEff == 0 && val == 0) {
			return "Infinite solutions";
		}

		val = val / xCoEff;
		return "x=" + String.valueOf(val * (-1));
	}
	
	/**
	 * Approach #1 Partioning Coefficients [Accepted]
In the current approach, we start by splitting the given equationequation based on = sign. This way, we've separated the left and right hand side of this equation. Once this is done, we need to extract the individual elements(i.e. x's and the numbers) from both sides of the equation. To do so, we make use of breakIt function, in which we traverse over the given equation(either left hand side or right hand side), and put the separated parts into an array.

Now, the idea is as follows. We treat the given equation as if we're bringing all the x's on the left hand side and all the rest of the numbers on the right hand side as done below for an example.

x+5-3+x=6+x-2

x+x-x=6-2-5+3

Thus, every x in the left hand side of the given equation is treated as positive, while that on the right hand side is treated as negative, in the current implementation.

Likewise, every number on the left hand side is treated as negative, while that on the right hand side is treated as positive. Thus, by doing so, we obtain all the x's in the new lhslhs and all the numbers in the new rhsrhs of the original equation.

Further, in case of an x, we also need to find its corresponding coefficients in order to evaluate the final effective coefficient of x on the left hand side. We also evaluate the final effective number on the right hand side as well.

Now, in case of a unique solution, the ratio of the effective rhsrhs and lhslhs gives the required result. In case of infinite solutions, both the effective lhslhs and rhsrhs turns out to be zero e.g. x+1=x+1. In case of no solution, the coefficient of x(lhslhs) turns out to be zero, but the effective number on the rhsrhs is non-zero.
	 * @param x
	 * @return
	 */
	
	public String coeff(String x) {
      if (x.length() > 1 && x.charAt(x.length() - 2) >= '0' && x.charAt(x.length() - 2) <= '9')
          return x.replace("x", "");
      return x.replace("x", "1");
  }
  public String solveEquationPartioningCoefficients(String equation) {
      String[] lr = equation.split("=");
      int lhs = 0, rhs = 0;
      for (String x: breakIt(lr[0])) {
          if (x.indexOf("x") >= 0) {
              lhs += Integer.parseInt(coeff(x));
          } else
              rhs -= Integer.parseInt(x);
      }
      for (String x: breakIt(lr[1])) {
          if (x.indexOf("x") >= 0)
              lhs -= Integer.parseInt(coeff(x));
          else
              rhs += Integer.parseInt(x);
      }
      if (lhs == 0) {
          if (rhs == 0)
              return "Infinite solutions";
          else
              return "No solution";
      }
      return "x=" + rhs / lhs;
  }
  public List < String > breakIt(String s) {
      List < String > res = new ArrayList < > ();
      String r = "";
      for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) == '+' || s.charAt(i) == '-') {
              if (r.length() > 0)
                  res.add(r);
              r = "" + s.charAt(i);
          } else
              r += s.charAt(i);
      }
      res.add(r);
      return res;
  }
  
  /**
   * Approach #2 Using regex for spliting [Accepted]
Algorithm

In the last approach, we made use of a new function breakIt to obtain the individual components of either the left hand side or the right hand side. Instead of doing so, we can also make use of splitting based on + or - sign, to obtain the individual elements. The rest of the process remains the same as in the last approach.

In order to do the splitting, we make use of an expression derived from regular expressions(regex). Simply speaking, regex is a functionality used to match a target string based on some given criteria. The ?=n quantifier, in regex, matches any string that is followed by a specific string nn. What it's saying is that the captured match must be followed by nn but the nn itself isn't captured.

By making use of this kind of expression in the split functionality, we make sure that the partitions are obtained such that the + or - sign remains along with the parts(numbers or coefficients) even after the splitting.
   */
  
  public String coeff2(String x) {
     if (x.length() > 1 && x.charAt(x.length() - 2) >= '0' && x.charAt(x.length() - 2) <= '9')
         return x.replace("x", "");
     return x.replace("x", "1");
 }
 public String solveEquationUsingRegex(String equation) {
     String[] lr = equation.split("=");
     int lhs = 0, rhs = 0;
     for (String x: lr[0].split("(?=\\+)|(?=-)")) {
         if (x.indexOf("x") >= 0) {

             lhs += Integer.parseInt(coeff(x));
         } else
             rhs -= Integer.parseInt(x);
     }
     for (String x: lr[1].split("(?=\\+)|(?=-)")) {
         if (x.indexOf("x") >= 0)
             lhs -= Integer.parseInt(coeff(x));
         else
             rhs += Integer.parseInt(x);
     }
     if (lhs == 0) {
         if (rhs == 0)
             return "Infinite solutions";
         else
             return "No solution";
     } else
         return "x=" + rhs / lhs;
 }
	
	/**
	 * Concise Java Solution
	 * @param equation
	 * @return
	 */
	public String solveEquation(String equation) {
	    int[] res = evaluateExpression(equation.split("=")[0]),  
	  	  res2 = evaluateExpression(equation.split("=")[1]);
	    res[0] -= res2[0];
	    res[1] = res2[1] - res[1];
	    if (res[0] == 0 && res[1] == 0) return "Infinite solutions";
	    if (res[0] == 0) return "No solution";
	    return "x=" + res[1]/res[0];
	}  

	public int[] evaluateExpression(String exp) {
	    String[] tokens = exp.split("(?=[-+])"); 
	    int[] res =  new int[2];
	    for (String token : tokens) {
	        if (token.equals("+x") || token.equals("x")) res[0] += 1;
		else if (token.equals("-x")) res[0] -= 1;
		else if (token.contains("x")) res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
		else res[1] += Integer.parseInt(token);
	    }
	    return res;
	}
	

}
