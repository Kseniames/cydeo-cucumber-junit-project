package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTable_LoginPage {
    public WebTable_LoginPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputUserName;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    /**
     * this method will log in with credentials
     * @username :Test
     * @password :Tester

     */
    public void login(){
        this.inputUserName.sendKeys("Test");
        this.inputPassword.sendKeys("Tester");
        this.loginButton.click();
    }

    /**
     * This method will log in with credentials that are
     * provided in the method at the time of calling it
     * @param user
     * @param pass
     */
    public void login(String user,String pass){
        this.inputUserName.sendKeys(user);
        this.inputPassword.sendKeys(pass);
        this.loginButton.click();
    }
}
