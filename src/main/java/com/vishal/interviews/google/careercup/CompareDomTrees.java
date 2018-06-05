package com.vishal.interviews.google.careercup;

import java.util.*;

import com.vishal.interviews.util.HtmlNode;

public class CompareDomTrees {

	public static void main(String[] args) {

		
	}

	/**
	 * O(m+n)
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	public boolean isTextContentEqualSimple(HtmlNode node1, HtmlNode node2) {

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		dumpText(node1, sb1);
		dumpText(node2, sb2);

		return sb1.equals(sb2);
	}

	void dumpText(HtmlNode node, StringBuilder sb) {
		sb.append(node.content);
		for (HtmlNode ch : node.children) {
			dumpText(ch, sb);
		}
	}

	public boolean isTextContentEqual(HtmlNode node1, HtmlNode node2) {
		TreeIterator iter1 = new TreeIterator(node1);
		TreeIterator iter2 = new TreeIterator(node2);

		String sb1 = "";
		String sb2 = "";

		while (iter1.hasNext() || !sb1.equals("") || iter2.hasNext() || !sb2.equals("")) {
			if ("".equals(sb1)) {
				sb1 = iter1.next();
			}

			if ("".equals(sb2)) {
				sb2 = iter2.next();
			}

			int minLen = Math.min(sb1.length(), sb2.length());
			if (sb1.substring(0, minLen).equals(sb2.substring(0, minLen))) {
				sb1 = sb1.substring(minLen);
				sb2 = sb2.substring(minLen);
			} else {
				return false;
			}
		}

		if (iter1.hasNext() || iter2.hasNext() || "".equals(sb1) || "".equals(sb2)) {
			return false;
		}
		return true;
	}

}

class TreeIterator {
	Stack<HtmlNode> stack;
	Stack<Integer> childIndexPosStack;

	TreeIterator(HtmlNode node) {
		stack = new Stack<>();
		stack.push(node);

		childIndexPosStack = new Stack<>();
		childIndexPosStack.push(0); // maintain index of the first child
	}

	/**
	 * If no memory constraints
	 */
	String nextSimple() {
		while (!stack.isEmpty() && !stack.peek().isTextNode) {
			HtmlNode cur = stack.pop();
			for (int i = cur.children.size() - 1; i >= 0; i--) {
				stack.push(cur.children.get(i));
			}
		}

		if (stack.isEmpty()) {
			return null;
		}
		return stack.pop().content;
	}

	/**
	 * If memory constraints
	 */
	String next() {
		if (stack.isEmpty()) {
			return null;
		}

		childIndexPosStack.pop();
		return stack.pop().content;
	}

	boolean hasNext() {
		while (!stack.isEmpty() && !stack.peek().isTextNode) {
			HtmlNode cur = stack.peek();

			if (childIndexPosStack.peek() >= cur.children.size()) {
				childIndexPosStack.pop();
				stack.pop();
			} else {
				int curIndex = childIndexPosStack.pop();
				HtmlNode ch = cur.children.get(curIndex);
				// add index for the next child of cur node
				childIndexPosStack.push(curIndex + 1);

				// add the child
				stack.push(ch);
				// the first child of child to process
				childIndexPosStack.push(0);
			}
		}

		return !stack.isEmpty() && stack.peek().isTextNode;
	}
}
