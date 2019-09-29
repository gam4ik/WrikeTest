package com.wrike;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WrikeTestSteps {
    private WebDriver driver;

    public WrikeTestSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    void getStartedStep(String randomText) {
        MainWrikePage mainWrikePage = new MainWrikePage(driver);
        mainWrikePage.getStarted(randomText);
    }

    @Step
    void answeredStep(String randomText) {
        ResendWrikePage resendWrikePage = new ResendWrikePage(driver);
        resendWrikePage.questAnswered(randomText);
    }

    @Step
    void checkTwitterButtonStep() {
        WebElement twitterIcon = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/ul/li[1]"));
        Assert.assertTrue("Icon on Twitter button is incorrect", twitterIcon.isDisplayed());

        WebElement twitterLink = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/ul/li[1]"));
        twitterLink.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("This is incorect URL", driver.getCurrentUrl() != "https://twitter.com/wrike");
    }
}
