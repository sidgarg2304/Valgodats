package com.vishal.interviews.uber.medium;

import java.util.*;

public class EvaluateDivision {

	public static void main(String[] args) {

	}

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

		double[] res = new double[queries.length];

		Map<String, List<String>> eqMap = new HashMap<>();
		Map<String, List<Double>> valuesMap = new HashMap<>();

		for (int i = 0; i < equations.length; i++) {
			if (!eqMap.containsKey(equations[i][0])) {
				eqMap.put(equations[i][0], new ArrayList<>());
				valuesMap.put(equations[i][0], new ArrayList<>());
			}
			eqMap.get(equations[i][0]).add(equations[i][1]);
			valuesMap.get(equations[i][0]).add(values[i]);

			if (!eqMap.containsKey(equations[i][1])) {
				eqMap.put(equations[i][1], new ArrayList<>());
				valuesMap.put(equations[i][1], new ArrayList<>());
			}
			eqMap.get(equations[i][1]).add(equations[i][0]);
			valuesMap.get(equations[i][1]).add(1.0 / values[i]);
		}

		for (int i = 0; i < queries.length; i++) {
			Set<String> visited = new HashSet<>();
			visited.add(queries[i][0]);
			res[i] = dfs(queries[i][0], queries[i][1], 1.0, eqMap, valuesMap, visited);
		}
		return res;
	}

	double dfs(String st, String en, double curVal, Map<String, List<String>> eqMap, Map<String, List<Double>> valuesMap,
			Set<String> visited) {

		if (!eqMap.containsKey(st)) {
			return -1.0;
		}
        
		if (en.equals(st)) {
			return curVal;
		}								
		
		List<String> neighbors = eqMap.get(st);		
		for(int i = 0; i< neighbors.size(); i++) {
			String ne = neighbors.get(i);	
			if(visited.contains(ne)) {
				continue;
			}
			visited.add(ne);
			double newVal = valuesMap.get(st).get(i);			
			double curRes = dfs(ne, en, curVal * newVal, eqMap, valuesMap, visited);
			if(curRes != -1.0) {
				return curRes;
			}
			visited.remove(ne);
		}
					
		
		return -1.0;
	}

}
