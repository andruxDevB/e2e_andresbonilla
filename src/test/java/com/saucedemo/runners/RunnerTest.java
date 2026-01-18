package com.saucedemo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.saucedemo.glue",
        plugin = {"json:build/cucumber-reports/json/cucumber.json", "summary"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@serenityE2E"
)
public class RunnerTest {
}
