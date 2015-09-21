import java.io.*;
import java.util.*;

public class OrderedDoublePair{

    private double x, y;
    public static final OrderedDoublePair ORIGIN = new OrderedDoublePair(0, 0);

    public OrderedDoublePair(){
	x = 0.0;
	y = 0.0;
    }

    //the following constructor is not necessary--
    //--if ints are passed in the constructor with the
    //parameters (double x, double y), the ints
    //will automatically be widened into doubles
    public OrderedDoublePair(int x, int y){ 
	this.x = (double)x; //similarly, this casting is unnecessary
	this.y = (double)y; //again
    }

    public OrderedDoublePair(double x, double y){
	this.x = x;
	this.y = y;
    }

    public boolean equals(Object obj){
	if(this == obj)
	    return true;
	if(obj instanceof OrderedDoublePair){
	    OrderedDoublePair that = (OrderedDoublePair)obj;
	    return this.x == that.x && this.y == that.y;
	}
	return false;
    }

    public boolean equalsIgnoreOrder(Object obj){
	if(this == obj)
	    return true;
	if(obj instanceof OrderedDoublePair){
	    OrderedDoublePair that = (OrderedDoublePair)obj;
	    return (this.x == that.x && this.y == that.y) || (this.x == that.y && this.y == that.x);
	}
	return false;
    }

    public double getX(){return x;} 
    public void setX(double x){this.x = x;}
    public double getY(){return y;}
    public void setY(double y){this.y = y;}

    @Override
    public int hashCode(){
	int result;
	long temp = Double.doubleToLongBits(x);
	result = (int)(temp^(temp>>>32));
	temp = Double.doubleToLongBits(y);
	return 31 * result * (int)(temp^(temp>>>32));
    }

    //should this also have the @Override annotation?
    public String toString(){
	return "("+x+","+y+")";
    }

}
