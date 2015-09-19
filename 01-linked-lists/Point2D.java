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
	// nope UniLinkedList<OrderedDoublePair>.Cursor cursor = new UniLinkedList<OrderedDoublePair>.Cursor(points);
	// also nope UniLinkedList.Cursor cursor = points.new Cursor(points);

	//
	// cursor.next(); //ignore head
	// while(cursor.hasNext()){
	//     OrderedDoublePair pt = cursor.next();
	//     sumX += pt.getX();
	//     sumY += pt.getY();
	// }
	return new OrderedDoublePair(sumX/points.size(), sumY/points.size());
    }

    //returns point closest to the origin
    public static OrderedDoublePair smallest(UniLinkedList<OrderedDoublePair> points){
	return new OrderedDoublePair(0,0);
	
    }

    //returns point farthest from the origin
    public static OrderedDoublePair largest(UniLinkedList<OrderedDoublePair> points){
	return new OrderedDoublePair(0,0);

    }

    //reads command-line input in the form "x y" (line by line) until user types "done"
    //compute centroid
    //remove duplicates
    //find nearest and farthest points
    //remove all points from original list whose coordinates sum to an even number
    //print point closest to centroid after deduplication (huh...)
    // public static void main(String[] args){

    // }

}
