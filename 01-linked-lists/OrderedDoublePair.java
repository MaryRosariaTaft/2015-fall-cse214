import java.io.*;
import java.util.*;

public class OrderedDoublePair{

    private double x, y;
    public static final OrderedDoublePair ORIGIN = new OrderedDoublePair(0, 0);

    //CONSTRUCTORS

    public OrderedDoublePair(){
	x = 0.0;
	y = 0.0;
    }

    public OrderedDoublePair(int x, int y){
	this.x = (double)x;
	this.y = (double)y;
    }

    public OrderedDoublePair(double x, double y){
	this.x = x;
	this.y = y;
    }

    //CLASS METHODS

    public boolean equals(Object obj){
	if (this == obj)
	    return true;
	if (obj instanceof OrderedDoublePair){
	    OrderedDoublePair that = (OrderedDoublePair)obj;
	    return this.x == that.x && this.y == that.y;
	}
	return false;
    }

    public boolean equalsIgnoreOrder(Object obj){
	if (this == obj)
	    return true;
	if (obj instanceof OrderedDoublePair){
	    OrderedDoublePair that = (OrderedDoublePair)obj;
	    return (this.x == that.x && this.y == that.y) || (this.x == that.y && this.y == that.x);
	}
	return false;
    }

    @Override
    public int hashCode(){
	int result;
	long temp = Double.doubleToLongBits(x);
	result = (int)(temp^(temp>>>32));
	temp = Double.doubleToLongBits(y);
	return 31 * result * (int)(temp^(temp>>>32));
    }

    public String toString(){
	return "("+x+","+y+")";
    }

}
