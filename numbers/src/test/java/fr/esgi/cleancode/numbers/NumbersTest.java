package fr.esgi.cleancode.numbers;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class NumbersTest {

	@Parameterized.Parameter(0)
	public int value;
	@Parameterized.Parameter(1)
	public String expected;

	@Parameterized.Parameters(name = "{index}: Numbers.toRoman({0}) == {1}")
	public static Collection parameters() {
		Object[][] parameters = new Object[][] {
			{1, "I"},
			{2, "II"},
			{3, "III"},
			{5, "V"},
			{6, "VI"},
			{7, "VII"},
			{8, "VIII"},
			{10, "X"},
			{11, "XI"},
			{12, "XII"},
			{13, "XIII"},
			{15, "XV"},
			{16, "XVI"},
			{17, "XVII"},
			{18, "XVIII"},
			{20, "XX"},
			{30, "XXX"},
			{50, "L"},
			{60, "LX"},
			{100, "C"},
			{200, "CC"},
			{300, "CCC"},
			{317, "CCCXVII"},
			{1000, "M"},
			{2000, "MM"},
			{2123, "MMCXXIII"},
			{3000, "MMM"}
		};

		return Arrays.asList(parameters);
	}

	@Test
	public void testToRoman() {
		Assertions.assertThat(Numbers.toRoman(value)).isEqualTo(expected);
	}
}
