

import java.util.ArrayList;

class Graph {
	ArrayList<Node> nodeList;
	Graph(){
		nodeList = new ArrayList<Node>();
	}
	class Node{
		int data;
		ArrayList<Node> adjacentList = null;
		
		Node(int value){
			data = value;
			adjacentList = new ArrayList<Node>();
		}
	}
	
//Method to add a vertex to the graph
	public void addVertex(int value) {
		Node newNode = new Node(value);
		if(findNode(value) != null) {
			System.out.println("Node already exist!");
			}
		else {
			nodeList.add(newNode);
			}
		}
//Method to add new edge in the graph
	public void addEdge(int node1, int node2) {
		Node firstNode = findNode(node1);
		Node secondNode = findNode(node2);
		for(Node node : nodeList) {
			if(firstNode != null && secondNode != null) {
				if((node == secondNode && node.adjacentList.contains(firstNode)) || 
						(node == firstNode && node.adjacentList.contains(secondNode))) {
					System.out.println("(" + node1 + "," + node2 +") " + "Edge already exist");
					break;
				}
				else {
					if(node == firstNode) {
						firstNode.adjacentList.add(secondNode);
					}
					else if(node == secondNode) {
					secondNode.adjacentList.add(firstNode);
					}
				}
				}
				else {
					System.out.println("(" + node1 + "," + node2 +") " +"Invalid edge!");
					break;
				}
			}
	}
//Method to return node with the given data
	public Node findNode(int value) {
		Node currentNode = null;
		for(Node node : nodeList) {
			if(node.data == value) {
				currentNode =  node;
			}
		}
		return currentNode;
	}
//Method to print the graph data in Adjacency List format
	public void printGraph() {
		for(Node node : nodeList) {
			System.out.print(node.data);
			System.out.print(" --> ");
			System.out.print("[ ");
			for(Node adjNode : node.adjacentList) {
				System.out.print(adjNode.data + " ");
			}
			System.out.print("]");
			System.out.println("");
	}
}
}
