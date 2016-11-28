package fr.esgi.cleancode.pairs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;

public class MinMaxPairsSteps {
	
	private List<Integer> values;
	private List<Integer> computed;
	
	@Given("^a list of (.*)$")
	public void given_a_list_of(List<Integer> values) {
		this.values = values;
	}
	
	@When("^I compute the list$")
	public void when_i_compute_the_list() {
		this.computed = MinMaxPairs.compute(values);
	}
	
	@Then("^it should return (.*)$")
	public void then_it_should_return(List<Integer> expected) {
		Assertions.assertThat(computed).isEqualTo(expected);
	}
}
