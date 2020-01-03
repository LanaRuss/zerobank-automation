package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OnlineStatementsPage {

    public OnlineStatementsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy( xpath = "//table/tbody/tr")
    public List<WebElement> listOfstatements;
}
