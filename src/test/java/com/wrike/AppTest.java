package com.wrike;

import java.util.Random;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AppTest {
	private WebDriver driver;


	@Before
	public void setUp() {
		ChromeOptions options = new ChromeOptions();

		driver = new ChromeDriver(options);
		driver.get("https://www.wrike.com/");
	}

	@Test
	@Description(value = "Тестовое задание wrike")
	public void wrikeTest() {
		WrikeTestSteps steps = new WrikeTestSteps(driver);
		steps.getStartedStep(randomString() + "+wpt@wriketask.qaa");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		steps.answeredStep(randomString());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		steps.checkTwitterButtonStep();
    }

    @After
	public void endWrikeTest() {
		driver.close();
	}

	private static String randomString() {
		String SALTCHARS = "abcdefghijklmnopqrstuvyxyz";
	    StringBuilder salt = new StringBuilder();
	    Random rnd = new Random();
	    int randomLength = 8 + (int)(Math.random() * 16);
	    while (salt.length() < randomLength) {
	    	int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	    	salt.append(SALTCHARS.charAt(index));
	    }
	    String saltStr = salt.toString();
	    return saltStr;
	}
}
