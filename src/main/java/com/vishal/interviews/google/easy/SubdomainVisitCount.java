package com.vishal.interviews.google.easy;

import java.util.*;

public class SubdomainVisitCount {

	public static void main(String[] args) {

	}

	public List<String> subdomainVisits(String[] cpdomains) {
      List<String> res = new ArrayList<>();		
		if(cpdomains == null || cpdomains.length == 0) {
			return res;
		}
		
		Map<String, Integer> map = new HashMap<>();

		for (String cpdomain : cpdomains) {
			String[] arr = cpdomain.split("\\s");
			int val = Integer.parseInt(arr[0]);
			String domain = arr[1];
			map.put(domain, map.getOrDefault(domain, 0) + val);
			
			for(int j = 0; j< domain.length(); j++) {
				if(domain.charAt(j) == '.') {
					String dom = domain.substring(j + 1);
					map.put(dom, map.getOrDefault(dom, 0) + val);
				}
			}
		}
		
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			res.add(entry.getValue() + " " + entry.getKey());
		}
		return res;
  }

}
