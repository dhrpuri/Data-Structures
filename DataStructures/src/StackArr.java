

import java.util.ArrayList;

import java.util.List;

class StackArr {
	List<String> stack = new ArrayList<>();
	int length;
	
	public void push(String value) {
		stack.add(value);
		length = stack.size();
		}
	public void pop() {
		stack.remove(stack.size() -1);
		length = stack.size();
	}
	public String peek() {
		return stack.get(stack.size() - 1);
	}
	public void printStack() {
		int count = stack.size() - 1;
		for(int i = count;i>=0;i--) {
			System.out.println((String) stack.get(i));	
			}
	}
}
