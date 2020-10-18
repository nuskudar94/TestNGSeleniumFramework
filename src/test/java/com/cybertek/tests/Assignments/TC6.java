package com.cybertek.tests.Assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC6 {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1 () throws InterruptedException {
        driver.get("https://www.fakemail.net/");

        WebElement email = driver.findElement(By.cssSelector(".animace"));
        String email1 = email.getText();

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        WebElement mailing = driver.findElement(By.xpath("//a[contains(text(),'Mailing')]"));
        mailing.click();

        WebElement name = driver.findElement(By.xpath("//input[@name='full_name']"));
        name.sendKeys("Numan Uskudar");

        WebElement email2 = driver.findElement(By.xpath("//input[@name='email']"));
        email2.sendKeys(email1);

        WebElement signBut = driver.findElement(By.xpath("//button[@name='wooden_spoon']"));
        signBut.click();

        WebElement SignMess = driver.findElement(By.xpath("//h3[@name='signup_message']"));
        String actMess = SignMess.getText();
        Assert.assertEquals(actMess,"Thank you for signing up. Click the button below to return to the home page.","verify that got mess");

        driver.get("https://www.fakemail.net/");

        WebElement email3 = driver.findElement(By.xpath("//*[@id='schranka']/tr[1]/td[1]"));
        WebDriverWait wait = new WebDriverWait(driver,9);
        wait.until(ExpectedConditions.elementToBeClickable(email3));
        String actualMail = email3.getText();
        Assert.assertEquals(actualMail," do-not-reply@practice.cybertekschool.com","verifyin incoming mailadress");
        email3.click();

        WebElement incomingMail = driver.findElement(By.cssSelector("#odesilatel"));

        Assert.assertEquals(incomingMail.getText(),"do-not-reply@practice.cybertekschool.com","verify email ");

        WebElement subject = driver.findElement(By.cssSelector("#predmet"));
        Assert.assertEquals(subject.getText(),"Thanks for subscribing to practice.cybertekschool.com!","subject verify");




    }

}
