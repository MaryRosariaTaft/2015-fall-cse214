import java.io.*;
import java.util.*;

public class UniLinkedList<E>{

    //note: the Node and Cursor classes are nested
    //in this class, at the end of this file.
    private Node<E> head = new Node(null); //dummy node
    private Cursor cursor = new Cursor(this);
    private int size = 0;


    //NO CONSTRUCTOR


    //METHODS:

    public E head(){
    	return head.getData();
    }

    public int size(){
	return size;
    }

    public boolean isEmpty(){
	return head.getNext() == null;
	//or return size == 0;
    }

    public void clear(){
	head.setNext(null);
	size = 0;
	return;
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
	//would be more incrementally more efficient without
	//the extra method call, but...
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

    //either returns true or throws exception
    //(thus, in what case would this return false?)
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
    	throw new NoSuchElementException(mark.toString() + " is not present in this UniLinkedList, " + this);
    }

    //in what case would this return false?
    public boolean addFirst(E element){
	Node<E> nodeToAdd = new Node<E>(element);
	nodeToAdd.setNext(head.getNext());
	head.setNext(nodeToAdd);
	size++;
    	return true;
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
	//could alternately add an if-case *before* the while loop:
	//if(!contains(element)) return false;
	//however, the following lines located *after* the loop act equivalently:
	System.out.println("remove(E element): cannot remove '" + element + "' from this UniLinkedList, " + this + ", because it is not present");
    	return false;
    }

    //would be more useful if return type were an int,
    //indicating the num times element was removed
    public boolean removeAll(E element){
	if(!contains(element)){
	    System.out.println("removeAll(E element): cannot remove '" + element + "' from this UniLinkedList, " + this + ", because it is not present");
	    return false;
	}
	while(contains(element)){
	    remove(element);
	}
	return true;
    }

    //maintains the *first* instance of a Node with any given element--
    //--thus, I didn't factor out code by using the remove() method, which
    //removes the first instance of aforementioned Node (as opposed to the last)
    //(except in the final case, because if the two Nodes of equivalent data
    //are adjacent, it doesn't matter which of the two is removed; so I did use remove())
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
	//account for last Node in iteration
	if(alreadyHas(current)){
	    preceding.setNext(current.getNext());
	    current = current.getNext();
	    size--;
	}
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


    //GETTERS & SETTERS:

    //for 'size':
    //no getSize() method; already have size()
    //set setSize(int newSize) method; that would be horrendous

    //for 'head':
    //not getHead() method, because it would be useless outside of UniLinkedList,
    //because Nodes can't be instantiated aboutside of UniLinkedList
    //no setHead(Node<E> newHead) method; that would also be horrendous

    //for 'cursor':
    public Cursor getCursor(){return cursor;} //finally!
    //in lieu of a setCursor(Node<E> position) method:
    public void resetCursorToHead(){cursor.resetPositionToHead(this);}
    //note on the above method: I broke the rules, I have a public method which
    //isn't listed in the API
    //reasons for breaking the rules:
    //In this assignment, iteration through UniLinkedLists *besides* 'this'
    //is required in many instances--not only for the equals() method here,
    //but also in centroid(), smallest(), largest(), etc. in Point2D
    //I do not know how to iterate otherwise.
    //(I *would've* been able to iterate Node-by-Node; however,
    //since the Node class is private, nested within this class,
    //Nodes can't be instantiated in, for example, Point2D.)


    //OVERRIDING METHODS:

    //should this have the @Override annotation?
    public boolean equals(Object obj){
	if(this == obj){
	    // System.out.println("same object");
	    return true;
	}
	if(obj instanceof UniLinkedList){
	    // System.out.println("obj is of type UniLinkedList");
	    UniLinkedList that = (UniLinkedList)obj;
	    if(this.isEmpty() || that.isEmpty()){
		if(this.isEmpty() && that.isEmpty()){
		    // System.out.println("both lists are empty");
		    return true;
		}
		// System.out.println("one list is empty, one is not");
		return false;
	    }
	    Object a = this.cursor.next();
	    Object b = that.cursor.next();
	    // System.out.println("this cursor's head: " + a);
	    // System.out.println("that cursor's head: " + b);
	    while(this.cursor.hasNext() && that.cursor.hasNext()){
		Object tmp1 = this.cursor.next(); //automatically increments position
		Object tmp2 = that.cursor.next();
		// System.out.println("this cursor's data (tmp1): " + tmp1);
		// System.out.println("that cursor's data (tmp2): " + tmp2);
		if(!tmp1.equals(tmp2)){
		    // System.out.println("tmp1 and tmp2 are not equal");
		    this.resetCursorToHead();
		    that.resetCursorToHead();
		    return false;
		}
	    }
	    if(this.cursor.hasNext() || that.cursor.hasNext()){
		// System.out.println("one of the lists still has elements");
		this.resetCursorToHead();
		that.resetCursorToHead();
		return false;
	    }
	    // System.out.println("the lists are equal");
	    this.resetCursorToHead();
	    that.resetCursorToHead();
	    return true;
	}
	//if obj is not even of type UniLinkedList
	return false;
    }

    @Override
    public int hashCode(){
	return head != null ? head.hashCode() : 0;
    }

    //should this also have the @Override annotation?
    public String toString(){
	if(size == 0)
	    return "[[emptyUniLinkedList]]";
	String str = "(";
	Node<E> current = head.getNext();
	while(current.hasNext()){
	    str += current.getData() + " -> ";
	    current = current.getNext();
	}
	str += current.getData();
	return str + ")";
    }
    

    //NESTED CLASSES:

    //note about static nested classes
    //(from http://docs.oracle.com/javase/tutorial/java/javaOO/nested.html):
    /*
      "A static nested class interacts with the
      instance members of its outer class (and other classes)
      just like any other top-level class. In effect, a
      static nested class is behaviorally a top-level class
      that has been nested in another top-level class
      for packaging convenience."
    */

    private static class Node<E>{
	private E data;
	private Node<E> next;
	//constructor
	private Node(E data){this.data = data; next = null;}
	//getters&setters&such
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
	//could've made life easier by putting a toString() in here, but
	//it's not in the API, so I hesistated to add a public method
    }
    
    public static class Cursor<E>{
	private Node<E> position;
	//constructor
	private Cursor(UniLinkedList<E> list){position = list.head;}
	//methods
	public boolean hasNext(){return position.hasNext();}
	//how next() works:
	//changes 'position' to the next Node
	//*but* returns data of the *original* Node
	//(based on the way next() works in the Iterator class)
	//In the case that 'position' is already the last Node,
	//next() will return the data of that last Node,
	//and 'position' will not be changed.
	public E next(){
	    if(hasNext()){
		E tmp = position.getData();
		position = position.getNext();
		return tmp;
	    }
	    // System.out.println("in next() in class Cursor: already at last element; returning data of last element without changing position");
	    return position.getData();
	}
	private void resetPositionToHead(UniLinkedList<E> list){
	    position = list.head;
	}
    }

}
