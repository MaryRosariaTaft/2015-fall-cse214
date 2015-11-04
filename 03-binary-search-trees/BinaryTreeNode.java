/**
 * Mary R. Taft
 * 110505413
 * CSE 214 (3)
 * TA: Mingchen Zhang
 */

import java.io.*;
import java.util.*;

/**
 * 
 * 
 */
public interface BinaryTreeNode<E>{

    E getData();
    void setData(E data);
    BinaryTreeNode<E> getParent();
    void setParent(BinaryTreeNode<E> node);
    BinaryTreeNode<E> getLeft();
    void setLeft(BinaryTreeNode<E> node);
    BinaryTreeNode<E> getRight();
    void setRight(BinaryTreeNode<E> node);
    void removeFromParent();

}
