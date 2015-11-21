import java.io.*;
import java.util.*;

public class Laptop{

    //FIELDS CONSTRUCTOR AND GETTERS AND SETTERS
    private String brand;
    private double procSpeed;
    private int memory;
    private int hdd;
    public Laptop(String brand, double procSpeed, int memory, int hdd){
	this.brand = brand;
	this.procSpeed = procSpeed;
	this.memory = memory;
	this.hdd = hdd;
    }
    public String getBrand(){return brand;}
    public void setBrand(String brand){this.brand = brand;}
    public double getProcSpeed(){return procSpeed;}
    public void setProcSpeed(double procSpeed){this.procSpeed = procSpeed;}
    public int getMemory(){return memory;}
    public void setMemory(int memory){this.memory = memory;}
    public int getHDD(){return hdd;}
    public void setHDD(int hdd){this.hdd = hdd;}

    public String toString(){
	return "{" + brand + ": " + procSpeed + " processor, " + memory + "GB RAM, " + hdd + "GB HDD}";
    }

    //READING/GENERATING STRINGS TO/FROM ARRAYLISTS
    private static ArrayList<Integer> readIntegerInputs(Scanner sc){
	System.out.println("Provide integers (one per line) [type 'end' to finish list]:");
	ArrayList<Integer> list = new ArrayList<Integer>();
	String input;
	Integer i;
	boolean done = false;
	while(!done){
	    input = sc.nextLine().trim();
	    if(input.toLowerCase().equals("end")){
		done = true;
	    }else{
		//error if input is not a character representation of a decimal integer
		list.add(Integer.parseInt(input));
	    }
	}
	return list;
    }
    private static ArrayList<Laptop> readLaptopInputs(Scanner sc){
	System.out.println("Provide laptops (one per line) in the format 'brand,processor-speed,memory,hard-disk-capacity' [type 'end' to finish list]:");
	ArrayList<Laptop> list = new ArrayList<Laptop>();
	String input;
	String[] info;
	String brand;
	Double procSpeed;
	Integer memory;
	Integer hdd;
	Laptop l;
	boolean done = false;
	while(!done){
	    input = sc.nextLine();
	    input = input.replaceAll("\\s","");
	    if(input.toLowerCase().equals("end")){
		done = true;
	    }else{
		info = input.split(",");
		if(info.length > 4){
		    throw new IllegalArgumentException("too many parameters for Laptop");
		}
		brand = info[0];
		procSpeed = new Double(info[1]);
		memory = new Integer(info[2]);
		hdd = new Integer(info[3]);
		list.add(new Laptop(brand, procSpeed, memory, hdd));
	    }
	}
	return list;
    }
    private static <E> String getStringJoinedBy(ArrayList<E> list, String delim){
	String ans = "";
	int i = 0;
	for(; i<list.size()-1; i++){
	    ans += list.get(i).toString() + delim;
	}
	ans += list.get(i);
	return ans;
    }

    //COMPARATORS AND INSTANCES(?) THEREOF
    private static class intComparator implements Comparator<Integer>{
	public int compare(Integer i, Integer j){
	    return i.compareTo(j);
	}
    }
    private static class brandComparator implements Comparator<Laptop>{
	public int compare(Laptop a, Laptop b){
	    return a.getBrand().compareTo(b.getBrand());
	}
    }
    private static class processorComparator implements Comparator<Laptop>{
	public int compare(Laptop a, Laptop b){
	    Double d1 = new Double(a.getProcSpeed());
	    Double d2 = new Double(b.getProcSpeed());
	    return d1.compareTo(d2);
	}
    }
    private static class memoryComparator implements Comparator<Laptop>{
	public int compare(Laptop a, Laptop b){
	    Integer i = new Integer(a.getMemory());
	    Integer j = new Integer(b.getMemory());
	    return i.compareTo(j);
	}
    }
    private static class hddComparator implements Comparator<Laptop>{
	public int compare(Laptop a, Laptop b){
	    Integer i = new Integer(a.getHDD());
	    Integer j = new Integer(b.getHDD());
	    return i.compareTo(j);
	}
    }
    private static intComparator intComparator = new intComparator();
    private static brandComparator brandComparator = new brandComparator();
    private static processorComparator processorComparator = new processorComparator();
    private static memoryComparator memoryComparator = new memoryComparator();
    private static hddComparator hddComparator = new hddComparator();

    //MAIN
    public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Input data type (must be 'int' or 'laptop'):");
    	String inputDataType = scanner.nextLine().trim();
    	if(!inputDataType.equals("int") && !inputDataType.equals("laptop"))
    	    throw new IllegalArgumentException("Invalid data type specified.");

    	switch(inputDataType){
	    case "int":
		ArrayList<Integer> integers = readIntegerInputs(scanner);
		Sorter<Integer> intSorter = new Quicksorter<>(intComparator, integers);
		intSorter.sort();
		System.out.println(getStringJoinedBy(integers, ", "));
		break;
    	    case "laptop":
		ArrayList<Laptop> laptops = readLaptopInputs(scanner);
		Sorter<Laptop> laptopSorter = new Quicksorter<>(brandComparator, laptops);
		laptopSorter.sort();
		System.out.print("Sorted by brand name:\n\t");
		System.out.println(getStringJoinedBy(laptops, "\n\t"));
		System.out.println();

		laptopSorter.setComparator(processorComparator);
		laptopSorter.sort();
		System.out.print("Sorted by processor speed:\n\t");
		System.out.println(getStringJoinedBy(laptops, "\n\t"));
		System.out.println();

		laptopSorter.setComparator(memoryComparator);
		laptopSorter.sort();
		System.out.print("Sorted by RAM:\n\t");
		System.out.println(getStringJoinedBy(laptops, "\n\t"));
		System.out.println();

		laptopSorter.setComparator(hddComparator);
		laptopSorter.sort();
		System.out.print("Sorted by hard disk capacity:\n\t");
		System.out.println(getStringJoinedBy(laptops, "\n\t"));
		break;
    	    default:
		throw new IllegalArgumentException("Invalid data type specified.");
    	}
    }

}
