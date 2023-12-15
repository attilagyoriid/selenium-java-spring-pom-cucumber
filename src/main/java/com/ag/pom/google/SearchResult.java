package com.ag.pom.google;

import com.ag.harness.annotation.PageFragment;
import com.ag.pom.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchResult extends BasePage {

    @FindBy(css = "div.g")
    private List<WebElement> results;

    public int getCount(){
        return this.results.size();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> !this.results.isEmpty());
    }

}
