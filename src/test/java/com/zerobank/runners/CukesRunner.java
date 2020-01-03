package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
        "html:target/default-cucumber-reports",
        "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue =  "com/zerobank/step_defenitions",
        dryRun = false,
        tags = "@wip"

)
public class CukesRunner {
}
