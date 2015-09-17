import java.io.*;
import java.util.*;

public class UniLinkedList<E>{

    //note: 'head' is a dummy node

    private Node<E> head = new Node(null);
    private Cursor cursor = new Cursor(this); //???
    private int size = 0;

    //unfinished
    public boolean equals(Object obj){
	if(this == obj)
	    return true;
	if(obj instanceof UniLinkedList){ //<E>???
	    UniLinkedList that = (UniLinkedList)obj;
	    boolean areEqual = false;
	    //???UNFINISHED
	    return areEqual;
	}
	return false;
    }

    public boolean isEmpty(){
	return head.getData() == null;
    }

    public void clear(){
	head.setData(null);
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
	//would be more efficient without the extra method call but
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
		//do adding/pointer stuff
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
	Node<E> current = head.getNext();
	Node<E> preceding = head;
	//could probably condense here
	if(current.getData().equals(element)){
	    preceding.setNext(current.getNext());
	    size--;
	    return true;
	}
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
	Object[] stack = new Object[size];
	Node<E> current = head;
	while(current.hasNext()){
	    current = current.getNext();
	}
    	return;
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
	    str += current.getData().toString() + " -> ";
	    current = current.getNext();
	}
	str += current.getData().toString();
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
    
    public static class Cursor<E>{
	private Node<E> position; //Node???
	//possibly add int field index
	private Cursor(UniLinkedList<E> list){position = list.head;}
	public boolean hasNext(){return position.hasNext();}
	public E next(){return position.getNext().getData();}
    }

}
