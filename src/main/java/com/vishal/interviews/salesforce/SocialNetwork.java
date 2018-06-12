package com.vishal.interviews.salesforce;

import java.util.*;

public class SocialNetwork {

	List<Node> network;

	SocialNetwork() {
		network = new ArrayList<>();
	}

	public static void main(String[] args) {

	}

	void makeFriends(String user1, String user2) {
		makeFriends(findNode(user1), findNode(user2));
	}

	void makeFriends(Node user1Node, Node user2Node) {
		user1Node.friends.add(user2Node);
		user2Node.friends.add(user1Node);
	}

	void removeFriends(String user1, String user2) {
		removeFriends(findNode(user1), findNode(user2));
	}

	void removeFriends(Node user1Node, Node user2Node) {
		user1Node.friends.remove(user2Node);
		user2Node.friends.remove(user1Node);
	}

	List<String> getDirectFriends(String user) {
		return getDirectFriends(findNode(user));
	}

	List<String> getDirectFriends(Node userNode) {
		List<String> res = new ArrayList<>();

		for (Node userFriend : userNode.friends) {
			res.add(userFriend.name);
		}
		return res;
	}

	List<String> getInDirectFriends(String user) {
		return getInDirectFriends(findNode(user));
	}

	List<String> getInDirectFriends(Node userNode) {
		List<String> res = new ArrayList<>();
		Set<String> ids = new HashSet<>();

		for (Node userFriend : userNode.friends) {
			for (Node userFriendsFriend : userFriend.friends) {
				if (!ids.contains(userFriendsFriend.id)) {
					res.add(userFriendsFriend.name);
					ids.add(userFriendsFriend.id);
				}
			}
		}
		return res;
	}

	Node findNode(String userId) {

		// dfs
		Stack<Node> stack = new Stack<>();
		for (Node n : network) {
			stack.push(n);
		}

		Set<String> visited = new HashSet<>();

		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			if (userId.equals(cur.id)) {
				return cur;
			}
			visited.add(cur.id);
			for (Node f : cur.friends) {
				if (!visited.contains(f.id)) {
					stack.push(f);
				}
			}
		}

		return null;
	}

}

class Node {
	String id;
	String name;

	List<Node> friends;
}
