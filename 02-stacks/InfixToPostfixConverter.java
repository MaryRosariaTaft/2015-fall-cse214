import java.io.*;
import java.util.*;

public class InfixToPostfixConverter{

    public static String convert(char[] infix) throws IllegalArgumentException{
	String postfix = "";
	Stack<Character> operators = new Stack<Character>();
	for(int i = 0; i < infix.length; i++){
	    if("0123456789".contains(String.valueOf(infix[i]))){
		postfix += infix[i] + " ";
	    }else if("+-*/".contains(String.valueOf(infix[i]))){
		operators.push(infix[i]);
	    }else if(infix[i] == ')'){
		postfix += operators.pop() + " ";
	    }else if(infix[i] == '('){
		continue;
	    }else{
		throw new IllegalArgumentException();
	    }
	}
	return postfix;
    }

    public static void main(String[] args){
	char[] infix = {'(', '(', '2', '+', '3', ')', '*', ')'};
	System.out.println(convert(infix));
    }

}
