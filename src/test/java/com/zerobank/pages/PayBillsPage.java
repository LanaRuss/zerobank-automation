package com.zerobank.pages;

import com.zerobank.utilities.Driver;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PayBillsPage extends BasePage {

    public PayBillsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "id='np_new_payee_name'")
    public WebElement payeeName;

    @FindBy(xpath = "//*[starts-with(@id, 'np_new_payee')]")
    public List<WebElement> addNewPayee;

    @FindBy(id = "add_new_payee")
    public WebElement addButton;

    @FindBy(xpath = "//div[@id  ='alert_content']")
    public WebElement successMessage;

    @FindBy(xpath = "//select[@id='pc_currency']")
    public WebElement currencyDropdown;

    public Select availableCurrencyList() {
        return new Select(currencyDropdown);
    }

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostsButton;

    @FindBy(id = "pc_amount")
    public WebElement amountInput;

    @FindBy(xpath = "//input[starts-with(@id, 'sp_')]")
    public List<WebElement> inputsForPayment;

    @FindBy(id = "sp_payee")
    public WebElement payeeDropdown;

    public Select payeeDropdownList() {
        return new Select(payeeDropdown);
    }

    @FindBy(id = "sp_account")
    public WebElement accountDropdown;

    public Select accountDropdownList() {
        return new Select(accountDropdown);
    }

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;



}
