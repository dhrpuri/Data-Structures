

class Main {
	  public static void main(String[] args) {
		  

//*****************************************************************************************
		  //arrayPractice arrPrac = new arrayPractice();
		    //hashTablePrac hashPrac = new hashTablePrac(50);
		    //LinkedList linList = new LinkedList();
		  	//Stack newStack = new Stack();
		  	//StackArr newStack = new StackArr();
		  	//Queue newQueue = new Queue();

		    //arrPrac.logarr();

		    //arrPrac.strcount();

		    //arrPrac.arrayOper();
		    
//*****************************************************************************************
		    //Hash table creation and value returning
		    /*
		    hashPrac.set("grapes",1000);
		    int hashtest = hashPrac.get("grapes");
		    System.out.println(hashtest);
		    */

//*****************************************************************************************		   
		    //Implementation of linked list
		    /*
		    linList = linList.append(linList,10);
		    linList = linList.append(linList,15);
		    linList = linList.append(linList,16);
		    linList = linList.append(linList,17);
		    System.out.println("APPEND");
		    linList.printList(linList);
		    System.out.println("");
		    //int e = linList.head.next.next.previous.data;
		    //System.out.println("DLL check: " + e );
		    System.out.println("");
		    System.out.println("");
		    linList = linList.prepend(linList,20);
		    System.out.println("PREPEND");
		    linList.printList(linList);
		    System.out.println("");
		   // int e1 = linList.head.next.previous.data;
		   // System.out.println("DLL check: " + e1 );
		    System.out.println("");
		    System.out.println("");
		    linList = linList.insert(linList, 4, 30);
		    System.out.println("INSERT");
		    linList.printList(linList);
		    System.out.println("");
		    //int e2 = linList.head.next.next.next.next.next.previous.data;
		    //System.out.println("DLL check: " + e2 );
		    System.out.println("");
		    System.out.println("");
		    linList = linList.remove(linList, 2);
		    System.out.println("REMOVE");
		    linList.printList(linList);
		    System.out.println("");
		    //int e3 = linList.head.next.next.next.previous.data;
		    //System.out.println("DLL check: " + e3 );
		    System.out.println("");
		    System.out.println("");
		    //int len = linList.length;
		    //System.out.println("Length of the list is " + len);
		     */
//*****************************************************************************************
		    //Stack implementation
		  	// 1. Using Linked List
		  	/*
		  	newStack = newStack.push(newStack, 10);
		  	newStack = newStack.push(newStack, 20);
		  	newStack = newStack.push(newStack, 30);
		  	newStack = newStack.push(newStack, 40);
		  	newStack = newStack.push(newStack, 50);
		  	newStack.printStack(newStack);
		    System.out.println("");
		  	int top = newStack.peek(newStack);
		    System.out.println(top);
		  	newStack = newStack.pop(newStack);
		  	newStack = newStack.pop(newStack);
		  	newStack.printStack(newStack);
		    System.out.println("");
		  	int top1 = newStack.peek(newStack);
		    System.out.println(top1);
		    int stackLength = newStack.length;
		    System.out.println(stackLength);
		    */
		  	// 2. Using Dynamic Array
		  	/*
		  	newStack.push("Google");
		  	newStack.push("Yahoo");
		  	newStack.push("discord");
		  	newStack.push("youtube");
		  	newStack.push("Facebook");
		  	newStack.printStack();
		    System.out.println("");
		  	String top = newStack.peek();
		    System.out.println("Top of the stack: " + top + "\n");
		  	newStack.pop();
		  	newStack.pop();
		  	newStack.printStack();
		    System.out.println("");
		  	String top1 = newStack.peek();
		    System.out.println(top1);
		    int stackLength = newStack.length;
		    System.out.println(stackLength);
		    */
//*****************************************************************************************
		  	//Queue Implementation
		  	/*
		    System.out.println("\nCheck if the queue is empty " + newQueue.isEmpty(newQueue));
		  	newQueue = newQueue.enqueue(newQueue, "Joy");
		  	newQueue = newQueue.enqueue(newQueue, "Matt");
		  	newQueue = newQueue.enqueue(newQueue, "Pavel");
		  	newQueue = newQueue.enqueue(newQueue, "Samir");
		  	newQueue.printQueue(newQueue);
		  	System.out.println("\nFirst in line is " + newQueue.peek());
		  	newQueue = newQueue.dequeue(newQueue);
		    System.out.println("\nQueue after dequeue");
		  	newQueue.printQueue(newQueue);
		  	System.out.println("\nFirst in line is " + newQueue.peek());
		    System.out.println("\nCheck if the queue is empty " + newQueue.isEmpty(newQueue));
		  	*/

//*****************************************************************************************
		  //Binary search Tree Implementation
		  /*
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
		  tree.remove(remove);
		  tree.printInOrder();
		  System.out.println("");
		  */

//*****************************************************************************************
		  //Graph Implementation
		  Graph graph = new Graph();
		  graph.addVertex(0);
		  graph.addVertex(1);
		  graph.addVertex(2);
		  graph.addVertex(3);
		  graph.addVertex(4);
		  graph.addVertex(5);
		  graph.addVertex(6);
		  graph.addEdge(3, 1);
		  graph.addEdge(3, 4);
		  graph.addEdge(4, 2);
		  graph.addEdge(4, 5);
		  graph.addEdge(1, 2);
		  graph.addEdge(1, 0);
		  graph.addEdge(0, 2);
		  graph.addEdge(6, 5);
		  graph.addEdge(6, 5);
		  graph.addEdge(6, 7);
		  
		  graph.printGraph();
	  }
	 
	}