package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id  ="user_login")
    public WebElement loginField;

    @FindBy(id  ="user_password")
    public WebElement passwordField;

    @FindBy(name = "submit")
    public WebElement signInButton;


    public void login(String usernameKey , String passwordKey){
        loginField.sendKeys(ConfigurationReader.get(usernameKey));
        passwordField.sendKeys(ConfigurationReader.get(passwordKey));
        signInButton.click();

    }
}
