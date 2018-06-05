package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

public class FindDuplicateFileinSystem {

	public static void main(String[] args) {

	}

	public List<List<String>> findDuplicate(String[] paths) {
		List<List<String>> res = new ArrayList<>();

		if (paths == null || paths.length == 0) {
			return res;
		}

		Map<String, Set<String>> contentFileNamesMap = new HashMap<>();

		for (String p : paths) {
			String[] arr = p.split("\\s");
			String dir = arr[0];

			for (int i = 1; i < arr.length; i++) {
				int idx = arr[i].indexOf('(');
				String content = arr[i].substring(idx);
				String fileName = dir + "/" + arr[i].substring(0, idx);
				Set<String> filesWithContent = contentFileNamesMap.getOrDefault(content, new HashSet<>());
				filesWithContent.add(fileName);
				contentFileNamesMap.put(content, filesWithContent);
			}

		}

		for (String content : contentFileNamesMap.keySet()) {
			if (contentFileNamesMap.get(content).size() > 1) {
				res.add(new ArrayList<>(contentFileNamesMap.get(content)));
			}
		}
		return res;
	}

}
