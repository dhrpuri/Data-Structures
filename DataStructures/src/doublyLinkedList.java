

class doublyLinkedList{
 Node head,tail;
 int length;
 
 doublyLinkedList(){
    this.tail = this.head;
    this.length = 0;
  }

  class Node{
    int data;
    Node next;
    Node previous;

    Node(int value){
      data = value;
      next = null;
      previous = null;
    }
  }
  
  //Print the list
  public  void printList(doublyLinkedList list){
        Node currNode = list.head; 
  
        System.out.print("LinkedList: "); 
  
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.data + " "); 
  
            // Go to next node 
            currNode = currNode.next; 
        } 
  }
  
  //Add new node in the end of the linked list
  public  doublyLinkedList append(doublyLinkedList list, int value){
    Node newNode = new Node(value);
    if(list.head == null){
      list.head = newNode;
      list.tail = newNode;
      list.length = 1;
    }
    else{
      list.tail.next = newNode;
      newNode.previous = list.tail;
      list.tail = newNode;
      list.length++;
    }
      return list;
  }
  
  //Add new node in the beginning of the linked list
  public doublyLinkedList prepend(doublyLinkedList list,int value){
	  Node newNode = new Node(value);
	  if(list.head == null){
	      list.head = newNode;
	      list.tail = newNode;
	      list.length = 1;
	    }
	    else{
	    	newNode.next = list.head;
	    	list.head.previous = newNode;
	    	list.head = newNode;
	    	list.length++;
	    }
    return list;
  }
  
  //Add new node at the given index in the linked list
  public doublyLinkedList insert(doublyLinkedList list,int index,int value){
	  Node newNode = new Node(value);
	  if(index >= list.length) {
		  append(list,value);
		  }
	  else if(index == 0) {
		  prepend(list,value);
		  }
	  else {
		  Node currentNode = traverse(list,index);
		  currentNode.next.previous = newNode;
		  newNode.next = currentNode.next;
		  newNode.previous = currentNode;
		  currentNode.next = newNode;
		  list.length++;
	  }
    return list;
  }
  
  //Remove the element at the given index
  public doublyLinkedList remove(doublyLinkedList list,int index){
	  if(index >= list.length) {return null;}
	  if(index == 0) {
		  if(list.length > 1) {
			  list.head.next.previous = null;
			  list.head = list.head.next;
			  list.length--;
			  }
		  else {
			  list.head = null;
			  list.length--;
			  }
		  }
	  else if(index == list.length - 1) {
		  Node currentNode = list.tail.previous;
		  currentNode.next = null;
		  list.length--;
	  }
	  else {
		  Node currentNode  = traverse(list,index);
		  currentNode.next.next.previous = currentNode;
		  currentNode.next = currentNode.next.next;
		  list.length--;
	  }
    return list;
  }
  //Traverse the list
  public Node traverse(doublyLinkedList list,int index){
	  Node currentNode = list.head;
	  for(int i = 1; i < index;i++) {
		  currentNode = currentNode.next;
	  }
	  return currentNode;
  }
}
