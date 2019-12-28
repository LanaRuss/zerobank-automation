package com.zerobank.step_defenitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginDefs {
    LoginPage loginPage = new LoginPage();
    @Given("The user is on the {string} page")
    public void the_user_is_on_the_page(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().equalsIgnoreCase("Zero - "+string));
    }

    @Then("The user logs in with {string} credentials")
    public void the_user_logs_in_with_credentials(String string) {
        if(string.equalsIgnoreCase("")||string.equalsIgnoreCase("blank")||string.equalsIgnoreCase("empty")) {
            loginPage.loginField.clear();
            loginPage.passwordField.clear();
            loginPage.signInButton.click();
        }
        else if(string.equalsIgnoreCase("correct")) loginPage.login("username","password");
        else loginPage.login("wrongUsername","wrongPassword");
    }

    @Given("The user navigating to the login page")
    public void theUserNavigatingToTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.get("url"));
    }

    @Then("The error message is displayed")
    public void theErrorMessageIsDisplayed() {
        Assert.assertTrue(new LoginPage().ErrorMessage.isDisplayed());
    }
}
