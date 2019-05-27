package com.lengyel;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * entry point for running cucumber test
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = ("pretty"),
        snippets = SnippetType.CAMELCASE,
        features = "classpath:features")


public class CucumberTest {
}
