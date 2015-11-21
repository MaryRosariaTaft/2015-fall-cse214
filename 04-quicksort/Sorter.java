/**
 * Mary R. Taft
 * 110505413
 * CSE 214 (4)
 * TA: Mingchen Zhang
 */

import java.io.*;
import java.util.*;

/**
 * This is a simple interface for classes which sort
 * any set of Objects (determined by type E) by means
 * of comparison via a Comparator.  Potential classes
 * which could implement Sorter include Quicksorter,
 * Mergesorter, and, of course, Bogosorter.
 */

public interface Sorter<E>{

    public void sort();
    public void setComparator(Comparator<E> comparator);

}
