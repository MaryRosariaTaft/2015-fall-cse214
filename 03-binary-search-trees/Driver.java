import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[] args){

	BinaryTreeNodeImpl<Integer> n1 = new BinaryTreeNodeImpl<Integer>(0, null);
	BinaryTreeNodeImpl<Integer> n2 = new BinaryTreeNodeImpl<Integer>(0, null);
	print(n2.compareTo(n1));

	BinarySearchTree<Integer> t1 = new BinarySearchTree<Integer>();
	t1.add(0);
	BinarySearchTree<Integer> t2 = new BinarySearchTree<Integer>();
	t2.add(1);
	print(t1.compareTo(t2));

    }

    public static void print(Object s){
	System.out.println(s);
    }

}
