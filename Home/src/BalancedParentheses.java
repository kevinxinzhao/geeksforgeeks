import java.util.Stack;

//Given an expression string exp, write a program to examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp. 
//For example, the program should print true for exp = “[()]{}{[()()]()}” and false for exp = “[(])”
public class BalancedParentheses {

	public static void main(String[] args) {
		checkBalanceOfParenthese("({()}))");
	}

	public static void checkBalanceOfParenthese(String sentence) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < sentence.length(); i++) {
			if (stack.isEmpty()) {
				System.out.println("Doesn't match!");
				return;
			}
			char c = sentence.charAt(i);
			if (c == '(' || c == '{' || c == '[' || c == '<') {
				stack.add(c);
			}
			if (c == ')' || c == '}' || c == ']' || c == '>') {
				char topChar = stack.pop();
				if ((topChar == '(' && c == ')') || (topChar == '{' && c == '}') || (topChar == '[' && c == ']') || (topChar == '<' && c == '>')) {

				} else {
					System.out.println("Doesn't match!");
					return;
				}
			}
		}
		if (stack.isEmpty() != true) {
			System.out.println("Doesn't match!");
			return;
		}
		System.out.println("Match!");
		return;
	}
}
