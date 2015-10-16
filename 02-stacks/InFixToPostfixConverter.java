/**
 * Mary R. Taft
 * 110505413
 * CSE 214 (2)
 * TA: Mingchen Zhang
 */

import java.io.*;
import java.util.*;

/**
 * This class contains a method which converts an infix expression to a postfix expression.
 * Please see the printlns in the PostfixEvaluator class (or just run the program) regarding this program's limitations.
 */
public class InFixToPostfixConverter{

    public String convert(char[] infix) throws IllegalArgumentException{
	if("+-*/".contains(String.valueOf(infix[0])) || "+-*/".contains(String.valueOf(infix[infix.length-1]))){
	    throw new IllegalArgumentException("cannot begin or end an infix expression with an operator");
	}
	//no balanced parentheses check, but imbalanced parentheses cause an EmptyStackException when trying to evaluate
	String postfix = "";
	Stack<Character> operators = new Stack<Character>();
	operators.push('$');
	for(int i = 0; i < infix.length; i++){
	    if("0123456789".contains(String.valueOf(infix[i]))){
		postfix += infix[i] + " ";
	    }else if(infix[i] == '('){
		operators.push('(');
	    }else if(infix[i] == ')'){
		Character operator = operators.pop();
		while(!operator.equals('(')){
		    postfix += operator + " ";
		    operator = operators.pop();
		}
	    }else if("+-*/".contains(String.valueOf(infix[i]))){
		Character operator = operators.peek();
		while(isGreaterOrEqualPrecedence(operator, infix[i])){
		    postfix += operators.pop() + " ";
		    operator = operators.peek();
		}
		operators.push(infix[i]);
	    }else{
		throw new IllegalArgumentException();
	    }
	}
	Character operator = operators.pop();
	while(!operator.equals('$')){
	    if(precedence(operator) == 1){
		throw new IllegalArgumentException("unbalanced parentheses: closing parenthesis is missing in infix expression");
	    }
	    postfix += operator + " ";
	    operator = operators.pop();
	}
	return postfix;
    }

    //returns true if tokenA is of greater or equal precedence than tokenB
    public boolean isGreaterOrEqualPrecedence(char tokenA, char tokenB){
	return precedence(tokenA) >= precedence(tokenB);
    }

    //returns precedence of token
    public int precedence(char token) throws IllegalArgumentException{
	if(token == '$') return 0;
	if(token == '(') return 1;
	if(token == '+' || token == '-') return 2;
	if(token == '*' || token == '/') return 3;
	throw new IllegalArgumentException("character is not a valid token");
    }

    // public static void main(String[] args){
    // 	char[] infix0 = {'2', '+', '3', '*', '4'};
    // 	char[] infix1 = {'(', '(', '2', '+', '3', ')', '*', '4', ')'};
    // 	char[] infix2 = {'3', '*', '(', '5', '+', '7', ')', '-', '9'};
    // 	char[] infix3 = {'(', '2', '-', '4', ')', '*', '(', '5', '-', '7', ')', '+', '8'};
    // 	System.out.println(convert(infix0));
    // 	System.out.println(convert(infix1));
    // 	System.out.println(convert(infix2));
    // 	System.out.println(convert(infix3));
    // }

}
