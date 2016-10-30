package com.vishal.algorithms.dynamicprogramming.houserobbery;

import java.util.Arrays;

import com.vishal.datastructures.binarytree.BTNode;
import com.vishal.datastructures.binarytree.BinaryTreePrinter;

public class DPHouseRobberyAlgorithms {

	public static void main(String[] args) {
		testMaxMoneyCanBeRobbed();
		testMaxMoneyCanBeRobbedCircular();
		testMaxMoneyCanBeRobbedBinaryTree();
	}

	public static void testMaxMoneyCanBeRobbed() {

		System.out.println("Max money that can be robbed by the houses with money 2,3,1,2,4 is "
				+ maxMoneyCanBeRobbed(new int[] { 2, 3, 1, 2, 4 }));
	}

	public static void testMaxMoneyCanBeRobbedCircular() {

		System.out.println("Max money that can be robbed by the circular houses with money 2,3,1,2,4 is "
				+ maxMoneyCanBeRobbedCircular(new int[] { 2, 3, 1, 2, 4 }));
	}

	public static void testMaxMoneyCanBeRobbedBinaryTree() {
		BTNode<Integer> root = new BTNode<>(3);
		BTNode<Integer> left = new BTNode<>(2);
		BTNode<Integer> right = new BTNode<>(1);

		root.setLeft(left);
		root.setRight(right);

		left.setLeft(new BTNode<Integer>(4));
		left.setRight(new BTNode<Integer>(7));

		right.setLeft(new BTNode<Integer>(5));
		right.setRight(new BTNode<Integer>(6));

		System.out.println("Max money can be robbed in the below binary tree is " + maxMoneyCanBeRobbedBinaryTree(root));
		BinaryTreePrinter.printNode(root);

	}

	public static int maxMoneyCanBeRobbed(int[] moneyAtEachHouse) {

		int[] dp = new int[moneyAtEachHouse.length];
		dp[0] = moneyAtEachHouse[0];
		dp[1] = moneyAtEachHouse[1];

		for (int i = 2; i < moneyAtEachHouse.length; i++) {
			dp[i] = Math.max(dp[i - 2] + moneyAtEachHouse[i], dp[i - 1]);
		}

		return dp[dp.length - 1];
	}

	public static int maxMoneyCanBeRobbedCircular(int[] moneyAtEachHouse) {

		int[] moneyAtEachHouseWithoutFirst = Arrays.copyOfRange(moneyAtEachHouse, 1, moneyAtEachHouse.length - 1);
		int[] moneyAtEachHouseWithoutLast = Arrays.copyOfRange(moneyAtEachHouse, 0, moneyAtEachHouse.length - 2);

		// Call above method excluding first house
		int maxMoneyExludingFirst = maxMoneyCanBeRobbed(moneyAtEachHouseWithoutFirst);
		// Call above method excluding last house
		int maxMoneyExludingLast = maxMoneyCanBeRobbed(moneyAtEachHouseWithoutLast);

		return Math.max(maxMoneyExludingFirst, maxMoneyExludingLast);
	}

	public static int maxMoneyCanBeRobbedBinaryTree(BTNode<Integer> root) {
		int[] dp = maxForCurrentRoot(root);
		return Math.max(dp[0], dp[1]);
	}

	public static int[] maxForCurrentRoot(BTNode<Integer> root) {
		int[] dp = new int[2];

		if (root == null) {
			return dp;
		}

		int[] leftDp = maxForCurrentRoot(root.getLeft());
		int[] rightDp = maxForCurrentRoot(root.getRight());

		// With including root
		dp[0] = root.getValue() + leftDp[1] + rightDp[1];
		//Without root, add the max of left root and right root 
		dp[1] = Math.max(leftDp[0], leftDp[1]) + Math.max(rightDp[0], rightDp[1]);

		return dp;
	}
}
