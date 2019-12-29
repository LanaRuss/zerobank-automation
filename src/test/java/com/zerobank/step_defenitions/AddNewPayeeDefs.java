package com.zerobank.step_defenitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddNewPayeeDefs {

    PayBillsPage payBillsPage =  new PayBillsPage();

    @Given("go to {string} tab")
    public void go_to_tab(String tab) {
        Driver.getDriver().findElement(By.linkText(tab)).click();
    }

    @Given("create new payee using following information")
    public void create_new_payee_using_following_information(Map<String,String> map) {

        List< String > list = new ArrayList<>();
        list.addAll(map.keySet());

        for (WebElement each : payBillsPage.addNewPayee){
            for (String eachKey : list) {
                if (eachKey.toLowerCase().contains(each.getAttribute("name"))){
                  each.sendKeys(map.get(eachKey));
                }
            }
        }

    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String message) {
        Assert.assertEquals( message, payBillsPage.successMessage.getText());

    }

}
