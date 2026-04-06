package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionConcept {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		/*// Instead of storing like this and printing each, follow the ArrayList
		 * String a = "Apple"; String b = "Mango"; String c = "Orange";
		 */
		
		//Array List
		//List <String> fruit = new ArrayList<>();
		
		//or the below
		
		ArrayList <String> fruit = new ArrayList<>();
		
		fruit.add("Apple");
		fruit.add("Mango");
		fruit.add("Orange");
		fruit.add("Apple");
		
		
		//System.out.println(fruit);
		//fruit.remove(2);
		
		//System.out.println(fruit.get(1)); // To get the value using index. i.e, value present in that index
		System.out.println(fruit);
		
		//Linked List
		LinkedList<String> bat = new LinkedList<>();
		bat.add("MRF");
		bat.add("Adidas");
		bat.add("CEAT");
		bat.add("MRF");
		
		System.out.println(bat);
		
		//SET - HashSET
		Set<String> phone = new HashSet<>();
		phone.add("NOKIA");
		phone.add("SAMSUNG");
		phone.add("HTC");
		phone.add("SAMSUNG");
		
		System.out.println(phone); // No duplicates (removes the duplicates), No Order, No Index
		
		//SET - LinkedHashSet
		LinkedHashSet< String > mobile = new LinkedHashSet<>();
		mobile.add("NOKIA");
		mobile.add("SAMSUNG");
		mobile.add("HTC");
		mobile.add("SAMSUNG");
		mobile.add("REDMI");
		
		System.out.println(mobile); // No duplicates (removes the duplicates), Insertion Order, No Index
		
		//SET - TreeSet
		TreeSet< String > ph = new TreeSet<>();
		ph.add("NOKIA");
		ph.add("SAMSUNG");
		ph.add("HTC");
		ph.add("SAMSUNG");
		ph.add("REDMI");
		
		System.out.println(ph); // No duplicates (removes the duplicates), Sorting Order, No Index
		
	}

}
