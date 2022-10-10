/*
 * @author Niloufar Zafari 
 * CMSC204 A2
 */
public class Notation {

	public static String convertInfixToPostfix(String a) {
		MyStack<String> postFixS = new MyStack<String>(a.length());
		MyQueue<String> postFixQ = new MyQueue<String>(a.length());

		char[] infix = a.toCharArray();
		String postFix = "";
		try {
			for (int i = 0; i < infix.length; i++) {
				// if(infix[i] == ' ') {
				// continue;
				// }
				if (Character.isDigit(infix[i])) {
					postFixQ.enqueue(String.valueOf(infix[i]));
				} else if (infix[i] == '(') {
					postFixS.push(String.valueOf(infix[i]));
				} else if (infix[i] == '+' || infix[i] == '-') {

					if (!postFixS.isEmpty() && (postFixS.top().equals("+") || postFixS.top().equals("-")
							|| postFixS.top().equals("/") || postFixS.top().equals("*"))) {
						while (postFixS.top().equals("+") || postFixS.top().equals("-") || postFixS.top().equals("/")
								|| postFixS.top().equals("*")) {
							postFixQ.enqueue(postFixS.pop());
						}
					}
					postFixS.push(String.valueOf(infix[i]));
				} else if (infix[i] == '/' || infix[i] == '*') {
					if (!postFixS.isEmpty() && (postFixS.top().equals("/") || postFixS.top().equals("*"))) {
						while ((postFixS.top().equals("/") || postFixS.top().equals("*"))) {
							postFixQ.enqueue(postFixS.pop());
						}
					}
					postFixS.push(String.valueOf(infix[i]));
				} else if (infix[i] == ')') {
					while (!(postFixS.isEmpty()) && !(postFixS.top().equals("("))) {

						postFixQ.enqueue(postFixS.pop());
					}

					if (postFixS.isEmpty()) {
						throw new InvalidNotationFormatException();
					} else if (postFixS.top().equals("(")) {
						postFixS.pop();
					}

				}
			}

			while (!postFixS.isEmpty() && !postFixS.top().equals("(")) {
				postFixQ.enqueue(postFixS.pop());
			}

		} catch (InvalidNotationFormatException c) {
			c.printStackTrace();
		} catch (StackOverflowException c) {
			c.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return postFixQ.toString();

	}

	public static String convertPostfixToInfix(String a) {
		MyStack<String> stack = new MyStack<String>(a.length());
		MyQueue<String> postFixQ = new MyQueue<String>(a.length());
		String result = "";
		char[] postfix = a.toCharArray();
		for (int i = 0; i < postfix.length; i++) {
			if (postfix[i] == ' ') {
				continue;
			}
			if (Character.isDigit(postfix[i])) {
				stack.push(String.valueOf(postfix[i]));
			}
			if (postfix[i] == '/' || postfix[i] == '*' || postfix[i] == '+' || postfix[i] == '-') {
				try {
					String temp1 = stack.pop();
					String temp2 = stack.pop();
					String temp3 = "(" + temp2 + String.valueOf(postfix[i]) + temp1 + ")";
					stack.push(temp3);
				} catch (StackUnderflowException e) {
					e.getMessage();
				}

			}
		}
		return stack.toString();
	}

	public static double evaluatePostfixExpression(String a) {
		MyStack<String> stack = new MyStack<String>(a.length());

		
		char[] postfix = a.toCharArray();

		try {
			for (int i = 0; i < postfix.length; i++) {

			//	if (postfix[i] == ' ') {
				//	continue;}

				if ( Character.isDigit(postfix[i])) {
					stack.push(String.valueOf(postfix[i]));}
				

				else if (postfix[i] == '/') {
					if (stack.size() < 1) {
						throw new InvalidNotationFormatException();
					}
						String temp2 = stack.pop();
						String temp1 = stack.pop();

						double post = Double.parseDouble(temp1)/Double.parseDouble(temp2);
						stack.push(String.valueOf(post));				
			}
				else if( postfix[i] == '*') {
					if (stack.size() < 1) {
						throw new InvalidNotationFormatException();
					}
					String temp2 = stack.pop();
					String temp1 = stack.pop();
					double post = Double.parseDouble(temp1)*Double.parseDouble(temp2);
					stack.push(String.valueOf(post));


				}
				else if (postfix[i] == '+') {
					if (stack.size() < 1) {
						throw new InvalidNotationFormatException();
					}
					String temp2 = stack.pop();
					String temp1 = stack.pop();
					double post = Double.parseDouble(temp1)+Double.parseDouble(temp2);
					stack.push(String.valueOf(post));


				}
				else if(postfix[i] == '-') {
					if (stack.size() < 1) {
						throw new InvalidNotationFormatException();
					}
					String temp2 = stack.pop();
					String temp1 = stack.pop();
					double post = Double.parseDouble(temp1)-Double.parseDouble(temp2);
					stack.push(String.valueOf(post));


				}
				
					}}
		catch (InvalidNotationFormatException e) {
			e.getMessage();
		}
		 catch (StackUnderflowException e) {
			e.getMessage();
		} catch (Exception e) {
			e.getMessage();
		}

		return Double.parseDouble(stack.pop());

	}

}
