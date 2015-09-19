public class Tester{

    public static void main(String[] args){

	//ORDEREDDOUBLEPAIR TESTS

	// OrderedDoublePair a = new OrderedDoublePair();
	// OrderedDoublePair b = new OrderedDoublePair(1,1);
	// OrderedDoublePair c = new OrderedDoublePair(2.0,2.0);
	// print(a);
	// print(b);
	// print(c);
	// print(a.equals(b));
	// print(a.equals(new OrderedDoublePair(0,0)));
	// print(new OrderedDoublePair(1,2).equalsIgnoreOrder(new OrderedDoublePair(2,1)));


	//UNILINKEDLIST TESTS

	UniLinkedList<String> ll = new UniLinkedList<String>();
	// print("\n\nHello World\n\n");
	// print(ll.isEmpty());
	// ll.clear();
	// print(ll.size());
	// print(ll.head());
	// print(ll);
	// ll.add("hello");
	// print(ll);
	// ll.add("world");
	// print(ll);
	// ll.add("whoops");
	// print(ll);
	// print(ll.size());
	// print(ll.indexOf("whoops"));
	// print("-------");
	// print(ll.addAfter("hello", "dear"));
	// print(ll);
	// print(ll.addAfter("nonexistent","test"));
	// print(ll);
	// print(ll.contains("dear"));
	// print(ll.contains("nonexistent"));
	// print(ll.size());
	// print(ll.addFirst("alpha"));
	// print(ll);
	// print(ll.remove("whoops"));
	// print(ll);
	// print(ll.remove("hello"));
	// print(ll);
	// print(ll.remove("dear"));
	// print(ll);
	// print(ll.remove("world"));
	// print(ll);
	// ll.add("apple");
	// ll.add("apple");
	// ll.add("pear");
	// ll.add("apple");
	// ll.add("apple");
	// ll.add("pear");
	// ll.add("apple");
	// ll.add("apple");
	// ll.add("pear");	
	// print(ll);
	// print(ll.size());
	// print(ll.removeAll("apple"));
	// print(ll.removeAll("orange"));
	// print(ll); 
	// print(ll.size());
	// ll.add("apple");
	// ll.add("apple");
	// ll.add("pear");	
	// ll.add("apple");
	// ll.add("apple");
	// ll.add("pear");	
	// ll.add("apple");
	// ll.add("apple");
	// ll.add("pear");	
	// print(ll);
	// ll.clear();
	// print("JUST CLEARED");
	// print(ll);
	ll.add("a");
	ll.add("b");
	ll.add("c");
	ll.add("d");
	ll.add("d");
	// print("DEDUPLICATING");
	// ll.deduplicate();
	// print(ll);
	// print(ll.size());
	UniLinkedList<String> ll2 = new UniLinkedList<String>();
	ll2.add("a");
	ll2.add("b");
	ll2.add("c");
	ll2.add("d");
	// print("ll: " + ll);
	// print("ll2: " + ll2);
	// print("ll and ll2 are equal: " + ll.equals(ll2));
	// ll.remove("d");
	// print("ll: " + ll);
	// print("ll2: " + ll2);
	// print("ll and ll2 are equal: " + ll.equals(ll2));
	// ll.remove("d");
	// print("ll: " + ll);
	// print("ll2: " + ll2);
	// print("adding 'c' after 'a' in ll: " + ll.addAfter("a", "c"));
	// print("ll: " + ll);
	// print("adding 'e' after 'd' in ll2: " + ll2.addAfter("d", "e"));
	// print("ll2: " + ll2);
	// //following two lines are intentionally commented out
	// //because the first appropriately throws an exception
	// // print("adding 'd' after 'e' in ll: " + ll.addAfter("e", "d"));
	// // print("ll: " + ll);
	// print("removing all occurences of 'w' from ll2: " + ll2.removeAll("w"));
	// print("ll2: " + ll2);
	print("ll and ll2 are equal: " + ll.equals(ll2));	
	print("ll and ll2 are equal: " + ll.equals(ll2));
	//DOESN'T WORK

	//POINT2D TESTS

	// print(Point2D.distance(a, b));

	// OrderedDoublePair[] arraySet = {a,b,c};
	// UniLinkedList<OrderedDoublePair> llSet;
	// llSet = Point2D.fromArray(arraySet);
	// print(llSet);

	// OrderedDoublePair[] arraySet2 = {a,c,b,a};
	// UniLinkedList<OrderedDoublePair> llSet2;
	// llSet2 = Point2D.fromArray(arraySet2);
	// print(llSet2);

	// double[][] arraySet3 = {{07, 10}, {07, 04}, {12, 31}};
	// UniLinkedList<OrderedDoublePair> llSet3;
	// llSet3 = Point2D.from2DArray(arraySet3);
	// print(llSet3);

	// //works!  commenting out so no exception is thrown while testing other thigns
	// // double[][] arraySet4 = {{07, 04}, {07, 10, 01, 23}, {12, 31}};
	// // UniLinkedList<OrderedDoublePair> llSet4;
	// // llSet4 = Point2D.from2DArray(arraySet4);
	// // print(llSet4);

    }

    public static void print(Object data){
	System.out.println(data);
    }

}
