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
	if(subroot == null){ //element not present
	    return;
	}
	if(c.compare(node.getData(), subroot.getData()) == 0){ //element found
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
		if(successor.getParent() == subroot){
		    successor.getParent().setRight(null);
		}else{
		    successor.getParent().setLeft(null);
		}
		if(subroot == root){
		    root = successor;
		    successor.setParent(null);
		}else{
		    successor.setParent(subroot.getParent());
		    if(subroot.getParent().getLeft() == subroot){
			successor.getParent().setLeft(successor);
		    }else{
			successor.getParent().setRight(successor);
		    }
		}
		successor.setRight(subroot.getRight());
		if(successor.getRight() != null){
		    successor.getRight().setParent(successor);
		}
	    }else if(subroot.getRight() == null){ //left child only
		//get predecessor
		BinaryTreeNodeImpl<E> predecessor = predecessor(subroot);
		//remove predecessor's parent's link to it
		if(predecessor.getParent() == subroot){
		    predecessor.getParent().setLeft(null);
		}else{
		    predecessor.getParent().setRight(null);
		}
		//set predecessor's link to its new parent, if applicable
		if(subroot == root){
		    root = predecessor;
		    predecessor.setParent(null);
		}else{
		    predecessor.setParent(subroot.getParent());
		    //and set reciprocating link from parent to predecessor
		    if(subroot.getParent().getLeft() == subroot){
			predecessor.getParent().setLeft(predecessor);
		    }else{
			predecessor.getParent().setRight(predecessor);
		    }
		}
		//set predecessor's new left child (right remains null)
		predecessor.setLeft(subroot.getLeft());
		if(predecessor.getLeft() != null){
		    predecessor.getLeft().setParent(predecessor);
		}
	    }else{ //two children
		BinaryTreeNodeImpl<E> successor = successor(subroot);
		if(successor.getParent() == subroot){
		    successor.getParent().setRight(null);
		}else{
		    successor.getParent().setLeft(null);
		}
		if(subroot == root){
		    root = successor;
		    successor.setParent(null);
		}else{
		    successor.setParent(subroot.getParent());
		    if(subroot.getParent().getLeft() == subroot){
			successor.getParent().setLeft(successor);
		    }else{
			successor.getParent().setRight(successor);
		    }
		}
		successor.setLeft(subroot.getLeft());
		successor.getLeft().setParent(successor);
		successor.setRight(subroot.getRight());
		if(successor.getRight() != null){
		    successor.getRight().setParent(successor);
		}
	    }
	    return;
	}
	if(c.compare(node.getData(), subroot.getData()) < 0){ //element not yet found, go left
	    remove(node, (BinaryTreeNodeImpl<E>)subroot.getLeft());
	}else{ //element not yet found, go right
	    remove(node, (BinaryTreeNodeImpl<E>)subroot.getRight());
	}
    }

    private BinaryTreeNodeImpl<E> predecessor(BinaryTreeNodeImpl<E> subroot) throws NoSuchElementException{
	BinaryTreeNodeImpl<E> current = (BinaryTreeNodeImpl<E>)subroot.getLeft();
	if(current == null){
	    throw new NoSuchElementException();
	}
	while(current.getRight() != null){
	    current = (BinaryTreeNodeImpl<E>)current.getRight();
	}
	return current;
    }

    private BinaryTreeNodeImpl<E> successor(BinaryTreeNodeImpl<E> subroot){
	BinaryTreeNodeImpl<E> current = (BinaryTreeNodeImpl<E>)subroot.getRight();
	if(current == null){
	    throw new NoSuchElementException();
	}
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

    public static class DullComparator<E extends Comparable<E>> implements Comparator<E>{
	
	public int compare(E e1, E e2){
	    return e1.compareTo(e2);
	}

    }

    public void printTreeSorta(){
	if(root != null)
	    System.out.println("root: " + root.getData());
	if(root.getLeft() != null)
	    System.out.println("left: " + root.getLeft().getData());
	if(root.getRight() != null)
	    System.out.println("right: " + root.getRight().getData());
	if(root.getLeft().getLeft() != null)
	    System.out.println("left-left: " + root.getLeft().getLeft().getData());
	if(root.getLeft().getRight() != null)
	    System.out.println("left-right: " + root.getLeft().getRight().getData());
	if(root.getRight().getLeft() != null)
	    System.out.println("right-left: " + root.getRight().getLeft().getData());
	if(root.getRight().getRight() != null)
	    System.out.println("right-right: " + root.getRight().getRight().getData());
    }

    public static void main(String[] args){

    	Comparator<String> comp = new DullComparator<String>();

    	BinarySearchTree<String> tree = new BinarySearchTree<String>(comp);

	tree.add("4root");
	tree.add("2left");
	tree.add("6right");
	tree.add("3leftright");
	tree.add("1leftleft");
	tree.add("7rightright");
	// tree.add("5rightleft");
	tree.printTreeSorta();

	System.out.println();

	// tree.remove("8");
	// tree.remove("4root");
	// tree.remove("5rightleft");
	tree.remove("6right");
	tree.remove("2left");
	tree.printTreeSorta();

	//now only contains 4,3,7,1

	System.out.println(tree.contains(4));
	System.out.println(tree.contains(3));
	System.out.println(tree.contains(7));
	System.out.println(tree.contains(1));
	System.out.println(tree.contains(5));
	System.out.println(tree.contains(42));

    }

}
