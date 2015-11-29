/**
 * Mary R. Taft
 * 110505413
 * CSE 214 (5)
 * TA: Mingchen Zhang
 */
import java.io.*;
import java.util.*;

/**
 * This Hashable class holds a single lowercase letter from 'a' to 'z'.
 * Its hash method's output is dependent on the letter which it holds.
 */

public class Alphabet implements Hashable{

    private Character c;

    public Alphabet(Character c){
	if((int)c < 97 || (int)c > 122)
	    throw new IllegalArgumentException();
	this.c = c;
    }

    /**
     * Returns a value from 0 to 25
     * corresponding to c's ROT-13'd index.
     * (e.g., 'n' returns 0, and 'a' 13).
     */
    public int hash(){
	return ((int)c - 84) % 26;
    }

    @Override
    public String toString(){
	return Character.toString(c);
    }

    // public static void main(String[] args){
    // 	Alphabet a = new Alphabet('a');
    // 	Alphabet n = new Alphabet('n');
    // 	System.out.println("a: " + a.hash());
    // 	System.out.println("n: " + n.hash());
    // 	//the following should be invalid
    // 	Alphabet excl = new Alphabet('!');
    // 	System.out.println("!: " + excl.hash());
    // }

}
