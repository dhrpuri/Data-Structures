

class LinkedList{
 Node head,tail;
 int length;
 
  LinkedList(){
    this.tail = this.head;
    this.length = 0;
  }

  class Node{
    int data;
    Node next;

    Node(int value){
      data = value;
      next = null;
    }
  }
  
  //Print the list
  public  void printList(LinkedList list){
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
  public  LinkedList append(LinkedList list, int value){
    Node newNode = new Node(value);
    if(list.head == null){
      list.head = newNode;
      list.tail = newNode;
      list.length = 1;
    }
    else{
      list.tail.next = newNode;
      list.tail = newNode;
      list.length++;
    }
      return list;
  }
  
  //Add new node in the beginning of the linked list
  public LinkedList prepend(LinkedList list,int value){
	  Node newNode = new Node(value);
	  if(list.head == null){
	      list.head = newNode;
	      list.tail = newNode;
	      list.length = 1;
	    }
	    else{
	    	newNode.next = list.head;
	    	list.head = newNode;
	    	list.length++;
	    }
    return list;
  }
  
  //Add new node at the given index in the linked list
  public LinkedList insert(LinkedList list,int index,int value){
	  Node newNode = new Node(value);
	  if(index >= list.length) {
		  append(list,value);
		  }
	  else if(index == 0) {
		  prepend(list,value);
		  }
	  else {
		  Node currentNode = traverse(list,index);
		  newNode.next = currentNode.next;
		  currentNode.next = newNode;
		  list.length++;
	  }
    return list;
  }
  
  //Remove the element at the given index
  public LinkedList remove(LinkedList list,int index){
	  if(index >= list.length) {return null;}
	  if(index == 0) {
		  if(list.length > 1) {
			  list.head = list.head.next;
			  list.length--;
			  }
		  else {
			  list.head = null;
			  list.length--;
			  }
		  }
	  else {
		  Node currentNode  = traverse(list,index);
		  currentNode.next = currentNode.next.next;
		  list.length--;
	  }
    return list;
  }
  //Traverse the list
  public Node traverse(LinkedList list,int index){
	  Node currentNode = list.head;
	  for(int i = 1; i < index;i++) {
		  currentNode = currentNode.next;
	  }
	  return currentNode;
  }
}
