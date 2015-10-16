/**
 * Mary R. Taft
 * 110505413
 * CSE 214 (2)
 * TA: Mingchen Zhang
 */

import java.io.*;
import java.util.*;

/**
 * This class contains a method which evaluates a postfix expression.
 * It also contains the main method of this program.
 */
public class PostfixEvaluator{

    public static int evaluate(char[] postfix) throws IllegalArgumentException{
	Stack<Integer> operands = new Stack<Integer>();
	for(int i = 0; i < postfix.length; i++){
	    if("0123456789".contains(String.valueOf(postfix[i]))){
		operands.push(Character.getNumericValue(postfix[i]));
	    }else if("+-*/".contains(String.valueOf(postfix[i]))){
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
	InFixToPostfixConverter converter = new InFixToPostfixConverter();
	print("\nThis program evaluates limited arithmetic infix expressions.");
	print("It only takes single-digit numbers and the operators +, -, *, and /.");
	print("\nMultiplication only works with the explicit use of the * operator;");
	print("adjacent parenthetical expressions won't imply multiplication.");
	print("\nIf you enter multiple operators in sequence, the program will break;");
	print("but if you enter multiple *operands* in sequence, the program will");
	print("neither reprimand you nor break (as it should), but will instead");
	print("act glitchily.  Please enter expressions properly.");
	print("\nValues will not be carried from one line to another;");
	print("you cannot begin a new expression with an operator expecting");
	print("it to act upon the value of the previous expression.");
	print("\nEnter one expression per line, upon prompting, for evaluation.");
    	print("When you're finished and want to exit, enter 'q', 'Q', or 'exit'.");
	print("\nEnter an infix expression: ");
    	while(!done){
    	    String str = sc.nextLine();
    	    if(str.toLowerCase().contains("q") || str.toLowerCase().equals("exit")){
    		done = true;
    	    }else{
		str = str.replaceAll("\\s",""); //remove all white space
		// print("without white spaces: " + str);
		char[] infix = str.toCharArray();
		// print("infix: " + Arrays.toString(infix));
		str = converter.convert(infix);
		print("= " + str);
		str = str.replaceAll("\\s","");
		char[] postfix = str.toCharArray();
		// print("postfix: " + Arrays.toString(postfix));
		print("= " + evaluate(postfix));
    		print("\nEnter another infix expression or 'q', 'Q', or 'exit' to exit: ");
    	    }
    	}
    }
	    
    private static void print(Object data){
	System.out.println(data);
    }

}
