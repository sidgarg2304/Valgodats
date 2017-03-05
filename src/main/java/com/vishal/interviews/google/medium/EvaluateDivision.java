package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 399. Evaluate Division
 * 
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */
public class EvaluateDivision {

	public static void main(String[] args) {

	}

	/**
	 * Java AC Solution using graph Image a/b = k as a link between node a and b,
	 * the weight from a to b is k, the reverse link is 1/k. Query is to find a
	 * path between two nodes.
	 * 
	 * @param equations
	 * @param values
	 * @param queries
	 * @return
	 */
	public double[] calcEquationUsingGraph(String[][] equations, double[] values, String[][] queries) {
		HashMap<String, ArrayList<String>> pairs = new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<Double>> valuesPair = new HashMap<String, ArrayList<Double>>();
		for (int i = 0; i < equations.length; i++) {
			String[] equation = equations[i];
			if (!pairs.containsKey(equation[0])) {
				pairs.put(equation[0], new ArrayList<String>());
				valuesPair.put(equation[0], new ArrayList<Double>());
			}
			if (!pairs.containsKey(equation[1])) {
				pairs.put(equation[1], new ArrayList<String>());
				valuesPair.put(equation[1], new ArrayList<Double>());
			}
			pairs.get(equation[0]).add(equation[1]);
			pairs.get(equation[1]).add(equation[0]);
			valuesPair.get(equation[0]).add(values[i]);
			valuesPair.get(equation[1]).add(1 / values[i]);
		}

		double[] result = new double[queries.length];
		for (int i = 0; i < queries.length; i++) {
			String[] query = queries[i];
			result[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<String>(), 1.0);
			if (result[i] == 0.0)
				result[i] = -1.0;
		}
		return result;
	}

	private double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs,
			HashMap<String, ArrayList<Double>> values, HashSet<String> set, double value) {
		if (set.contains(start))
			return 0.0;
		if (!pairs.containsKey(start))
			return 0.0;
		if (start.equals(end))
			return value;
		set.add(start);

		ArrayList<String> strList = pairs.get(start);
		ArrayList<Double> valueList = values.get(start);
		double tmp = 0.0;
		for (int i = 0; i < strList.size(); i++) {
			tmp = dfs(strList.get(i), end, pairs, values, set, value * valueList.get(i));
			if (tmp != 0.0) {
				break;
			}
		}
		set.remove(start);
		return tmp;
	}
	
	/**
	 * Java AC solution with explanation
The logic I have used is to construct a Map of maps, that contains all possible a/b and b/a from the given input and their values.

For the given input
equations = [ ["a", "b"], ["b", "c"] ]. values = [2.0, 3.0]

The map that gets constructed is :

[a: [b:2.0]
b: [a:0.5], [c:3.0]
c: [b:0.333]]

For each key in the outer map, the value represents a map, that denotes all possible denominators for the key and the corresponding key/value.

With this map constructed, the logic for evaluating a query is simple in a dfs style:

To find any m/n, if the map of m contains x1, x2, x3
then
m/n = m/x1 * x1/n if this gives a valid result or m/x2 * x2/n or m/x3 * x3/n
	 * @param equations
	 * @param values
	 * @param query
	 * @return
	 */
	public static double[] calcEquationACSolution(String[][] equations, double[] values, String[][] query) {
      Map<String, Map<String, Double>> numMap = new HashMap<>();
      int i = 0;
      for(String[] str : equations) {
          insertPairs(numMap, str[0], str[1], values[i]);
          insertPairs(numMap, str[1], str[0], 1.0/values[i]);
          i++;
      }

      double[] res = new double[query.length];
      i = 0;
      for(String[] q: query) {
          Double resObj = handleQuery(q[0], q[1], numMap, new HashSet<>());
          res[i++] = (resObj != null) ? resObj : -1.0;
      }
      return res;
  }

  public static void insertPairs(Map<String, Map<String, Double>> numMap, String num, String denom, Double value) {
      Map<String, Double> denomMap = numMap.get(num);
      if(denomMap == null) {
          denomMap = new HashMap<>();
          numMap.put(num, denomMap);
      }
      denomMap.put(denom, value);
  }

  public static Double handleQuery(String num, String denom, Map<String, Map<String, Double>> numMap, Set<String> visitedSet) {
      String dupeKey = num+":"+denom;
      if(visitedSet.contains(dupeKey)) return null;
      if(!numMap.containsKey(num) || !numMap.containsKey(denom)) return null;
      if(num.equals(denom)) return 1.0;

      Map<String, Double> denomMap = numMap.get(num);
      visitedSet.add(dupeKey);
      for(String key : denomMap.keySet()) {
          Double res = handleQuery(key, denom, numMap, visitedSet);
          if(res != null) {
              return denomMap.get(key) * res;
          }
      }
      visitedSet.remove(dupeKey);
      return null;
  }
  
  /**
   * Easy
   */
  
	public double[] calcEquationEasy(String[][] equations, double[] values, String[][] query) {
		double[] result = new double[query.length];
		// filter unexpected words
		Set<String> words = new HashSet<>();
		for (String[] strs : equations) {
			words.add(strs[0]);
			words.add(strs[1]);
		}
		for (int i = 0; i < query.length; ++i) {
			String[] keys = query[i];
			if (!words.contains(keys[0]) || !words.contains(keys[1]))
				result[i] = -1.0d;
			else {
				Stack<Integer> stack = new Stack<>();
				result[i] = helper(equations, values, keys, stack);
			}
		}
		return result;
	}

	public double helper(String[][] equations, double[] values, String[] keys, Stack<Integer> stack) {

		// look up equations directly
		for (int i = 0; i < equations.length; ++i) {
			if (equations[i][0].equals(keys[0]) && equations[i][1].equals(keys[1]))
				return values[i];
			if (equations[i][0].equals(keys[1]) && equations[i][1].equals(keys[0]))
				return 1 / values[i];
		}
		// lookup equations by other equations
		//
		for (int i = 0; i < equations.length; ++i) {
			if (!stack.contains(i) && keys[0].equals(equations[i][0])) {
				stack.push(i);
				double temp = values[i] * helper(equations, values, new String[] { equations[i][1], keys[1] }, stack);
				if (temp > 0)
					return temp;
				else
					stack.pop();
			}
			if (!stack.contains(i) && keys[0].equals(equations[i][1])) {
				stack.push(i);
				double temp = helper(equations, values, new String[] { equations[i][0], keys[1] }, stack) / values[i];
				if (temp > 0)
					return temp;
				else
					stack.pop();
			}
		}
		return -1.0d;
	}

}
