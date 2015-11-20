import java.io.*;
import java.util.*;

public interface Sorter<E>{

    public void sort();
    public void setComparator(Comparator<E> comparator);

}
