import java.io.*;
import java.util.*;

public class BinaryTreeNodeImpl<E extends Comparable<E>> implements BinaryTreeNode<E>, Comparable<BinaryTreeNodeImpl<E>>{

    E data;
    BinaryTreeNodeImpl<E> parent = null;
    BinaryTreeNodeImpl<E> left = null;
    BinaryTreeNodeImpl<E> right = null;

    public BinaryTreeNodeImpl(E data){
	this.data = data;
    }

    public E getData(){
	return data;
    }

    public void setData(E data){
	this.data = data;
    }

    public BinaryTreeNodeImpl<E> getParent(){
	return parent;
    }

    public void setParent(BinaryTreeNodeImpl<E> node){
	parent = node;
    }

    public BinaryTreeNodeImpl<E> getLeft(){
	return left;
    }

    public void setLeft(BinaryTreeNodeImpl<E> node){
	left = node;
    }

    public BinaryTreeNodeImpl<E> getRight(){
	return right;
    }

    public void setRight(BinaryTreeNodeImpl<E> node){
	right = node;
    }

    public void removeFromParent(){
	if(this == parent.getLeft()){
	    parent.setLeft(null);
	}else{
	    parent.setRight(null);
	}
    }

    public int compareTo(BinaryTreeNodeImpl<E> node){
	return data.compareTo(node.getData());
    }

}
