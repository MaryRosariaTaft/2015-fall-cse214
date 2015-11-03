import java.io.*;
import java.util.*;

public interface BinaryTree<E>{

    void add(E element);
    void remove(E element);
    boolean contains(E element);
    E min();
    E max();

}
