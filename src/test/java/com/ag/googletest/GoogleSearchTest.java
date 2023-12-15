package com.ag.googletest;

import com.ag.SpringBaseTestNGTest;
import com.ag.harness.annotation.LazyAutowired;
import com.ag.harness.service.ScreenshotService;
import com.ag.pom.google.GooglePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleSearchTest extends SpringBaseTestNGTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshotService;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("spring boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.screenshotService.takeScreenShot();
        this.googlePage.close();
    }

}
