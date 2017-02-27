package com.vishal.datastructures.binarysearchtree;

class BSTNode<T> {

	public BSTNode(T value) {
		this.value = value;
	}

	T value;
	BSTNode<T> left;
	BSTNode<T> right;
	int height;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public BSTNode<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}

	public BSTNode<T> getRight() {
		return right;
	}

	public void setRight(BSTNode<T> right) {
		this.right = right;
	}
}
