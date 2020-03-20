package oclab1;

import java.util.ArrayList;

public class Stack {
	ArrayList<String> stack =new ArrayList<String>();

	public void push(String element) {
		stack.add(element);
	}

	public String pop() {
		String element = (String) stack.get(stack.size()-1);
		return element;
	}
}
