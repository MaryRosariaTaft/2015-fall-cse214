import java.io.*;
import java.util.*;

public class PostfixEvaluator{

    public static int evaluate(char[] postfix){
	return 0;
    }

    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	boolean done = false;
	InfixToPostfixConverter converter = new InfixToPostfixConverter();
	print("\nThis program evaluates limited arithmetic infix expressions.");
	print("It only takes single-digit numbers and the operators +, -, *, and /.");
	print("Note: Multiplication only works with the explicit use of the * operator;");
	print("adjacent parenthetical expressions won't imply multiplication.");
	print("Enter one expression per line, upon prompting, for evaluation.");
	print("Values will not be carried from one line to another.");
    	print("When you're finished and want to exit, enter 'q' or 'Q'.");
	print("\nEnter an infix expression: ");
    	while(!done){
    	    String str = sc.nextLine();
    	    if(str.toLowerCase().contains("q")){
    		done = true;
    	    }else{
		str = str.replaceAll("\\s",""); //remove all white space
		char[] infix = str.toCharArray();
		str = converter.convert(infix);
		str = str.replaceAll("\\s","");
		char[] postfix = str.toCharArray();
		print("= " + evaluate(postfix));
    		print("\nEnter another infix expression or type 'q' or 'Q' to quit: ");
    	    }
    	}
    }
	    
    private static void print(Object data){
	System.out.println(data);
    }

}
