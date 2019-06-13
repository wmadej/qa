package com.jsystem.qa.frontend.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features  = "src/test/resources",
        glue = "classpath:com.jsystem.qa.frontend.cucumber",
        plugin = {"html:target/cucumber-html-report", "rerun:target/rerun.txt"},
        tags = {"@notification"
                //"@wordpress"
//                "@login",
//              "@userProfile"
        }




)
public class RunTest {
}
