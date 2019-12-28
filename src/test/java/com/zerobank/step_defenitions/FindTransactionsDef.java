package com.zerobank.step_defenitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FindTransactionsDef {
    LoginPage loginPage = new LoginPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();
    SimpleDateFormat simpleDateFormat;


    @Given("user is navigating to {string}")
    public void userIsNavigatingTo(String link) {
        try {
            loginPage.navigateToModule(link);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException("Wrong module name");
        }
    }

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        accountActivityPage.findTransactionsModule.click();
    }

    @When("clicks search")
    public void clicks_search() {
        BrowserUtils.waitForClickablility(accountActivityPage.findButton, 2);
        accountActivityPage.findButton.click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) throws ParseException {

        for (int i = 1; i <= accountActivityPage.amountOfRawsList.size(); i++) {

            String transactionDate = accountActivityPage.returnValueFromTable(1, i);

            simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

            double date1 = simpleDateFormat.parse(fromDate).getTime();
            double date2 = simpleDateFormat.parse(toDate).getTime();
            double finalDate = simpleDateFormat.parse(transactionDate).getTime();
            Assert.assertTrue(finalDate >= date1 && finalDate <= date2);
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= accountActivityPage.amountOfRawsList.size(); i++) {
            result.add(accountActivityPage.returnValueFromTable(1, i));
        }
        ArrayList<String> sortedResult = new ArrayList<>(result);
        BrowserUtils.sortAndReverseDescending(sortedResult);
        Assert.assertEquals(sortedResult, result);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        BrowserUtils.waitForClickablility(accountActivityPage.fromDate, 2);
        accountActivityPage.fromDate.clear();
        accountActivityPage.fromDate.sendKeys(fromDate);
        accountActivityPage.toDate.clear();
        accountActivityPage.toDate.sendKeys(toDate);
    }

    @Then("the results table should not contain transactions dated {string}")
    public void the_results_table_should_not_contain_transactions_dated(String date) {

        for (int i = 1; i <= accountActivityPage.amountOfRawsList.size(); i++) {
            String transactionDate = accountActivityPage.returnValueFromTable(1, i);
            Assert.assertFalse(transactionDate.contains(date));
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String searchWord) {
        BrowserUtils.waitForClickablility(accountActivityPage.descriptionInput, 2);
        accountActivityPage.descriptionInput.clear();
        accountActivityPage.descriptionInput.sendKeys(searchWord);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String searchWord) {
        BrowserUtils.waitForPresenceOfElement(By.xpath("(//tbody)[2]"), 4);

        for (int i = 1; i <= accountActivityPage.amountOfRawsList.size(); i++) {

            String message = accountActivityPage.returnValueFromTable(2, i);
            Assert.assertTrue(message.contains(searchWord));
        }

    }

    @Then("results table should show at least one result under {string} {int}")
    public void results_table_should_show_at_least_one_result_under(String title, Integer column) {
        BrowserUtils.waitForPresenceOfElement(By.xpath("(//tbody)[2]"), 4);
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= accountActivityPage.amountOfRawsList.size(); i++) {
            String message = accountActivityPage.returnValueFromTable(column, i);
            if (!message.isEmpty()) {
                list.add(message);
            }
        }
        Assert.assertTrue(list.size() >= 1);
    }


    @When("user selects type {string}")
    public void user_selects_type(String type) {
        accountActivityPage.typeList().selectByVisibleText(type);
        accountActivityPage.findButton.click();
    }

    @Then("results table should show no result under {string} {int}")
    public void results_table_should_show_no_result_under(String title, Integer column) {
        BrowserUtils.waitForPresenceOfElement(By.xpath("(//tbody)[2]"), 4);
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= accountActivityPage.amountOfRawsList.size(); i++) {
            String message = accountActivityPage.returnValueFromTable(column, i);
            if (!message.isEmpty()) {
                list.add(message);
            }
        }
        System.out.println(list);
        Assert.assertTrue(list.size() == 0);
    }
}
