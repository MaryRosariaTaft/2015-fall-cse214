import java.io.*;
import java.util.*;

public class BinaryTreeNodeImpl<E extends Comparable<E>> implements BinaryTreeNode<E>{

    E data;
    BinaryTreeNode<E> parent = null;
    BinaryTreeNode<E> left = null;
    BinaryTreeNode<E> right = null;

    public BinaryTreeNodeImpl(E data){
	this.data = data;
    }

    public E getData(){
	return data;
    }

    public void setData(E data){
	this.data = data;
    }

    public BinaryTreeNode<E> getParent(){
	return parent;
    }

    public void setParent(BinaryTreeNode<E> node){
	parent = node;
    }

    public BinaryTreeNode<E> getLeft(){
	return left;
    }

    public void setLeft(BinaryTreeNode<E> node){
	left = node;
    }

    public BinaryTreeNode<E> getRight(){
	return right;
    }

    public void setRight(BinaryTreeNode<E> node){
	right = node;
    }

    public void removeFromParent(){
	if(this == parent.getLeft()){
	    parent.setLeft(null);
	}else{
	    parent.setRight(null);
	}
    }

}