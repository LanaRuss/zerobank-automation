package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage {

    public AccountActivityPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

@FindBy (linkText = "Show Transactions")
    public WebElement showTransactionsModule;

    @FindBy (linkText = "Find Transactions")
    public WebElement findTransactionsModule;

    @FindBy (id =  "aa_accountId")
    public WebElement accountOptionsDropdown;

    // returns select of all options for dropdown
   public Select accountOptionsList(){ return new Select(accountOptionsDropdown); }

   @FindBy( xpath = "(//tbody)[2]/tr")
   public List<WebElement> amountOfRawsList;

   @FindBy( xpath = "(//tbody)[2]")
   public WebElement resultTable;

    public String returnValueFromTable(int column , int row){
       String cellValue = null;
     try {
         WebElement cell = Driver.getDriver().findElement(By.xpath("(//tbody)[2]/tr[" + row + "]/td[" + column + "]"));
         cellValue = cell.getText();
     }catch (RuntimeException e){
         System.out.println("no such cell exists");
         cellValue = null;
     }
       return cellValue;
    }

    @FindBy (id =  "aa_description")
    public WebElement descriptionInput;

    @FindBy (id =  "aa_fromDate")
    public WebElement fromDate;

    @FindBy (id =  "aa_toDate")
    public WebElement toDate;

    @FindBy (id =  "aa_fromAmount")
    public WebElement  fromAmount;

    @FindBy (id =  "aa_toAmount")
    public WebElement  toAmount;

    @FindBy(id = "aa_type")
    public WebElement type;

    public Select typeList(){ return new Select(accountOptionsDropdown); }

    @FindBy( tagName = "button")
    public WebElement findButton;



}
