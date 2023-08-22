package com.bdd.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = {"html:target/build/cucumber-html-report", "pretty:target/build/cucumber-pretty.txt"
        , "json:target/build/cucumber.json"},
        features = {"src/test/resources/feature/"},
        stepNotifications = true,
        glue = {"com.bdd.stepdefinition"},
        tags = "@Prueba"

)

public class RunnerTest {
}
