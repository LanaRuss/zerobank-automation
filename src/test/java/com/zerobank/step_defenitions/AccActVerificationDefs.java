package com.zerobank.step_defenitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class AccActVerificationDefs {
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Then("account dropdown default option should be {string}")
    public void account_dropdown_default_option_should_be(String expectedOption) {
        Assert.assertEquals(expectedOption, accountActivityPage.accountOptionsList().getFirstSelectedOption().getText());
    }

    @Then("account drop down should have the following options")
    public void account_drop_down_should_have_the_following_options(List<String>options) {
        System.out.println(BrowserUtils.getTextFromSelectOptions(accountActivityPage.accountOptionsList().getOptions()));
        Assert.assertEquals(options,BrowserUtils.getTextFromSelectOptions(accountActivityPage.accountOptionsList().getOptions()));
    }

    @Then("transactions table should have column names")
    public void transactions_table_should_have_column_names(List <String> expectedNames) {
        List<String> actualNames =  new ArrayList<>();
      for (WebElement each : accountActivityPage.tableHeadList){
            actualNames.add(each.getText());
           }
      Assert.assertEquals(expectedNames,actualNames);
       }
    }


