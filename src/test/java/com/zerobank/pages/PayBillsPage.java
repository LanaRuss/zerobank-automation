package com.zerobank.pages;

import com.zerobank.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PayBillsPage  extends  BasePage{

    public PayBillsPage(){ PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "id='np_new_payee_name'")
    public WebElement payeeName;

    @FindBy (xpath = "//*[starts-with(@id, 'np_new_payee')]")
    public List<WebElement> addNewPayee;

    @FindBy( id = "add_new_payee")
    public WebElement addButton;

    @FindBy( xpath = "//div[@id  ='alert_content']")
    public WebElement successMessage;
}
