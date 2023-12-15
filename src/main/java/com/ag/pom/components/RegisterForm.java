package com.ag.pom.components;

import com.ag.harness.annotation.PageFragment;
import com.ag.pom.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageFragment
public class RegisterForm extends BasePage {

    @Autowired
    private LogInForm logInForm;

    @FindBy(css = "input#cPassword")
    private WebElement passwordConfirmInput;


    @FindBy(css = "input#email")
    private WebElement emailInput;



    public void createAccount(String name, String email, String password, String passwordConfirm ) {
       logInForm.enterName(name);
       logInForm.enterPassword(password);
       enterPasswordConfirm(passwordConfirm);
       enterEmail(email);
       logInForm.pressCreateAccountButton();
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPasswordConfirm(String password) {
        emailInput.sendKeys(password);
    }

    @Override
    public boolean isAt() {
        return wait.until((d) -> this.emailInput.isDisplayed() && this.passwordConfirmInput.isDisplayed());
    }


}
