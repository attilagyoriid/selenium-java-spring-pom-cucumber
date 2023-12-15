package com.ag.harness.config;

import com.ag.harness.annotation.LazyConfiguration;
import com.ag.harness.annotation.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

@Profile("!remote")
@LazyConfiguration
public class WebDriverConfig {

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver chromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().clearDriverCache()
                .setup();
        return new ChromeDriver(options);
    }

}
