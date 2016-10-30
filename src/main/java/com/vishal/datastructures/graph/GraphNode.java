package com.vishal.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {

	T value;
	private int levelNumber;
	private GraphNode<T> prev;	
	private List<GraphNode<T>> neighbors;

	public GraphNode(T value) {
		this.value = value;
		neighbors = new ArrayList<GraphNode<T>>();
	}
	
	public GraphNode(T value, int levelNumber) {
		this.value = value;
		this.levelNumber = levelNumber;
		neighbors = new ArrayList<GraphNode<T>>();
	}
	
	public GraphNode(T value, int levelNumber, GraphNode<T> prev) {
		this.value = value;
		this.levelNumber = levelNumber;
		this.prev = prev;
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
	
	public void addNeighbor(GraphNode<T> neighbor) {
		neighbors.add(neighbor);
	}
	
	public GraphNode<T> getPrev() {
		return prev;
	}

	public void setPrev(GraphNode<T> prev) {
		this.prev = prev;
	}

	public int getLevelNumber() {
		return levelNumber;
	}

	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}
}
