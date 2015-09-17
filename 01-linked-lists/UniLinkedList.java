import java.io.*;
import java.util.*;

public class UniLinkedList<E>{

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
	//more efficient without the extra method call but
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
		return true;
	    }
	}
    	return false;
    }

    //unfinished
    // public boolean addFirst(E element){
    // 	return;
    // }

    public E head(){
    	return head.getData();
    }

    //unfinished
    // public boolean remove(E element){
    // 	return;
    // }

    // public boolean removeAll(E element){
    // 	return;
    // }

    // public void deduplicate(){
    // 	return;
    // }

    @Override
    public int hashCode(){
	return head != null ? head.hashCode() : 0;
    }

    public String toString(){
	String str = "";
	if(size == 0) return "";
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
