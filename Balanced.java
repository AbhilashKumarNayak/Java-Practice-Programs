package programs;

import java.util.Stack;

public class Balanced {

	public static void main(String[] args) {

		String input = "{[](){}";

		Stack<Character> stack = new Stack<>();

		char[] charArray = input.toCharArray();

		for (int i = 0; i < charArray.length; i++) {

			if (charArray[i] == '(' || charArray[i] == '{' || charArray[i] == '[') {
				stack.push(charArray[i]);
			} 
			else  {
				if (stack.isEmpty()) {
					System.err.println("not balanced");
					System.exit(0);
				}
				
				char top=stack.peek();
				if (charArray[i] == ')' && top != '(' || charArray[i] == '}' && top != '{'
						|| charArray[i] == ']' && top != '[') 
				{
					System.err.println("not balanced");
					System.exit(0);
				}
			}
			
		}
		System.out.println("balanced");
	}

}
