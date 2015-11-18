import java.io.*;
import java.util.*;

public class Laptop{

    private String brand;
    private double procSpeed;
    private int memory;
    private int hdd;

    public String getBrand(){return brand;}
    public void setBrand(String brand){this.brand = brand;}
    public double getProcSpeed(){return procSpeed;}
    public void setProcSpeed(double procSpeed){this.procSpeed = procSpeed;}
    public int getMemory(){return memory;}
    public void setMemory(int memory){this.memory = memory;}
    public int getHDD(){return hdd;}
    public void setHDD(int hdd){this.hdd = hdd;}

    public static void main(String[] args){
	//for my own testing
    }

    //MAKE SURE THIS MATCHES THE ASSIGNMENT PAGE
    //
    // public static void main(String[] args){
    // 	Scanner scanner = new Scanner(System.in);
    // 	System.out.println("Input data type (must be 'int' or 'laptop'):");
    // 	String inputDataType = scanner.nextLine().trim();
    // 	if(!inputDataType.equals("int") && !inputDataType.equals("laptop"))
    // 	    throw new IllegalArgumentException("Invalid data type specified.");

    // 	switch(inputDataType){
    // 	case "int":
    // 	    ArrayList<Integer> integers = readIntegerInputs(scanner);
    // 	    Sorter<Integer> intSorter = new Quicksorter<>(intComparator, integers);
    // 	    intSorter.sort();
    // 	    System.out.println(getStringJoinedBy(integers, ", "));
    // 	    break;
    // 	case "laptop":
    // 	    ArrayList<Laptop> laptops = readLaptopInputs(scanner);
    // 	    Sorter<Laptop> laptopSorter = new Quicksorter<>(brandComparator, laptops);
    // 	    laptopSorter.sort();
    // 	    System.out.print("Sorted by brand name:\n\t");
    // 	    System.out.println(getStringJoinedBy(laptops, "\n\t"));
    // 	    System.out.println();

    // 	    laptopSorter.setComparator(processorComparator);
    // 	    laptopSorter.sort();
    // 	    System.out.print("Sorted by processor speed:\n\t");
    // 	    System.out.println(getStringJoinedBy(laptops, "\n\t"));
    // 	    System.out.println();

    // 	    laptopSorter.setComparator(memoryComparator);
    // 	    laptopSorter.sort();
    // 	    System.out.print("Sorted by RAM:\n\t");
    // 	    System.out.println(getStringJoinedBy(laptops, "\n\t"));
    // 	    System.out.println();

    // 	    laptopSorter.setComparator(hddComparator);
    // 	    laptopSorter.sort();
    // 	    System.out.print("Sorted by hard disk capacity:\n\t");
    // 	    System.out.println(getStringJoinedBy(laptops, "\n\t"));
    // 	    break;
    // 	default:
    // 	    throw new IllegalArgumentException("Invalid data type specified.");
    // 	}
    // }

}
