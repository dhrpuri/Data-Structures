

class Stack {
	Node top,bottom;
	int length;
	Stack(){
		this.top = null;
		this.bottom = null;
		this.length = 0;
		}
	class Node{
		int data;
		Node previous;

	    Node(int value){
	      data = value;
	      previous = null;
	      }
	    }
	//return the top of the stack
	public int peek(Stack stack) {
		if(stack.top == null) {
			return 0;
		}
		else {
			return stack.top.data;
		}
	}
	//insert an element on top of the stack
	public Stack push(Stack stack,int value) {
		Node newNode = new Node(value);
		if(stack.top == null) {
			stack.top = newNode;
			stack.bottom = newNode;
		}
		else {
			newNode.previous = stack.top;
			stack.top = newNode;
		}
		stack.length++;
		return stack;
	}
	//delete the element on the top of the stack
	public Stack pop(Stack stack) {
		if(stack.top == null) {
			return null;
		}
		else {
			stack.top = stack.top.previous;
			stack.length--;
		}
		return stack;
	}
	
	public void printStack(Stack stack) {
		Node currentNode = stack.top;
		System.out.print("Stack: ");
		while(currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.previous;
		}
	}
}
