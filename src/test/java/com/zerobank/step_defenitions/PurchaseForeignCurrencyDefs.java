package com.zerobank.step_defenitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PurchaseForeignCurrencyDefs {
    PayBillsPage payBillsPage = new PayBillsPage();


    @Then("following currencies should be available")

    public void following_currencies_should_be_available(List<String> expectedList) {
        BrowserUtils.waitForVisibility(payBillsPage.currencyDropdown, 2);

        List<String> list = new ArrayList<>();

        for (WebElement each : payBillsPage.availableCurrencyList().getOptions()) {
            if (each.getText().equals("Select One")) {
                continue;
            } else {
                list.add(each.getText());
            }
        }
        Assert.assertEquals(expectedList, list);
    }

    @Then("user enters amount {int}")
    public void user_enters_amount(Integer amount) {
        payBillsPage.amountInput.sendKeys("" + amount);
    }

    @Then("user choses currency {string}")
    public void user_choses_currency(String text) {
        payBillsPage.availableCurrencyList().selectByVisibleText(text);
    }

    @When("user tries to calculate cost without {string}")
    public void user_tries_to_calculate_cost_without(String string) {
        payBillsPage.calculateCostsButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        try {
            Alert alert = Driver.getDriver().switchTo().alert();
            Assert.assertTrue(true);

        } catch (NoAlertPresentException e) {
            Assert.assertTrue(false);
        }


    }
}