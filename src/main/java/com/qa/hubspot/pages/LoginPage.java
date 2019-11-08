package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage{
	
WebDriver driver;
	
	//1. Page Objects / OR / By Locators
	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	//2. constructor of page class:
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	//3. page actions / page methods:
	public String getPageTitle(){
		String title = driver.getTitle();
		System.out.println("login page title is: "+ title);
		return title;
	}
	
	public boolean verifySignUpLink(){
		return driver.findElement(signUpLink).isDisplayed();
	}
	
	public void doLogin(String username, String pwd){
		System.out.println("credentials are : "+ username + " - "+ pwd);
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
	}


}
