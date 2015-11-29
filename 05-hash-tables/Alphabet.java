import java.io.*;
import java.util.*;

public class Alphabet implements Hashable{

    private Character c;

    public Alphabet(Character c){
	if((int)c > 96 && (int)c < 123)
	    this.c = c;
	else
	    throw new IllegalArgumentException();
    }

    /**
     * ROT-13's Character c,
     * converts it to its ASCII value,
     * and returns that value as indexed from 0
     * (thus, a value from 0 to 25
     * as opposed to 97-122).
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
    // }

}
