import java.io.*;
import java.util.*;

public class Quicksorter<E> implements Sorter<E>{

    //ArrayLists are used instead of arrays
    //because of generic implementation and type erasure
    Comparator<E> c;
    ArrayList<E> list;

    public Quicksorter(Comparator<E> c, ArrayList<E> list){
	this.c = c;
	this.list = list;
    }

    public void sort(){
	quicksort(0, list.size()-1);
    }

	//c.compare(list.get(0), list.get(1));
    private void quicksort(int first, int last){
	if(first >= last) return;
	int left = first, right = last;
	E pivot;
	pivot = list.get((first+last)/2);
	while(left <= right){
	    //convert to comparator stuff
	    while(c.compare(list.get(left), pivot) < 0) left++;
	    while(c.compare(list.get(right), pivot) > 0) right--;
	    if(left <= right)
		swap(left++, right--);
	}
	quicksort(first, right);
	quicksort(left, last);
    }

    private void swap(int indexA, int indexB){
	E temp = list.get(indexA);
	list.set(indexA, list.get(indexB));
	list.set(indexB, temp);
    }

    public void setComparator(Comparator<E> c){
	this.c = c;
    }


}
