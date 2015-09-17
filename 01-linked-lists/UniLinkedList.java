import java.io.*;
import java.util.*;

public class UniLinkedList<E>{

    //note: 'head' is a dummy node
    private Node<E> head = new Node(null);
    private int size = 0;

    //this is much more involved than anticipated
    //'cursor' is used basically as an Iterator class which acts upon the argument 'obj'
    public boolean equals(Object obj){
	//check if this and obj are the same reference
	if(this == obj)
	    return true;
	//check if obj is of type UniLinkedList
	if(obj instanceof UniLinkedList){
	    //cast 'that' to be a UniLinkedList
	    UniLinkedList that = (UniLinkedList)obj;
	    //avoid issues with empty lists
	    if(this.isEmpty() || that.isEmpty()){
		//both are empty:
		if(this.isEmpty() && that.isEmpty())
		    return true;
		//only one is empty:
		return false;
	    }
	    //check list equality for non-empty lists
	    //'cursor' will be used to track elements in 'that'
	    Cursor cursor = new Cursor(that);
	    cursor.next();
	    //'current' will be used to track elements in this
	    Node current = head.getNext();
	    while(current.hasNext() && cursor.hasNext()){
		Object tmp1 = current.getData();
		current = current.getNext();
		Object tmp2 = cursor.next(); //automatically increments cursor's position
		//if there's an inequality of data:
		if(!tmp1.equals(tmp2)){
		    return false;
		}
	    }
	    if(current.hasNext() || cursor.hasNext()){
		//if one list still has remaining elements
		return false;
	    }
	    //neither list has remaining elements and all
	    //elements contained are equivalent, in order
	    return true;
	}
	//if obj is not even of type UniLinkedList
	return false;
    }

    public boolean isEmpty(){
	return head.getNext() == null;
    }

    public void clear(){
	head.setNext(null);
	size = 0;
    }

    public int size(){
	return size;
    }

    public int indexOf(E element){
	Node<E> current = head;
	int index = -1;
	while(current.hasNext()){
	    current = current.getNext();
	    index++;
	    if(current.getData().equals(element)){
		return index;
	    }
	}
	return -1;
    }

    public boolean contains(E element){
	//would be more efficient without the extra method call, but...
	return indexOf(element) != -1;
    }

    //in what case would this return false?
    public boolean add(E element){
	Node<E> current = head;
	while(current.hasNext()){
	    current = current.getNext();
	}
	current.setNext(new Node(element));
	size++;
    	return true;
    }

    public boolean addAfter(E mark, E elementToAdd){
	Node<E> current = head;
	while(current.hasNext()){
	    current = current.getNext();
	    if(current.getData().equals(mark)){
		Node<E> nodeToAdd = new Node<E>(elementToAdd);
		nodeToAdd.setNext(current.getNext());
		current.setNext(nodeToAdd);
		size++;
		return true;
	    }
	}
    	return false;
    }

    //in what case would this return false?
    public boolean addFirst(E element){
	Node<E> nodeToAdd = new Node<E>(element);
	nodeToAdd.setNext(head.getNext());
	head.setNext(nodeToAdd);
	size++;
    	return true;
    }

    public E head(){
    	return head.getData();
    }

    public boolean remove(E element){
	if(size == 0)
	    return false;
	Node<E> current = head;
	Node<E> preceding;
	while(current.hasNext()){	
	    preceding = current;
	    current = current.getNext();
	    if(current.getData().equals(element)){
		preceding.setNext(current.getNext());
		size--;
		return true;
	    }
	}
    	return false;
    }

    //would be more useful if return type were
    //an int, num times element was removed
    public boolean removeAll(E element){
	if(!contains(element))
	    return false;
	while(contains(element)){
	    remove(element);
	}
	return true;
    }

    public void deduplicate(){
	if(size < 2)
	    return;
	Node<E> current = head.getNext();
	Node<E> preceding = head;
	while(current.hasNext()){
	    if(alreadyHas(current)){
		preceding.setNext(current.getNext());
		current = current.getNext();
		size--;
	    }else{
		preceding = current;
		current = current.getNext();
	    }
	}
	if(current.getData().equals(preceding.getData()))
	    remove(current.getData());
	return;
    }

    //helper to deduplicate()
    private boolean alreadyHas(Node<E> node){
	Node<E> checker = head.getNext();
	while(checker != node){
	    if(checker.getData().equals(node.getData()))
		return true;
	    checker = checker.getNext();
	}
	return false;
    }

    @Override
    public int hashCode(){
	return head != null ? head.hashCode() : 0;
    }

    public String toString(){
	String str = "";
	if(size == 0) return "[[empty]]";
	Node<E> current = head.getNext();
	while(current.hasNext()){
	    str += current.getData() + " -> ";
	    current = current.getNext();
	}
	str += current.getData();
	return str;
    }
    
    private static class Node<E>{	
	private E data;
	private Node<E> next;
	private Node(E data){this.data = data; next = null;}
	private E getData(){return data;}
	private void setData(E data){this.data = data;}
	private boolean hasNext(){return next != null;}
	private Node<E> getNext(){return next;}
	private void setNext(Node<E> next){this.next = next;}
	@Override
	public int hashCode(){
	    int result = data != null ? data.hashCode() : 0;
	    return 31 * result + (next != null ? next.hashCode() : 0);
	}
    }
    
    //I don't understand why this is static
    public static class Cursor<E>{
	private Node<E> position;
	private Cursor(UniLinkedList<E> list){position = list.head;}
	public boolean hasNext(){return position.hasNext();}
	//changes position to the next Node but returns data of the original
	//(based on the way next() works in the Iterator class)
	public E next(){
	    if(hasNext()){
		E tmp = position.getData();
		position = position.getNext();
		return tmp;
	    }
	    System.out.println("in next() in class Cursor: already at last element; returning data of last element without changing position");
	    return position.getData();
	    //probably should throw an exception here instead--whoops
	}
    }

}
