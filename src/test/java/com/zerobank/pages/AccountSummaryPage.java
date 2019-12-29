package com.zerobank.pages;

import com.zerobank.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountSummaryPage extends BasePage {
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "(//tbody/tr/td[1]/ a)[1]")
    public WebElement savings1;

    @FindBy (xpath = "(//tbody/tr/td[1]/ a)[2]")
    public WebElement savings2;

    @FindBy(linkText = "Brokerage")
    public WebElement brokerage;

    @FindBy(linkText = "Checking")
    public WebElement checking;

    @FindBy(linkText = "Credit Card")
    public WebElement creditCard;

    @FindBy(linkText = "Loan")
    public WebElement loan;

    @FindBy(id = "aa_accountId")
    public WebElement accountDropdown;

    @FindBy(xpath = "//h2")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//h2)[3]/../div[3]//th")
    public List<WebElement> creditAccountsColums;

    public Select accontDropdownList(){ return new Select(accountDropdown); }


    public WebElement getLink(String str){
            switch (str){
                case "Savings":
                   return savings1;
                case "Checking":
                    return checking;
                case "Brokerage":
                    return brokerage;
                case "Loan":
                    return loan;
                case "Credit Card":
                    return creditCard;
                default:
                    throw new RuntimeException("no such link");

            }

        }



}
