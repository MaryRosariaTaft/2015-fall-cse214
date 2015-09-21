import java.io.*;
import java.util.*;

public class Point2D{

    //calculates Euclidean distance between p and q
    public static double distance(OrderedDoublePair p, OrderedDoublePair q){
	double x1 = p.getX(), y1 = p.getY(), x2 = q.getX(), y2 = q.getY();
	return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)); //Java doesn't have the ** notation :'(
    }
    
    //converts array to UniLinkedList
    public static UniLinkedList<OrderedDoublePair> fromArray(OrderedDoublePair[] points){
	UniLinkedList<OrderedDoublePair> ans = new UniLinkedList<OrderedDoublePair>();
	for(int i = 0; i < points.length; i++){
	    ans.add(points[i]);
	}
	return ans;
    }

    //converts 2D array to 2D UniLinkedList
    //is it a problem to add "throws *Exception" to a method if
    //it's not previously noted / called for in the API?
    public static UniLinkedList<OrderedDoublePair> from2DArray(double[][] points){
	UniLinkedList<OrderedDoublePair> ans = new UniLinkedList<OrderedDoublePair>();
	for(int i = 0; i < points.length; i++){
	    if(points[i].length != 2)
		throw new IllegalArgumentException("at index " + i + ": " + Arrays.toString(points[i]) + " is not a pair of coordinates");
	    ans.add(new OrderedDoublePair(points[i][0], points[i][1]));
	}
	return ans;
    }

    //computes centroid (arithmetic mean of all points in the given list)
    public static OrderedDoublePair centroid(UniLinkedList<OrderedDoublePair> points){
	if(points.isEmpty())
	    throw new IllegalArgumentException("cannot compute centroid of an empty list");
	double sumX = 0;
	double sumY = 0;
	UniLinkedList.Cursor cursor = points.getCursor();
	points.resetCursorToHead();
	cursor.next(); //ignore head
	while(cursor.hasNext()){
	    OrderedDoublePair pt = (OrderedDoublePair)cursor.next();
	    sumX += pt.getX();
	    sumY += pt.getY();
	}
	//account for the one remaining list element
	OrderedDoublePair pt = (OrderedDoublePair)cursor.next();
	sumX += pt.getX();
	sumY += pt.getY();
	// System.out.println("sumX: " + sumX);
	// System.out.println("sumY: " + sumY);
	points.resetCursorToHead();
	return new OrderedDoublePair(sumX/points.size(), sumY/points.size());
    }

    private static OrderedDoublePair closestTo(OrderedDoublePair point, UniLinkedList<OrderedDoublePair> points){
	if(points.size() == 0)
	    throw new IllegalArgumentException("cannot compute the element of a list closest to a given point if that list is empty");
	UniLinkedList.Cursor cursor = points.getCursor();
	points.resetCursorToHead();
	cursor.next(); //ignores head
	OrderedDoublePair smallest = (OrderedDoublePair)cursor.next();
	double smallestDistance = distance(smallest, point);
	while(cursor.hasNext()){
	    OrderedDoublePair pt = (OrderedDoublePair)cursor.next();
	    double dist = distance(pt, point);
	    if(dist < smallestDistance){
		smallest = pt;
		smallestDistance = dist;
	    }
	}
	//account for last element in list
	OrderedDoublePair pt = (OrderedDoublePair)cursor.next();
	double dist = distance(pt, point);
	if(dist < smallestDistance){
	    smallest = pt;
	    smallestDistance = dist;
	}
	points.resetCursorToHead();
	return smallest;		
    } 

    //returns point closest to the origin
    public static OrderedDoublePair smallest(UniLinkedList<OrderedDoublePair> points){
	// if(points.size() == 0)
	//     throw new IllegalArgumentException("cannot compute smallest element of an empty list");
	// UniLinkedList.Cursor cursor = points.getCursor();
	// points.resetCursorToHead();
	// cursor.next(); //ignores head
	// OrderedDoublePair smallest = (OrderedDoublePair)cursor.next();
	// double smallestDistance = distance(smallest,OrderedDoublePair.ORIGIN);
	// while(cursor.hasNext()){
	//     OrderedDoublePair pt = (OrderedDoublePair)cursor.next();
	//     double dist = distance(pt, OrderedDoublePair.ORIGIN);
	//     if(dist < smallestDistance){
	// 	smallest = pt;
	// 	smallestDistance = dist;
	//     }
	// }
	// //account for last element in list
	// OrderedDoublePair pt = (OrderedDoublePair)cursor.next();
	// double dist = distance(pt, OrderedDoublePair.ORIGIN);
	// if(dist < smallestDistance){
	//     smallest = pt;
	//     smallestDistance = dist;
	// }
	// points.resetCursorToHead();
	// return smallest;	
	return closestTo(OrderedDoublePair.ORIGIN, points);
    }

    //NOTE: I could similarly add a farthestFrom() function which takes two parameters here
    //OTHER NOTE: actually, I could have a distance-determining method which
    //takes a point, a set of points, and a toggler (smallest or largest); and
    //then run *all* the methods through that one

    //returns point farthest from the origin
    public static OrderedDoublePair largest(UniLinkedList<OrderedDoublePair> points){
	if(points.size() == 0)
	    throw new IllegalArgumentException("cannot compute largest element of an empty list");
	UniLinkedList.Cursor cursor = points.getCursor();
	points.resetCursorToHead();
	cursor.next(); //ignores head
	OrderedDoublePair largest = (OrderedDoublePair)cursor.next();
	double largestDistance = distance(largest,OrderedDoublePair.ORIGIN);
	while(cursor.hasNext()){
	    OrderedDoublePair pt = (OrderedDoublePair)cursor.next();
	    double dist = distance(pt, OrderedDoublePair.ORIGIN);
	    if(dist > largestDistance){
		largest = pt;
		largestDistance = dist;
	    }
	}
	//account for last element in list
	OrderedDoublePair pt = (OrderedDoublePair)cursor.next();
	double dist = distance(pt, OrderedDoublePair.ORIGIN);
	if(dist > largestDistance){
	    largest = pt;
	    largestDistance = dist;
	}
	points.resetCursorToHead();
	return largest;	

    }

    //removes Nodes<OrderedDoublePair> whose x- and y-cors
    //sum to an even number from the UniLinkedList
    //edits 'points' and returns the updated UniLinkedList
    private static UniLinkedList<OrderedDoublePair> filterEvens(UniLinkedList<OrderedDoublePair> points){
	if(points.size() == 0)
	    throw new IllegalArgumentException("cannot filter an empty list");
	UniLinkedList.Cursor cursor = points.getCursor();
	points.resetCursorToHead();
	OrderedDoublePair current = (OrderedDoublePair)cursor.next(); //current = head
	double sum = 0; //since 'current' is initialized to head, initialize sum to 0 (not necessary, though)
	while(cursor.hasNext()){
	    current = (OrderedDoublePair)cursor.next();
	    sum = current.getX() + current.getY();
	    if(sum % 2 == 0){
		points.remove(current);
	    }
	}
	//account for last element in list
	current = (OrderedDoublePair)cursor.next();
	sum = current.getX() + current.getY();
	if(sum % 2 == 0){
	    points.remove(current);
	}
	points.resetCursorToHead();
	return points;
    }

    public static void main(String[] args){
	UniLinkedList<OrderedDoublePair> input = new UniLinkedList<OrderedDoublePair>();
	Scanner sc = new Scanner(System.in);
	boolean done = false;
	//ADD A PRINTLN TO GIVE USER INSTRUCTIONS
	while(!done){
	    String str = sc.nextLine();
	    if(str.toLowerCase().contains("done")){
		done = true;
	    }else{
		String[] coordinates = str.split("[ ]+");
		if(coordinates.length != 2){
		    throw new IllegalArgumentException("wrong number of arguments");
		}
		double xcor = Double.parseDouble(coordinates[0]);
		double ycor = Double.parseDouble(coordinates[1]);
		// print(Arrays.toString(coordinates)); //for testing
		input.add(new OrderedDoublePair(xcor, ycor));
	    }
	}
	// print(input); //for testing
	print("Centroid = " + centroid(input));
	input.deduplicate();
	print("Centroid of unique points: = " + centroid(input));
        print("Point closest to the origin is " + smallest(input));
        print("Point farthest from the origin is " + largest(input));
	print("After filtering out even-summed points, the list is " + filterEvens(input));
	// print("has input changed? here it is: " + input); //test that 'input' has
	//actually been edited after passing through filterEvens()
	//(although this should've been apparent based on previous methods)
	print("Point closest to the centroid (after deduplication of list data) is " + closestTo(centroid(input), input));
	return;
    }

    private static void print(Object data){
	System.out.println(data);
    }

}
