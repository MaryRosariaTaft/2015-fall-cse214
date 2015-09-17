public class Tester{

    public static void main(String[] args){
	UniLinkedList<String> ll = new UniLinkedList<String>();
	print("\n\nHello World\n\n");
	print(ll.isEmpty());
	ll.clear();
	print(ll.size());
	print(ll.head());
	print(ll);
	ll.add("hello");
	print(ll);
	ll.add("world");
	print(ll);
	ll.add("whoops");
	print(ll);
	print(ll.size());
	print(ll.indexOf("whoops"));
	print("-------");
	print(ll.addAfter("hello", "dear"));
	print(ll);
	print(ll.addAfter("nonexistent","test"));
	print(ll);
	print(ll.contains("dear"));
	print(ll.contains("nonexistent"));
	print(ll.size());
	print(ll.addFirst("alpha"));
	print(ll);
	print(ll.remove("whoops"));
	print(ll);
	print(ll.remove("hello"));
	print(ll);
	print(ll.remove("dear"));
	print(ll);
	print(ll.remove("world"));
	print(ll);
	ll.add("apple");
	ll.add("apple");
	ll.add("pear");
	ll.add("apple");
	ll.add("apple");
	ll.add("pear");
	ll.add("apple");
	ll.add("apple");
	ll.add("pear");	
	print(ll);
	print(ll.size());
	print(ll.removeAll("apple"));
	print(ll.removeAll("orange"));
	print(ll); 
	print(ll.size());
	ll.add("apple");
	ll.add("apple");
	ll.add("pear");	
	ll.add("apple");
	ll.add("apple");
	ll.add("pear");	
	ll.add("apple");
	ll.add("apple");
	ll.add("pear");	
	print(ll);
	ll.clear();
	print("JUST CLEARED");
	print(ll);
	ll.add("a");
	ll.add("b");
	ll.add("c");
	ll.add("d");
	ll.add("d");
	print("DEDUPLICATING");
	ll.deduplicate();
	print(ll);
    }

    public static void print(Object data){
	System.out.println(data);
    }

}
