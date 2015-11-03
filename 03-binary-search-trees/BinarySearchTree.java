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
		add(node, subroot.getLeft());
	    }
	}else{
	    if(subroot.getRight() == null){
		subroot.setRight(node);
		node.setParent(subroot);
		return;
	    }else{
		add(node, subroot.getRight());
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
	    //UNFINISHED remove and reorganize stuff
	    System.out.println("UNFINISHED_REMOVE");
	    return;
	}
	if(c.compare(node.getData(), subroot.getData()) < 0){
	    remove(node, subroot.getLeft());
	}else{
	    remove(node, subroot.getRight());
	}
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
	    return contains(node, subroot.getLeft());
	}else{
	    return contains(node, subroot.getRight());
	}
    }

    public E min(){
	BinaryTreeNodeImpl<E> current = root;
	while(current.getLeft() != null){
	    current = current.getLeft();
	}
	return current.getData();
    }

    public E max(){
	BinaryTreeNodeImpl<E> current = root;
	while(current.getRight() != null){
	    current = current.getRight();
	}
	return current.getData();
    }

}
