


class Queue {
	Node first,last;
	int length;
	Queue(){
		this.first = null;
		this.last = null;
		this.length = 0;
		}
	class Node{
		String data;
		Node next;

	    Node(String value){
	      data = value;
	      next = null;
	      }
	    }
	//Method to return the first element of the queue
	public String peek() {
		return this.first.data;
	}
	//Enqueue method to insert element in the last of the queue
	public Queue enqueue(Queue queue, String value) {
		Node newNode = new Node(value);
		if(isEmpty(queue)) {
			queue.first = newNode;
			queue.last = newNode;
		}
		else {
			queue.last.next = newNode;
			queue.last = newNode;
		}
		queue.length++;
		return queue;
	}
	//Dequeue method to remove element from the first position of the queue
	public Queue dequeue(Queue queue) {
		if(isEmpty(queue)) {return null;}
		queue.first = queue.first.next;
		queue.length--;
		return queue;
	}
	//Method to check if the queue is empty
	public boolean isEmpty(Queue queue) {
		if(queue.length == 0)return true;
		else {return false;}
	}
	//Method to Print the queue
	public void printQueue(Queue queue) {
		Node currentNode = queue.first;
		while(currentNode != null) {
			System.out.print(currentNode.data + " \n");
			currentNode = currentNode.next;
		}
	}
	
}
