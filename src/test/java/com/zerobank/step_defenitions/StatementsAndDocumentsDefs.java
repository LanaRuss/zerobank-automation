package com.zerobank.step_defenitions;

import com.zerobank.pages.OnlineStatementsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class StatementsAndDocumentsDefs {
    OnlineStatementsPage onlineStatementsPage = new OnlineStatementsPage();

    @When("the user selects the Recent Statements Year {int}")
    public void the_user_selects_the_Recent_Statements_Year(Integer year) {
        Driver.getDriver().findElement(By.linkText(""+year)).click();

    }

    @Then("{int} statements should be displayed for that year")
    public void statements_should_be_displayed_for_that_year(Integer expectedAmount) {
        List<WebElement> myList= new ArrayList<>();
        for (WebElement each :onlineStatementsPage.listOfstatements){
            if(each.isDisplayed()){
                myList.add(each);
            }
        }
        Assert.assertEquals(expectedAmount, (Integer)myList.size());

    }

    @When("the user clicks on statement {string}")
    public void the_user_clicks_on_statement(String text) {
        for (WebElement each :onlineStatementsPage.listOfstatements){

            if(each.getText().equals(text)){
                each.findElement(By.xpath("//a")).click();
                System.out.println("clicked");
                break;
            }
        }
    }

    @Then("the downloaded file name should contain {string}")
    public void the_downloaded_file_name_should_contain(String string) {

    }

    @Then("the file type should be pdf")
    public void the_file_type_should_be_pdf() {

    }

}
