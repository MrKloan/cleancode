package fr.esgi.cleancode.fizzbuzz;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.*;

@RunWith(Parameterized.class)
public class FizzbuzzTest {
	
	@Parameter(0)
	public int value;
	@Parameter(1)
	public String expected;
	
	@Parameters(name = "{index}: Fizzbuzz.run({0}) == {1}")
	public static Collection parameters() {
		Object[][] parameters = new Object[][] {
			{1, "1"},
			{2, "2"},
			{3, "fizz"},
			{4, "4"},
			{5, "buzz"},
			{6, "fizz"},
			{7, "7"},
			{8, "8"},
			{9, "fizz"},
			{10, "buzz"},
			{11, "11"},
			{12, "fizz"},
			{13, "13"},
			{14, "14"},
			{15, "fizzbuzz"}
		};
		
		return Arrays.asList(parameters);
	}
	
	@Test
	public void test() {
		assertThat(Fizzbuzz.run(value)).isEqualTo(expected);
	}
}
