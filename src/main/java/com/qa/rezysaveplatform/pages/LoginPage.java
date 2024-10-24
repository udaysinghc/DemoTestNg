package com.qa.rezysaveplatform.pages;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.qa.rezysaveplatform.constants.AppConstants;
import com.qa.rezysaveplatform.utils.ElementUtil;
import org.testng.Assert;

public class LoginPage {

  private final WebDriver driver;
  private final ElementUtil eleUtil;
  private final By searchIcon = By.cssSelector("[alt*='search']");
  private final By logoImage = By.cssSelector("[class*='MuiBox-root css-1l']");
  private final By signUpButton= By.cssSelector("[class*='MuiLoadingButton-root MuiButton-root MuiButton-out']");
  private final By emailTextFiled = By.name("email");
  private final By passwordTextFiled = By.name("password");
  private final By submitButton = By.cssSelector("[type='submit']");
  private final By dashBoardTitle= By.cssSelector("[id='main_topbar_title'] h3");
  private final By accountIcon= By.xpath("//div[@class='MuiAvatar-root MuiAvatar-circular css-laxwdg']/..");
  private final By signOutLink= By.xpath("//p[text()='Sign Out']");
  public final By errorTextTitle = By.cssSelector("[class*='_inputErrorMessage']");

  // page const...
  public LoginPage(WebDriver driver) {
    this.driver = driver;
    eleUtil = new ElementUtil(this.driver);
  }

  public LoginPage navigate() {
    eleUtil.waitForVisibilityOfElement(logoImage, AppConstants.MEDIUM_DEFAUTT_WAIT).isDisplayed();
    return new LoginPage(driver);
  }

  public void doLogin(String email, String password) {
    eleUtil.waitForVisibilityOfElement(signUpButton,20);
    eleUtil.doClick(signUpButton);
    eleUtil.waitForVisibilityOfElement(emailTextFiled, 10);
    eleUtil.doSendKeys(this.emailTextFiled, email);
    eleUtil.doSendKeys(this.passwordTextFiled, password);
    eleUtil.doClick(submitButton);
    eleUtil.waitForVisibilityOfElement(dashBoardTitle, 30);
    eleUtil.waitForVisibilityOfElement(accountIcon,10);
    eleUtil.doClick(accountIcon);
    eleUtil.waitForVisibilityOfElement(signOutLink,20);
    eleUtil.doClick(signOutLink);
    eleUtil.waitForVisibilityOfElement(emailTextFiled,20);
  }


  public void emptyUser(String email, String password, String expectedText) {

    eleUtil.waitForVisibilityOfElement(emailTextFiled, 30);
    eleUtil.clearInput(emailTextFiled);
    eleUtil.doSendKeys(this.emailTextFiled, email);
    eleUtil.clearInput(passwordTextFiled);
    eleUtil.doSendKeys(this.passwordTextFiled, password);
    eleUtil.doClick(submitButton);
    eleUtil.waitForVisibilityOfElement(errorTextTitle, 10);
    System.out.println("title" + eleUtil.doElementGetText(errorTextTitle));
    Assert.assertEquals(expectedText, eleUtil.doElementGetText(errorTextTitle));
  }

  public void doLoginInvalidUser(String email, String password, String expectedText) {

    eleUtil.waitForVisibilityOfElement(emailTextFiled, 30);
    eleUtil.clearInput(emailTextFiled);
    eleUtil.doSendKeys(this.emailTextFiled, email);
    eleUtil.clearInput(passwordTextFiled);
    eleUtil.doSendKeys(this.passwordTextFiled, password);
    eleUtil.doClick(submitButton);
    eleUtil.waitForVisibilityOfElement(errorTextTitle, 10);
    System.out.println("title" + eleUtil.doElementGetText(errorTextTitle));
    Assert.assertEquals(expectedText, eleUtil.doElementGetText(errorTextTitle));
  }

}
