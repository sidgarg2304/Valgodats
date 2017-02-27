package com.vishal.datastructures.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversals {

	public static void main(String[] args) {
		testpostOrderIterative();
		testPreOrderIterative();
		testInOrderIterative();
		testSerializeBinaryTree();
	}

	public static void testpostOrderIterative() {
		BTNode<Integer> root = BinaryTreePrograms.constructBST();
		BinaryTreePrinter.printNode(root);
		postOrderIterative(root);
	}

	public static void testPreOrderIterative() {
		BTNode<Integer> root = BinaryTreePrograms.constructBST();
		BinaryTreePrinter.printNode(root);
		preOrderIterative(root);
	}
	
	public static void testInOrderIterative(){
		BTNode<Integer> root = BinaryTreePrograms.constructBST();
		BinaryTreePrinter.printNode(root);
		inOrderIterative(root);
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
		System.out.println("printing post order");
		
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
					System.out.print(temp.getValue() +" ");

					//If you are the right child of the peek (parent), print yourself
					while (!stack.isEmpty() && temp == stack.peek().getRight()) {
						temp = stack.pop();
						System.out.print(temp.getValue() +" ");
					}
				} else { // if the left has a right, add it to stack and all it's
							// left until left most
					current = temp;
				}
			}
		}
		System.out.println("\n");

	}

	public static void preOrderIterative(BTNode<Integer> root) {

		System.out.println("printing pre order");		
		Stack<BTNode<Integer>> stack = new Stack<BTNode<Integer>>();
		stack.push(root);

		while (!stack.isEmpty()) {
			BTNode<Integer> p = stack.pop();
			System.out.print(p.getValue() + " ");
			if (p.right != null) {
				stack.push(p.right);
			}
			if (p.left != null) {
				stack.push(p.left);
			}
		}
		System.out.println("\n");
	}
	
	public static void inOrderIterative(BTNode<Integer> root) {

		System.out.println("printing in order");		
		Stack<BTNode<Integer>> stack = new Stack<BTNode<Integer>>();		

		BTNode<Integer> p = root;
				
		while (p !=null || !stack.isEmpty()) {
			if(p != null){
				stack.push(p);
				p = p.left;
			}else{
				BTNode<Integer> t = stack.pop();
				System.out.print(t.getValue()+" ");
				p = t.right;
			}						
		}
		System.out.println("\n");
	}
	
	public static void verticalOrderTraversal(BTNode<Integer> root) {
		Map<Integer, List<Integer>> result = new HashMap<>();
		Queue<BTNode<Integer>> queue = new LinkedList<>();
		Queue<Integer> level = new LinkedList<>();

		queue.offer(root);
		level.offer(0);

		while (!queue.isEmpty()) {
			BTNode<Integer> p = queue.poll();
			int l = level.poll();

			if (result.containsKey(l)) {
				result.get(l).add(p.value);
			}

			if (p.left != null) {
				queue.offer(p.left);
				level.offer(l - 1);
			}

			if (p.right != null) {
				queue.offer(p.right);
				level.offer(l + 1);
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

	public static BTNode<Integer> constructTree(String[] serializedBinaryTreeArr) {
		if (serializedBinaryTreeArr[i].equals("#")) {
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
