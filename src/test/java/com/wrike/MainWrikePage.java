package com.wrike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainWrikePage {
	private WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[1]/header/div[3]/div[2]/div/div/div[2]/div/form/button")
	private WebElement getStartedButton;
	
	@FindBy(xpath = "/html/body/div[4]/div/form/label[1]/input")
	private WebElement email;
	
	public MainWrikePage( WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	void getStarted(String randomEmail) {
		getStartedButton.click();
		email.sendKeys(randomEmail);
		email.submit();
	}
	
}
