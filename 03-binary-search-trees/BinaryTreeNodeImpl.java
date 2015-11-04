/**
 * Mary R. Taft
 * 110505413
 * CSE 214 (3)
 * TA: Mingchen Zhang
 */

import java.io.*;
import java.util.*;

/**
 * This is an implementation of BinaryTreeNode.
 * It contains no methods beyond those required by its interface.
 * The data each BinaryTreeNodeImpl holds may be of any Comparable type.
 */
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
