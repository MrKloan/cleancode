package fr.esgi.cleancode.pairs;

import java.util.Arrays;
import java.util.List;

public class MinMaxPairs {
	
	public static List<Integer> compute(List<Integer> values) {
		if(values.size() == 0)
			return Arrays.asList(0, 0);
		
		return Arrays.asList(
			values.stream().sorted((a, b) -> a < b ? -1 : 1).limit(2).reduce((a, b) -> a * b).get(),
			values.stream().sorted((a, b) -> a > b ? -1 : 1).limit(2).reduce((a, b) -> a * b).get()
		);
	}
}
