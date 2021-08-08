package com.nilesh.test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false,
        features = "classpath:features",
        glue = "com.nilesh.test.glue",
        monochrome = false,
        plugin = {"pretty"
                , "html:target/cucumber_html_output"
                , "json:target/cucumber_json_report.json"
                , "progress:target/cucumber_progress_report"

        },
        tags = "@tt",
        strict = true
)
public class TestRunner {
}
