import java.io.*;
import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> implements BinaryTree<E>{

    BinaryTreeNodeImpl<E> root;
    Comparator<E> c;

    public BinarySearchTree(Comparator<E> c){
	root = null;
	this.c = c;
    }

    public void add(E element){
	BinaryTreeNodeImpl<E> node = new BinaryTreeNodeImpl<E>(element);
	if(root == null){
	    root = node;
	}else{
	    add(node, root);
	}
    }

    private void add(BinaryTreeNodeImpl<E> node, BinaryTreeNodeImpl<E> subroot){
	if(c.compare(node.getData(), subroot.getData()) == 0){
	    return; //element found; no duplicate added
	}
	if(c.compare(node.getData(), subroot.getData()) < 0){
	    if(subroot.getLeft() == null){
		subroot.setLeft(node);
		node.setParent(subroot);
		return;
	    }else{
		add(node, (BinaryTreeNodeImpl<E>)subroot.getLeft());
	    }
	}else{
	    if(subroot.getRight() == null){
		subroot.setRight(node);
		node.setParent(subroot);
		return;
	    }else{
		add(node, (BinaryTreeNodeImpl<E>)subroot.getRight());
	    }
	}
    }

    public void remove(E element){
	remove(new BinaryTreeNodeImpl<E>(element), root);
    }

    private void remove(BinaryTreeNodeImpl<E> node, BinaryTreeNodeImpl<E> subroot){
	if(subroot == null){
	    return; //element not found
	}
	if(c.compare(node.getData(), subroot.getData()) == 0){
	    // BinaryTreeNodeImpl<E> parent = (BinaryTreeNodeImpl<E>)subroot.getParent();
	    if(subroot.getLeft() == null && subroot.getRight() == null){ //no children
		if(subroot == root){
		    root = null;
		}else if(subroot.getParent().getLeft() == subroot){
		    subroot.getParent().setLeft(null);
		}else{
		    subroot.getParent().setRight(null);
		}
	    }else if(subroot.getLeft() == null){ //right child only
		BinaryTreeNodeImpl<E> successor = successor(subroot);
		if(subroot == root){
		    //UNFINISHED

		    root = (BinaryTreeNodeImpl<E>)successor;
		}else{
		    successor.getParent().setLeft(null);
		    successor.setParent(subroot.getParent());
		    if(subroot.getParent().getLeft() == subroot){
			successor.getParent().setLeft(successor);
		    }else{
			successor.getParent().setRight(successor);
		    }
		    successor.setRight(subroot.getRight());
		    successor.getRight().setParent(successor);
		}
	    }else if(subroot.getRight() == null){ //left child only
		BinaryTreeNodeImpl<E> predecessor = predecessor(subroot);
		if(subroot == root){
		    //UNFINISHED

		    root = (BinaryTreeNodeImpl<E>)subroot.getLeft();
		}else{
		    predecessor.getParent().setRight(null);
		    predecessor.setParent(subroot.getParent());
		    if(subroot.getParent().getLeft() == subroot){
			predecessor.getParent().setLeft(predecessor);
		    }else{
			predecessor.getParent().setRight(predecessor);
		    }
		    predecessor.setLeft(subroot.getLeft());
		    predecessor.getLeft().setParent(predecessor);
		}
	    }else{
		//UNFINISHED
	    }
	    return;
	}
	if(c.compare(node.getData(), subroot.getData()) < 0){
	    remove(node, (BinaryTreeNodeImpl<E>)subroot.getLeft());
	}else{
	    remove(node, (BinaryTreeNodeImpl<E>)subroot.getRight());
	}
    }

    private BinaryTreeNodeImpl<E> predecessor(BinaryTreeNodeImpl<E> subroot){
	BinaryTreeNodeImpl<E> current = subroot;
	while(current.getRight() != null){
	    current = (BinaryTreeNodeImpl<E>)current.getRight();
	}
	return current;
    }

    private BinaryTreeNodeImpl<E> successor(BinaryTreeNodeImpl<E> subroot){
	BinaryTreeNodeImpl<E> current = subroot;
	while(current.getLeft() != null){
	    current = (BinaryTreeNodeImpl<E>)current.getLeft();
	}
	return current;
    }

    public boolean contains(E element){
	return contains(new BinaryTreeNodeImpl<E>(element), root);
    }

    private boolean contains(BinaryTreeNodeImpl<E> node, BinaryTreeNodeImpl<E> subroot){
	if(subroot == null){
	    return false;
	}
	if(c.compare(node.getData(), subroot.getData()) == 0){
	    return true;
	}
	if(c.compare(node.getData(), subroot.getData()) < 0){
	    return contains(node, (BinaryTreeNodeImpl<E>)subroot.getLeft());
	}else{
	    return contains(node, (BinaryTreeNodeImpl<E>)subroot.getRight());
	}
    }

    public E min(){
	BinaryTreeNodeImpl<E> current = root;
	while(current.getLeft() != null){
	    current = (BinaryTreeNodeImpl<E>)current.getLeft();
	}
	return current.getData();
    }

    public E max(){
	BinaryTreeNodeImpl<E> current = root;
	while(current.getRight() != null){
	    current = (BinaryTreeNodeImpl<E>)current.getRight();
	}
	return current.getData();
    }

}
