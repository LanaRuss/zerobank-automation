package com.zerobank.step_defenitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class AccSummaryNavDefs {
    LoginPage loginPage = new LoginPage();
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        loginPage.login("username", "password");
    }

    @When("the user clicks on	{string} link on the Account Summary page")
    public void the_user_clicks_on_on_the_Account_Summary_page(String link) {
        accountSummaryPage.getLink(link).click();
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        String url = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("account-activity"));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedValue) {

        String actualValue = accountSummaryPage.accontDropdownList().getFirstSelectedOption().getAttribute("text");
        Assert.assertEquals(expectedValue, actualValue);
    }


}
