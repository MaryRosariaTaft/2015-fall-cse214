/**
 * Mary R. Taft
 * 110505413
 * CSE 214 (3)
 * TA: Mingchen Zhang
 */

import java.io.*;
import java.util.*;

/**
 * This is a simple interface for a binary tree.
 * (Not, by necessity, a binary *search* tree.)
 */
public interface BinaryTree<E>{

    void add(E element);
    void remove(E element);
    boolean contains(E element);
    E min();
    E max();

}
