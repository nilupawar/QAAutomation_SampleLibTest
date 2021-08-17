package com.nilesh.test.runner;

import com.nilesh.lib.core.BaseJunitRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"com.nilesh.test.glue"},
        plugin = {"pretty"
                , "html:target/cucumber_html_output"
                , "json:target/cucumber_json_report.json"
                , "progress:target/cucumber_progress_report"

        },
        tags = "@tt",
        strict = true
)
public class TestRunner extends BaseJunitRunner {
}
