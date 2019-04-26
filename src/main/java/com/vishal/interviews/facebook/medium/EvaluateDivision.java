package com.vishal.interviews.facebook.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		Map<String, List<String>> adjMap = new HashMap<>();
		Map<String, List<Double>> adjValuesMap = new HashMap<>();

		for (int i = 0; i < equations.length; i++) {
			String[] eq = equations[i];
			if (adjMap.get(eq[0]) == null) {
				adjMap.put(eq[0], new ArrayList<>());
				adjValuesMap.put(eq[0], new ArrayList<>());
			}

			if (adjMap.get(eq[1]) == null) {
				adjMap.put(eq[1], new ArrayList<>());
				adjValuesMap.put(eq[1], new ArrayList<>());
			}

			adjMap.get(eq[0]).add(eq[1]);
			adjValuesMap.get(eq[0]).add(values[i]);

			adjMap.get(eq[1]).add(eq[0]);
			adjValuesMap.get(eq[1]).add(1 / values[i]);
		}

		double[] res = new double[queries.length];
		for (int i = 0; i < queries.length; i++) {
			String[] query = queries[i];
			double val = dfs(query[0], query[1], 1.0, adjMap, adjValuesMap, new HashSet<String>());
			if (val != 0.0) {
				res[i] = val;
			} else {
				res[i] = -1.0;
			}
		}

		return res;
	}

	double dfs(String start, String end, double resValue, Map<String, List<String>> adjMap,
			Map<String, List<Double>> adjValuesMap, Set<String> visited) {

		if (visited.contains(start) || !adjMap.containsKey(start)) {
			return 0.0;
		}

		if (end.equals(start)) {
			return resValue;
		}
		visited.add(start);

		for (int i = 0; i < adjMap.get(start).size(); i++) {
			double valueToBeMultiplied = adjValuesMap.get(start).get(i);
			double value = dfs(adjMap.get(start).get(i), end, resValue * valueToBeMultiplied, adjMap, adjValuesMap,
					visited);
			if (value != 0.0) {
				return value;
			}
		}
		visited.remove(start);
		return 0.0;

	}

}
