package com.wrike;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResendWrikePage {
	private WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[1]/label[1]/button")
	private WebElement quest1Answer1;

	@FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[1]/label[2]/button")
	private WebElement quest1Answer2;
	
	@FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[1]/button")
	private WebElement quest2Answer1;
	
	@FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[2]/button")
	private WebElement quest2Answer2;
	
	@FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[3]/button")
	private WebElement quest2Answer3;
	
	@FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[4]/button")
	private WebElement quest2Answer4;
	
	@FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[5]/button")
	private WebElement quest2Answer5;
	
	@FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[1]/button")
	private WebElement quest3Answer1;
	
	@FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[2]/button")
	private WebElement quest3Answer2;
	
	@FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[3]/button")
	private WebElement quest3Answer3;
	
	@FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[3]/button/span/input")
	private WebElement quest3Answer3Text;
	
	@FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/button")
	private WebElement submitButton;
	
	public ResendWrikePage(WebDriver driver) {
		Assert.assertTrue("This is not the page you are expected", driver.getCurrentUrl().contains("resend"));
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	void questAnswered(String answerText) {
		int answerNumb = randomInt(1,2);
		if (answerNumb == 1) {	
			quest1Answer1.click();
		} else {
			quest1Answer2.click();
		}
		
		answerNumb = randomInt(1,5);
		switch (answerNumb) {
		case 1:
			quest2Answer1.click();
			break;
		case 2:
			quest2Answer2.click();
			break;
		case 3:
			quest2Answer3.click();
			break;
		case 4:
			quest2Answer4.click();
			break;
		case 5:
			quest2Answer5.click();
			break;
		}
		
		answerNumb = randomInt(1,3);
		switch (answerNumb) {
		case 1:
			quest3Answer1.click();
			break;
		case 2:
			quest3Answer2.click();
			break;
		case 3:
			quest3Answer3.click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			quest3Answer3Text.sendKeys(answerText);
			break;
			
		}
		
		submitButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertFalse("Your answer was not submit", submitButton.isDisplayed());
	}
	
	private int randomInt(int x, int y) {
		return x + (int)(Math.random() * y);
	}
}
