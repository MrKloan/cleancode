package fr.esgi.cleancode.fizzbuzz;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

public class FizzbuzzSteps {
	
	private int value;
	private String computed;
	
	@Given("^a value of (\\d+)$")
	public void given_a_value_of(int value) {
		this.value = value;
	}
	
	@When("^I compute the value$")
	public void when_i_compute_the_value() {
		this.computed = Fizzbuzz.run(value);
	}
	
	@Then("^it should return \"(.+)\"$")
	public void then_it_should_return(String expected) {
		Assertions.assertThat(computed).isEqualTo(expected);
	}
}
