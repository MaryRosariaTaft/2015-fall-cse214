/**
 * Mary R. Taft
 * 110505413
 * CSE 214 (2)
 * TA: Mingchen Zhang
 */

import java.io.*;
import java.util.*;

/**
 * This is a generic stack.
 */
public class Stack<E>{

    private Node<E> top = new Node(null);
    private int size = 0;

    //no constructor

    public int size(){
	return size;
    }

    public boolean isEmpty(){
	return size == 0;
    }

    public E peek() throws EmptyStackException{
	if(size == 0){
	    throw new EmptyStackException();
	}else{
	    return top.getNext().getData();
	}
    }

    public E pop() throws EmptyStackException{
	if(size == 0){
	    throw new EmptyStackException();
	}else{
	    E data = top.getNext().getData();
	    top.setNext(top.getNext().getNext());
	    size--;
	    return data;
	}

    }

    public E push(E data){
	Node n = new Node(data);
	n.setNext(top.getNext());
	top.setNext(n);
	size++;
	return data;
    }

    public String toString(){
	if(size == 0)
	    return "[[empty stack]]";
	String str = "top -> ";
	Node<E> current = top.getNext();
	while(current.getNext() != null){
	    str += current.getData() + " -> ";
	    current = current.getNext();
	}
	str += current.getData();
	return str + " -> bottom";
    }

    private static class Node<E>{
	private E data;
	private Node<E> next;
	private Node(E data){this.data = data; next = null;}
	private E getData(){return data;}
	private void setData(E data){this.data = data;}
	private Node<E> getNext(){return next;}
	private void setNext(Node<E> next){this.next = next;}
    }

    // public static void main(String[] args){
    // 	Stack<Integer> s = new Stack<Integer>();
    // 	s.push(5);
    // 	s.push(3);
    // 	s.push(1);
    // 	System.out.println("toString: " + s);
    // 	System.out.println("peek: " + s.peek());
    // 	System.out.println("pop: " + s.pop() + ", " + s);
    // }

}
