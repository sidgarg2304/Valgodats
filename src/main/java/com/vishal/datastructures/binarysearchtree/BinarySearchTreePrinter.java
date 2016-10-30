package com.vishal.datastructures.binarysearchtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTreePrinter {

	public static <T extends Comparable<?>> void printNode(BSTNode<T> root) {
		int maxLevel = BinarySearchTreePrinter.maxLevel(root);

		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private static <T extends Comparable<?>> void printNodeInternal(List<BSTNode<T>> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || BinarySearchTreePrinter.isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		BinarySearchTreePrinter.printWhitespaces(firstSpaces);

		List<BSTNode<T>> newNodes = new ArrayList<BSTNode<T>>();
		for (BSTNode<T> node : nodes) {
			if (node != null) {
				System.out.print(node.getValue());
				newNodes.add(node.left);
				newNodes.add(node.right);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}

			BinarySearchTreePrinter.printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}

				if (nodes.get(j).left != null)
					System.out.print("/");
				else
					printWhitespaces(1);

				printWhitespaces(i + i - 1);

				if (nodes.get(j).right != null)
					System.out.print("\\");
				else
					printWhitespaces(1);

				printWhitespaces(endgeLines + endgeLines - i);
			}

			System.out.println("");
		}

		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static <T extends Comparable<?>> int maxLevel(BSTNode<T> node) {
		if (node == null)
			return 0;

		return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
	}

	private static <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}

		return true;
	}

}
