package com.vishal.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {

	T value;
	private List<GraphNode<T>> neighbors;

	public GraphNode(T value) {
		this.value = value;
		neighbors = new ArrayList<GraphNode<T>>();
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public List<GraphNode<T>> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<GraphNode<T>> neighbors) {
		this.neighbors = neighbors;
	}	
}
