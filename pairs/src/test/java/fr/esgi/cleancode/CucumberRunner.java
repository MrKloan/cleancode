package fr.esgi.cleancode;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
	format = {"pretty", "html:build/cucumber"}
)
public class CucumberRunner {}
