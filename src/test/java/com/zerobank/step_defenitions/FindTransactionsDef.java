package com.zerobank.step_defenitions;

import com.zerobank.pages.LoginPage;
import io.cucumber.java.en.Given;
import net.bytebuddy.implementation.bytecode.Throw;

import java.util.concurrent.ExecutionException;

public class FindTransactionsDef {
    LoginPage loginPage = new LoginPage();

    @Given("user is navigating to {string}")
    public void userIsNavigatingTo(String link) {
        try {
        loginPage.navigateToModule(link);
        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Wrong module name");
        }
    }
}
