import java.io.*;
improt java.util.*;

public static interface Sorter<E>{

    public static void sort();
    public static void setComparator(Comparator<E> comparator);

}
