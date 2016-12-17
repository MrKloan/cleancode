package fr.esgi.cleancode.numbers;

import java.util.LinkedHashMap;
import java.util.Map;

public class Numbers {

	private static final Map<Integer, String> romanChars;

	static {
		romanChars = new LinkedHashMap<>();
		romanChars.put(1000, "M");
		romanChars.put(900, "CM");
		romanChars.put(500, "D");
		romanChars.put(400, "CD");
		romanChars.put(100, "C");
		romanChars.put(90, "XC");
		romanChars.put(50, "L");
		romanChars.put(40, "XL");
		romanChars.put(10, "X");
		romanChars.put(9, "IX");
		romanChars.put(5, "V");
		romanChars.put(4, "IV");
		romanChars.put(1, "I");
	}

	public static String toRoman(int value) {
		String roman = "";

		for(Map.Entry<Integer, String> romanChar : romanChars.entrySet()) {
			while(value - romanChar.getKey() >= 0) {
				roman += romanChar.getValue();
				value -= romanChar.getKey();
			}
		}

		return roman;
	}
}
