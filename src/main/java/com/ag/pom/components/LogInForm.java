package com.ag.pom.components;

import com.ag.harness.annotation.PageFragment;
import com.ag.pom.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageFragment
public class LogInForm extends BasePage {

    @FindBy(xpath = "//form//div[contains(text(),'Login')]")
    private WebElement logInButton;

    @FindBy(xpath = "//div[contains(text(),'account')]")
    private WebElement createAccountButton;

    @FindBy(css = "input#name")
    private WebElement nameInput;

    @FindBy(css = "input#password")
    private WebElement passwordInput;

    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void pressCreateAccountButton() {
       createAccountButton.click();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.logInButton.isDisplayed() && this.createAccountButton.isDisplayed());
    }


}
