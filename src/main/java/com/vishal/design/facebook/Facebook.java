package com.vishal.design.facebook;

import java.util.*;

public class Facebook {

	List<Person> people;

	Map<String, List<String>> mutualFriends;

	public Facebook() {
		people = new ArrayList<>();
		mutualFriends = new HashMap<>();
	}

	void addFriend(Person p, Person f) {
		p.friends.add(f);
		f.friends.add(p);

		addMutualFriends(p, f);
	}

	void addMutualFriends(Person p, Person f) {

	}

	boolean is3rdDegreeOfConnection(Person p, Person p1) {

		List<Person> secondDegreeConnections = new ArrayList<>();
		for (Person f : p.friends) {
			for (Person ff : f.friends) {
				if (!p.friends.contains(f)) {
					secondDegreeConnections.add(ff);
				}
			}
		}
		
		return false;
		
	}

	List<Person> getCommonFriends(Person p1, Person p2) {
		List<Person> result = new ArrayList<>();

		for (Person f : p2.friends) {
			if (p1.friends.contains(f)) {
				result.add(f);
			}
		}

		return result;

	}

	/**
	 * O(n^2) complexity Using Count sort algorithm
	 * 
	 * @param p
	 * @return
	 */
	List<Person> getSuggestedFriends(Person p) {
		List<Person> result = new ArrayList<>();

		Map<Person, Integer> mutualFriendsCountMap = new HashMap<>();

		for (Person f : p.friends) {
			for (Person ff : f.friends) {
				mutualFriendsCountMap.put(ff, mutualFriendsCountMap.getOrDefault(ff, 0) + 1);
			}
		}

		List<Person>[] count = new List[mutualFriendsCountMap.size()];

		for (Person k : mutualFriendsCountMap.keySet()) {
			int noOfMutualFriends = mutualFriendsCountMap.get(k);
			if (count[noOfMutualFriends] == null) {
				count[noOfMutualFriends] = new ArrayList<>();
			}

			count[noOfMutualFriends].add(k);
		}
		
		for (int i = count.length - 1; i >= 0; i--) {
			if (count[i] != null) {			
				int k = 0;
				while (k < count[i].size()) {
					result.add(count[i].get(k++));
					if(result.size() == 5){
						break;
					}
				}
			}
		}

		return result;
	}

	Set<SuggestedFriend> getSuggestedFriendsBFS(Person p) {
		TreeSet<SuggestedFriend> suggestedFriends = new TreeSet<>(new Comparator<SuggestedFriend>() {
			public int compare(SuggestedFriend s1, SuggestedFriend s2) {
				return s2.mutualFriends - s1.mutualFriends;
			}
		});

		// BFS and start from all your friends
		Queue<Person> queue = new LinkedList<>();
		for (Person f : p.friends) {
			queue.offer(f);
		}

		int level = 1;
		while (!queue.isEmpty()) {
			if (level == 4) {
				break;
			}
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Person possFren = queue.poll();
				if (level > 1 && !p.friends.contains(possFren)) {
					List<String> mutualFriendIds = mutualFriends.get(p.id + "," + possFren.id);
					// make sure to remove duplicate suggested friends. either
					SuggestedFriend sug = new SuggestedFriend();
					sug.p = p;
					sug.suggestedFriend = possFren;
					sug.mutualFriends = mutualFriendIds.size();
					suggestedFriends.add(sug);
				}

				for (Person f : possFren.friends) {
					queue.offer(f);
				}

			}
			level++;
		}

		return suggestedFriends;
	}
}
