package com.zerobank.step_defenitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import net.bytebuddy.implementation.bytecode.Throw;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutionException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jsoup.select.Evaluator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

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
          result.add( accountActivityPage.returnValueFromTable(1, i));
        }

        System.out.println(result);
       // ArrayList<String> sortedResult = new ArrayList<>(result);
        BrowserUtils.sortAndReverseDescending(result);


        System.out.println(result);



    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        BrowserUtils.waitForClickablility(accountActivityPage.fromDate, 2);
        accountActivityPage.fromDate.sendKeys(fromDate);
        accountActivityPage.toDate.sendKeys(toDate);
    }


    @Then("the results table should not contain transactions dated {string}")
    public void the_results_table_should_not_contain_transactions_dated(String date) {

        for (int i = 1; i <= accountActivityPage.amountOfRawsList.size(); i++) {

            String transactionDate = accountActivityPage.returnValueFromTable(1, i);
            System.out.println( transactionDate + "  " + date);

            Assert.assertFalse(transactionDate.contains(date) );

        }

    }


    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String message) {
        accountActivityPage.descriptionInput.sendKeys(message);

    }


    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("user selects type {string}")
    public void user_selects_type(String selectValue) {
        accountActivityPage.typeList().selectByValue(selectValue);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("results table should show no result under")
    public void results_table_should_show_no_result_under() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

}
