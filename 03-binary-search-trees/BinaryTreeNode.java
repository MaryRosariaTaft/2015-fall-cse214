import java.io.*;
import java.util.*;

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
