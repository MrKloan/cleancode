package fr.esgi.cleancode.fizzbuzz;

public class Fizzbuzz {
	
	public static String run(int value) {
		String str = "";
		
		if(value % 3 == 0)
			str += "fizz";
		if(value % 5 == 0)
			str += "buzz";
		
		return str.isEmpty() ? String.valueOf(value) : str;
	}
}
