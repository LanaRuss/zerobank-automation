package com.zerobank.step_defenitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryVerificationDefs {
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Then("title should be {string}")
    public void titleShouldBe(String expectedTitle) {
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }

    @Then("Account summary page should have the following account types")
    public void account_summary_page_should_have_the_following_account_types(List<String> expectedList) {
        List<String> actualList = new ArrayList<>();
        for (WebElement each:accountSummaryPage.accountTypes) {
            actualList.add(each.getText());
        }
        Assert.assertEquals(expectedList,actualList);
    }

    @Then("Credit accounts table must have colums")
    public void credit_accounts_table_must_have_colums(List<String> expectedList) {
        List<String> actualList = new ArrayList<>();
        for (WebElement each:accountSummaryPage.creditAccountsColums) {
            actualList.add(each.getText());
        }
        Assert.assertEquals(expectedList,actualList);
    }



}
