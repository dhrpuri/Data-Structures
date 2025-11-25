

public class BinarySearchTree {
	Node root;
	 
	 BinarySearchTree(){
	   this.root = null;
	  }

	  class Node{
	    int data;
	    Node left,right;

	    Node(int value){
	      data = value;
	      left = null;
	      right = null;
	    }

		public void printInOrder() {
			if(left != null) {
				left.printInOrder();
			}
			System.out.println(data + " ");
			if(right != null) {
				right.printInOrder();
			}
		}
		
	  }
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(tree,77);
		tree.insert(tree,18);
		tree.insert(tree,78);
		tree.insert(tree,83);
		tree.insert(tree,80);
		tree.insert(tree,93);
		tree.insert(tree,100);
		tree.insert(tree,99);
		tree.insert(tree,97);
		tree.insert(tree,89);
		tree.insert(tree,85);
		tree.insert(tree,90);
		tree.insert(tree,79);
		tree.insert(tree,56);
		tree.insert(tree,20);
		tree.insert(tree,10);
		tree.insert(tree,12);
		tree.insert(tree,1);
		tree.printInOrder();
		System.out.println("");
		int remove = 83;
		int value = tree.findSuccessor(remove).data;
		int value1 = tree.findParent(value).data;
		System.out.println("Successor: " + value);
		System.out.println("Parent of successor: " + value1);
		int value2 = tree.lookup(56).data;
		System.out.println("Node found " + value1);
		tree.remove(remove);
		tree.printInOrder();
		System.out.println("");
	}
//insert new node in the binary search tree
	  public void insert(BinarySearchTree tree, int value) {
		  if(tree.root == null) {
			  Node newNode = new Node(value);
			  tree.root = newNode;
		  }
		  else {
			  Node leaf = findLeafNode(tree,value);
			  if(value < leaf.data){
				  leaf.left = new Node(value);
			  }
			  else {
				  leaf.right = new Node(value);
			  }
		  }
	  }
	  
//Method to find the leaf node.
	  public Node findLeafNode(BinarySearchTree tree,int value) {
		  Node currentNode = tree.root;
		  Node leafNode = tree.root;
		  while(currentNode != null) {
			  if(value < currentNode.data ) {
				  if( currentNode.left != null) {
					  currentNode = currentNode.left;
					  }
				  else {
					  leafNode = currentNode;
					  currentNode = null;
					  }
			  }
			  else if(value > currentNode.data) {
				  if(currentNode.right != null){
					  currentNode = currentNode.right;
				  }
				  else {
					  leafNode = currentNode;
					  currentNode = null;
					  }
			  }
		  }
		  return leafNode;
	  }
//Method to see the node is present or not in the BST
	  public Node lookup(int value) {
		  Node currentNode = root;
		  while(currentNode != null) {
			  if(currentNode.data == value) {
				  return currentNode;
				  }
			  else if(value < currentNode.data ) {
				  if( currentNode.left != null) {
					  currentNode = currentNode.left;
					  }
				  else {
					  currentNode = null;
					  }
			  }
			  else if(value > currentNode.data) {
				  if(currentNode.right != null){
					  currentNode = currentNode.right;
				  }
				  else {
					  currentNode = null;
					  }
			  }
		  }
		  return null;
	  }
//Method to remove a node from the BST
	  public void remove(int value) {
		  Node removeNode = lookup(value);
		  Node successorNode = findSuccessor(value);
		  if(removeNode != successorNode) {
			  int tempData = successorNode.data;
			  Node parentOfSucNode = findParent(successorNode.data);
			  if(parentOfSucNode == removeNode) {
				  if(parentOfSucNode.left != successorNode) {
					  successorNode.left = parentOfSucNode.left;
					  }
				  else {
					  parentOfSucNode.left = null;
				  }
				  parentOfSucNode.data = successorNode.data;
				  parentOfSucNode.right = successorNode.right;
			  }
			  else if(successorNode.data < parentOfSucNode.data) {
				  parentOfSucNode.left = null;
				  removeNode.data = tempData;
			  }
		  }
		  else {
			  Node parentNode = findParent(removeNode.data);
			  if(successorNode.data < parentNode.data) {
				  parentNode.left = null;
			  }
			  else {
				  parentNode.right = null;
			  }
		  }
	  }
//Method to find the successor of the removed node
	  public Node findSuccessor(int value) {
		  Node currentNode = lookup(value);
		  if(currentNode.right != null) {
			  currentNode = currentNode.right;
			  while(currentNode.left != null) {
				  currentNode = currentNode.left;
			  }
			  return currentNode;
		  }
		  else if(currentNode.right == null & currentNode.left != null) {
			  currentNode = currentNode.left;
			  return currentNode;
		  }
		  return currentNode;
	  }

//Method to find Parent of the node
	  public Node findParent(int value) {
			  Node currentNode = root;
			  while(currentNode != null) {
				  if(value < currentNode.data ) {
					  if( currentNode.left != null) {
						  if(currentNode.left.data == value) {
							  return currentNode;
						  }
						  currentNode = currentNode.left;
						  }
				  }
				  else if(value > currentNode.data) {
					  if(currentNode.right != null){
						  if(currentNode.right.data == value) {
							  return currentNode;
						  }
						  currentNode = currentNode.right;
					  }
				  }
			  }
			  return currentNode;
		  }
		  
//Method to print the BST in In-order 
	  public void printInOrder() {
		  if(root != null) {
			  root.printInOrder();
		  }
	  }

	  public Node findNode(Node root, int value){
		 if(root == null){return null;}
		 if(root.data == value){return root;}
		 if(root.data > value){return findNode(root.right, value);}
		 if(root.data <= value){return findNode(root.left, value);}
		 return root;
	  }
}
