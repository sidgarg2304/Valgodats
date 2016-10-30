package com.vishal.datastructures.binarytree;

import java.util.Stack;

public class BinaryTreeTraversals {

	public static void main(String[] args) {
		testpostOrderIterative();
		testSerializeBinaryTree();
	}

	public static void testpostOrderIterative() {
		BTNode<Integer> root = BinaryTreePrograms.constructBST();
		BinaryTreePrinter.printNode(root);
		postOrderIterative(root);
	}

	public static void testSerializeBinaryTree() {
		BTNode<Integer> root = BinaryTreePrograms.constructBST();
		BinaryTreePrinter.printNode(root);
		
		String serializedBinaryTree = serializeBinaryTree(root);
		System.out.println(serializedBinaryTree);
		
		System.out.println(isValieBinaryTree(serializedBinaryTree));
		
		root = deSerializeBinaryTree(serializedBinaryTree);
		BinaryTreePrinter.printNode(root);
	}

	public static BTNode<Integer> constructBST() {
		BTNode<Integer> root = new BTNode<Integer>(1);
		root.left = new BTNode<Integer>(2);
		// root.right = new BTNode<Integer>(8);

		// root.left.left = new BTNode<Integer>(1);
		root.left.right = new BTNode<Integer>(3);

		// root.right.left = new BTNode<Integer>(6);
		// root.right.right = new BTNode<Integer>(9);

		return root;
	}

	public static void postOrderIterative(BTNode<Integer> root) {

		Stack<BTNode<Integer>> stack = new Stack<>();
		BTNode<Integer> current = root;

		while (current != null || !stack.isEmpty()) {

			// Add to stack until you hit left most
			if (current != null) {
				stack.push(current);
				current = current.getLeft();
			} else {
				BTNode<Integer> temp = stack.peek().getRight();
				// check if the left most has a right
				if (temp == null) {
					// print itself
					temp = stack.pop();
					System.out.println(temp.getValue());

					while (!stack.isEmpty() && temp == stack.peek().getRight()) {
						temp = stack.pop();
						System.out.println(temp.getValue());
					}
				} else { // if the left has a right, add it to stack and all it's
							// left until left most
					current = temp;
				}
			}

		}

	}

	public static String serializeBinaryTree(BTNode<Integer> root) {
		StringBuilder serializedPreOrderString = new StringBuilder();

		Stack<BTNode<Integer>> stack = new Stack<BTNode<Integer>>();
		stack.push(root);

		while (!stack.isEmpty()) {
			BTNode<Integer> t = stack.pop();
			if (t != null) {
				serializedPreOrderString.append(t.getValue() + ",");
				stack.push(t.getRight());
				stack.push(t.getLeft());
			} else {
				serializedPreOrderString.append("#" + ",");
			}
		}
		return serializedPreOrderString.toString();
	}

	public static boolean isValieBinaryTree(String serializedBinaryTree) {
		Stack<String> stack = new Stack<>();

		String[] serializedBinaryTreeArr = serializedBinaryTree.split(",");
		for (int i = 0; i < serializedBinaryTreeArr.length; i++) {
			stack.push(serializedBinaryTreeArr[i]);

			while (stack.size() >= 3 && stack.get(stack.size() - 1).equals("#") && stack.get(stack.size() - 2).equals("#")
					&& !stack.get(stack.size() - 3).equals("#")) {
				stack.pop();
				stack.pop();
				stack.pop();
				stack.push("#");
			}

		}

		return (stack.isEmpty() || (stack.size() == 1 && stack.peek().equals("#")));
	}

	static int i = 0;
	public static BTNode<Integer> deSerializeBinaryTree(String serializedBinaryTree) {
		
		String[] serializedBinaryTreeArr = serializedBinaryTree.split(",");
		return constructTree(serializedBinaryTreeArr);
	}
	
	public static BTNode<Integer> constructTree(String[] serializedBinaryTreeArr){
		if(serializedBinaryTreeArr[i].equals("#")){
			return null;
		}
		BTNode<Integer> root = new BTNode<Integer>(Integer.valueOf(serializedBinaryTreeArr[i]));
		i++;
		root.setLeft(constructTree(serializedBinaryTreeArr));
		i++;
		root.setRight(constructTree(serializedBinaryTreeArr));
		return root;
	}

}
