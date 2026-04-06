package practice;

public class TypeCastPractice {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//Typecasting - two types -- Implicit / Widening (smaller data type to larger) and Explicit / Narrowing (larger data type to smaller)
		
		//Implicit - System does it automatically
		//byte → short → int → long → float → double
		
		//Example program
		/*
		 * int i = 10;
		 * 
		 * double b = i;
		 * 
		 * System.out.println(b);
		 */
		
		//Explisit - System does it automatically
		//double → float → long → int → short → byte
		
		//Example program
		/*
		 * double d = 10.0; 
		 * 
		 * int i = (int) d;
		 * 
		 * System.out.println(i);
		 */
		
		//Typecasting to a characters
		//Char to Int
		
		/*
		 * char c = 'A';
		 * 
		 * int a = c; 
		 * 
		 * System.out.println(a); //Here it is printing ASCII value of A
		 */		
		
		//Int to char
		
		int x = 65;
		char c = (char) x;
		
		System.out.println(c); // Here it is printing value against to the ASCII number given to integer x
		
	}

}
