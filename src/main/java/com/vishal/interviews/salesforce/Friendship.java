package com.vishal.interviews.salesforce;

import java.util.*;

//The Friendship class
//
//
public class Friendship {

	public static void main(String[] args) {

		Set<Node> visited = new HashSet<>();
		Node n = new Node("vishal");
		visited.add(n);
		Node n1 = new Node("vishal");
		System.out.println("contains " + (visited.contains(n1)));
	}

	Map<String, Node> network;

	public Friendship() {
		network = new HashMap<>();
	}

	// This is for you to implement
	//
	// This method takes 2 String parameters and
	// makes them "friends" of each other.
	//
	// Note: The order of names does not matter
	// Note: Do not forget to write tests to have good test coverage for this
	// method
	public void makeFriend(String nameKey, String friendName) {

		if (nameKey == null || "".equals(nameKey.trim()) || friendName == null || "".equals(friendName.trim())
				|| nameKey.trim().equals(friendName.trim())) {
			return;
		}

		Node user = findNode(nameKey);
		Node friend = findNode(friendName);

		if (user.getFriends().contains(friend)) {
			return;
		}

		user.getFriends().add(friend);
		friend.getFriends().add(user);
	}

	Node findNode(String name) {
		if (network.containsKey(name)) {
			return network.get(name);
		}
		Node n = new Node(name);
		network.put(name, n);
		return n;
	}

	// This is for you to implement
	//
	// This method takes 2 String parameters and
	// makes them no longer friends of each other.
	//
	// Note: The order of names does not matter
	// Note: Do not forget to write tests to have good test coverage for this
	// method
	public void unmakeFriend(String nameKey, String friendName) {
		
		if (nameKey == null || "".equals(nameKey.trim()) || friendName == null || "".equals(friendName.trim())
				|| nameKey.trim().equals(friendName.trim())) {
			return;
		}
		
		Node user = network.get(nameKey);
		Node friend = network.get(friendName);

		user.getFriends().remove(friend);
		friend.getFriends().remove(user);
	}

	// This is for you to implement
	//
	// This method takes a single argument (name) and
	// returns all immediate "friends" of that name
	//
	// For example, A & B are friends, B & C are friends, and C & D are friends.
	// getDirectFriends(B) would return A and C
	// getDirectFriends(D) would return C
	//
	// Note: It should not return duplicate names
	// Note: Do not forget to write tests to have good test coverage for this
	// method
	public List<String> getDirectFriends(String nameKey) {
		List<String> res = new ArrayList<>();

		if (nameKey == null || "".equals(nameKey.trim()) || !network.containsKey(nameKey)) {
			return res;
		}
		
		Node user = network.get(nameKey);

		List<Node> friends = user.getFriends();
		for (Node f : friends) {
			res.add(f.getName());
		}
		return res;
	}

	// This is for you to implement (Seniors and above)
	//
	// This method takes a single argument (name) and
	// returns all the indirect "friends" of that name
	//
	// For example, A & B are friends, B & C are friends, and C & D are friends.
	// getInirectFriends(A) would return C and D
	//
	// Note: It should not return duplicate names
	// Note: Do not forget to write tests to have good test coverage for this
	// method

	public List<String> getIndirectFriends(String nameKey) {
		List<String> res = new ArrayList<>();

		if (nameKey == null || "".equals(nameKey.trim()) || !network.containsKey(nameKey)) {
			return res;
		}

		Set<String> visited = new HashSet<>();

		Node user = network.get(nameKey);

		Queue<Node> queue = new LinkedList<>();
		queue.offer(user);

		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node cur = queue.poll();

				if (visited.contains(cur.getName())) {
					continue;
				}

				// not add current user and direct friends. So, consider only from
				// 3rd level
				if (level >= 3) {
					res.add(cur.getName());
				}
				for (Node f : cur.getFriends()) {
					queue.offer(f);
				}
				visited.add(cur.getName());
			}
			level++;
		}
		return res;

	}
}

class Node {
	private String name;
	private List<Node> friends;

	public String getName() {
		return name;
	}

	public List<Node> getFriends() {
		return friends;
	}

	Node(String name) {
		this.name = name;
		friends = new ArrayList<>();
	}

	public boolean equals(Object o) {
		if (o instanceof Node) {
			Node n = (Node) o;
			return this.getName().equals(n.getName());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
	    return name.hashCode();
	}
}
