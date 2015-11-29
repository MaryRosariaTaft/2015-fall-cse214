import java.io.*;
import java.util.*;

public class DirectAddressTable<V extends Hashable> implements Dictionary<V>{

    private ArrayList<V> table;
    private int MAX_CAPACITY;

    public DirectAddressTable(){
	this(50);
    }

    public DirectAddressTable(int maxCapacity){
	table = new ArrayList<V>();
	MAX_CAPACITY = maxCapacity;
	while(maxCapacity > 0){
	    table.add(null);
	    maxCapacity--;
	}
    }

    public boolean isEmpty(){
	for(int i = 0; i < MAX_CAPACITY; i++)
	    if(table.get(i) != null)
		return false;
	return true;
    }

    /**
     * Deals with collisions really poorly.
     * Just overwrites whatever preexists.
     * In so doing, maintains constant time!
     */
    public void insert(V value){
	if(value == null)
	    throw new NullPointerException();
	int index = value.hash() % MAX_CAPACITY;
	if(table.get(index) != null)
	    System.out.println("@ insert(): overwriting some value in the hash table in order to insert '" + value.toString() + "'");
	table.set(index, value);
    }

    public V delete(V value){
	if(value == null)
	    throw new NullPointerException();
	int index = value.hash() % MAX_CAPACITY;
	V tmp = table.get(index);
	table.set(index, null);
	return tmp;
    }

    public V find(int key){
	if(key < 0 || key > MAX_CAPACITY)
	    throw new IllegalArgumentException();
	return table.get(key);
    }

    @Override
    public String toString(){
	String ans = "";
	int i = 0;
	for(; i < MAX_CAPACITY; i++){
	    if(table.get(i) == null)
		ans += i + " -- null\n";
	    else
		ans += i + " -- " + table.get(i).toString() + "\n";
	}
	return ans;
    }

    // public static void main(String[] args){
    // 	DirectAddressTable<Alphabet> hashTable = new DirectAddressTable<>(26);
    // 	System.out.println("inserting 'b'");
    // 	Alphabet b = new Alphabet('b');
    // 	hashTable.insert(b);
    // 	System.out.println("inserting another 'b'");
    // 	hashTable.insert(new Alphabet('b'));
    // 	System.out.println("deleting 'b': " + hashTable.delete(b));
    // 	// System.out.println("deleting another 'b': " + hashTable.delete(new Alphabet('b')));
    // 	// System.out.println("deleting 'a': " + hashTable.delete(new Alphabet('a')));
    // 	System.out.println("element at key 13: " + hashTable.find(14));
    // 	// System.out.println("element at key 100: " + hashTable.find(100));
    // 	System.out.println("table:\n" + hashTable);
    // 	System.out.println("the table is empty: " + hashTable.isEmpty());
    // 	System.out.println("filling the table: ");
    // 	hashTable.insert(new Alphabet('a'));
    // 	hashTable.insert(new Alphabet('b'));
    // 	hashTable.insert(new Alphabet('c'));
    // 	hashTable.insert(new Alphabet('d'));
    // 	hashTable.insert(new Alphabet('e'));
    // 	hashTable.insert(new Alphabet('f'));
    // 	hashTable.insert(new Alphabet('g'));
    // 	hashTable.insert(new Alphabet('h'));
    // 	hashTable.insert(new Alphabet('i'));
    // 	hashTable.insert(new Alphabet('j'));
    // 	hashTable.insert(new Alphabet('k'));
    // 	hashTable.insert(new Alphabet('l'));
    // 	hashTable.insert(new Alphabet('m'));
    // 	hashTable.insert(new Alphabet('n'));
    // 	hashTable.insert(new Alphabet('o'));
    // 	hashTable.insert(new Alphabet('p'));
    // 	hashTable.insert(new Alphabet('q'));
    // 	hashTable.insert(new Alphabet('r'));
    // 	hashTable.insert(new Alphabet('s'));
    // 	hashTable.insert(new Alphabet('t'));
    // 	hashTable.insert(new Alphabet('u'));
    // 	hashTable.insert(new Alphabet('v'));
    // 	hashTable.insert(new Alphabet('w'));
    // 	hashTable.insert(new Alphabet('x'));
    // 	hashTable.insert(new Alphabet('y'));
    // 	hashTable.insert(new Alphabet('z'));
    // 	System.out.println("table:\n" + hashTable);
    // 	System.out.println("the table is empty: " + hashTable.isEmpty());
    // }

}
