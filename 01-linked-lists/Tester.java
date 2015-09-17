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
	
    }

    public static void print(Object data){
	System.out.println(data);
    }

}
