package com.ag.pom.window;

import com.ag.harness.annotation.Window;
import com.ag.pom.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page C")
public class PageC  extends BasePage {

    @FindBy(id = "area")
    private WebElement textArea;

    public void addToArea(final String msg){
        this.textArea.sendKeys(msg);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.textArea.isDisplayed());
    }
}
