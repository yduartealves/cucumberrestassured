package io.cucumber.common;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@apiTests",
        features = "src/test/resources/io/cucumber/features",
        plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber-html-reports/cucumber.json","rerun:target/failed_scenarios.txt"},
        glue = {"io.cucumber.tests"},
        monochrome = true )
//io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm - allure Plugin to be added if its configured

public class RunCucumberTest {
}
