import java.io.*;
import java.util.*;

public class Quicksorter<E> implements Sorter<E>{

    Comparator<E> comp;
    ArrayList<E> list;

    public Quicksorter(Comparator<E> comp, ArrayList<E> list){
	this.comp = comp;
	this.list = list;
    }

    //use ArrayLists, not arrays (because of generic implementation and type erasure)
    //get(int index) & set(int index, E element)
    public void sort(){

    }

    public void setComparator(Comparator<E> comp){
	this.comp = comp;
    }


}
