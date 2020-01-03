package com.zerobank.step_defenitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PayBillsDefs {
    PayBillsPage payBillsPage = new PayBillsPage();

    @When("user filles up Pay Saved Payee form with following data")
    public void user_filles_up_form_with_following_data(Map<String, String> map) {

        payBillsPage.payeeDropdownList().selectByVisibleText(map.get("Payee"));
        payBillsPage.accountDropdownList().selectByVisibleText(map.get("Account"));

        List<String> list = new ArrayList<>();
        list.addAll(map.keySet());

        for (WebElement each : payBillsPage.inputsForPayment) {
            for (String eachKey : list) {
                if (eachKey.toLowerCase().contains(each.getAttribute("name"))) {
                    each.sendKeys(map.get(eachKey));
                }
            }
        }
        payBillsPage.payButton.click();

    }

    WebElement inputField;

    @When("user enters {string} into {string} input field")
    public void user_enters_into_input_field(String inputs, String field) {

        inputField = Driver.getDriver().findElement(By.xpath("//input[@name= '" + field + "']"));
        inputField.sendKeys(inputs);
      //  BrowserUtils.waitFor(3);


    }

    @Then("{string} input field should be empty")
    public void input_field_should_be_empty(String string) {
      String result = inputField.getAttribute("value");
        Assert.assertTrue(result.isEmpty());
    }

    @When("user enters {string} into input field")
    public void user_enters_into_input_field(String string, io.cucumber.datatable.DataTable dataTable) {

    }

    @Then("the input field should be empty")
    public void the_input_field_should_be_empty() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }




}
