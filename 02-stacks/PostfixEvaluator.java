import java.io.*;
import java.util.*;

public class PostfixEvaluator{

    public static int evaluate(char[] postfix) throws IllegalArgumentException{
	Stack<Integer> operands = new Stack<Integer>();
	for(int i = 0; i < postfix.length; i++){
	    if("0123456789".contains(String.valueOf(postfix[i]))){
		operands.push(Character.getNumericValue(postfix[i]));
	    }else if("+=*/".contains(String.valueOf(postfix[i]))){
		int operand2 = operands.pop();
		int operand1 = operands.pop();
		switch(postfix[i]){
		case '+':
		    operands.push(operand1 + operand2);
		    break;
		case '-':
		    operands.push(operand1 - operand2);
		    break;
		case '*':
		    operands.push(operand1 * operand2);
		    break;
		case '/':
		    operands.push(operand1 / operand2);
		    break;
		}
	    }else{
		throw new IllegalArgumentException();
	    }
	}
	return operands.pop();
    }

    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	boolean done = false;
	InfixToPostfixConverter converter = new InfixToPostfixConverter();
	print("\nThis program evaluates limited arithmetic infix expressions.");
	print("It only takes single-digit numbers and the operators +, -, *, and /.");
	print("(Note: Multiplication only works with the explicit use of the * operator;");
	print("adjacent parenthetical expressions won't imply multiplication.)");
	print("\nAdditionally, if you enter multiple operands in sequence without operators");
	print("between them, the program won't reprimand you or break (as it should),");
	print("but will instead act glitchily.  So, please enter expressions properly.");
	print("\nValues will not be carried from one line to another;");
	print("you cannot begin a new expression with an operator expecting");
	print("it to act upon the value of the previous expression.");
	print("\nEnter one expression per line, upon prompting, for evaluation.");
    	print("When you're finished and want to exit, enter 'q' or 'Q'.");
	print("\nEnter an infix expression: ");
    	while(!done){
    	    String str = sc.nextLine();
    	    if(str.toLowerCase().contains("q")){
    		done = true;
    	    }else{
		str = str.replaceAll("\\s",""); //remove all white space
		// print("without white spaces: " + str);
		char[] infix = str.toCharArray();
		// print("infix: " + Arrays.toString(infix));
		str = converter.convert(infix);
		str = str.replaceAll("\\s","");
		char[] postfix = str.toCharArray();
		// print("postfix: " + Arrays.toString(postfix));
		print("= " + evaluate(postfix));
    		print("\nEnter another infix expression or enter 'q' or 'Q' to quit: ");
    	    }
    	}
    }
	    
    private static void print(Object data){
	System.out.println(data);
    }

}
