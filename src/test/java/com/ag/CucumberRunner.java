package com.ag;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.ag.steps",
//        tags =  "@shop",
        plugin = {
                "pretty",
//                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                "html:reports/tests/cucumber/cucumber-report.html",
                "timeline:reports/tests/cucumber/timeline",
                "junit:reports/tests/cucumber/junit/cucumber.xml",
                "testng:reports/tests/cucumber/testng/cucumber.xml",
                "json:reports/tests/cucumber/json/cucumber.json"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
    public final static ThreadLocal<String> BROWSER = new ThreadLocal<>();

//    @BeforeTest
//    @Parameters({"Browser"})
//    public void defineBrowser(String browser) {
//        CucumberRunner.BROWSER.set(browser);
//        System.out.println(browser);
//    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
   
}
