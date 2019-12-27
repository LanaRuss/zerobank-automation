package com.zerobank.step_defenitions;

import com.zerobank.pages.LoginPage;
import io.cucumber.java.en.Given;

public class FindTransactionsDef {
    LoginPage loginPage = new LoginPage();

    @Given("user is navigating to {string}")
    public void userIsNavigatingTo(String link) {
        loginPage.navigateToModule(link);
    }
}
