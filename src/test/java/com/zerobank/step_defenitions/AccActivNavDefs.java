package com.zerobank.step_defenitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccActivNavDefs {


    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.getDriver().get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.login("username", "password");


    }

    @When("the user clicks on	{string} on the Account Summary page")
    public void the_user_clicks_on_on_the_Account_Summary_page(String string) {

    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {

    }

    @Then("Account	drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String string) {

    }

    @When("the user clicks on	Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {

    }


}
