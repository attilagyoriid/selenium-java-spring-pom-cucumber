package com.ag.pom.pages;

import com.ag.harness.annotation.Page;
import com.ag.pom.BasePage;
import com.ag.pom.components.LogInForm;
import com.ag.pom.google.SearchResult;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class ShopLandingPage extends BasePage {

    @Autowired
    private LogInForm logInForm;
    @Value("${shop.application.url}")
    private String url;

    @FindBy(xpath = "//div[contains(text(),'Hayroo')]")
    private WebElement shopTitle;
    @FindBy(css = "div[title='Login']")
    private WebElement logInIcon;

    public void goTo(){
        this.driver.get(url);
    }

    public void pressLogInIcon(){
        this.logInIcon.click();
    }

    public void createAccount() {
         this.logInForm.pressCreateAccountButton();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.shopTitle.isDisplayed());
    }


}
