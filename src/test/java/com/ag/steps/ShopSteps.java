package com.ag.steps;

import com.ag.harness.annotation.LazyAutowired;
import com.ag.pom.pages.ShopLandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@CucumberContextConfiguration
@SpringBootTest
@Slf4j
public class ShopSteps {

    @LazyAutowired
    private ShopLandingPage shopLandingPage;

    @Given("User on HAYROO shop site")
    public void launchSite() {

        this.shopLandingPage.goTo();
        Assert.assertTrue(this.shopLandingPage.isAt());
        log.info("User at HAYROO shop site");
    }


}