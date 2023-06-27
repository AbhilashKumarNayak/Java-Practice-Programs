package programs;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String exp1 = "[(])";
        String exp2 = "[(])";

        boolean isBalanced1 = checkBalancedBrackets(exp1);
        boolean isBalanced2 = checkBalancedBrackets(exp2);

        System.out.println(exp1 + " is " + (isBalanced1 ? "Balanced" : "Not Balanced"));
        System.out.println(exp2 + " is " + (isBalanced2 ? "Balanced" : "Not Balanced"));
    }

    private static boolean checkBalancedBrackets(String exp) {
        Stack<Character> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                        (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

