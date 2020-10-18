package com.cybertek.tests.Assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC8 {
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
    public void test1 (){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        WebElement autoBtn = driver.findElement(By.xpath("//a[text()='Autocomplete']"));
        autoBtn.click();

        WebElement inputBox= driver.findElement(By.xpath("//input[@id='myCountry']"));

        inputBox.sendKeys("United States of America");

        WebElement submitBtn = driver.findElement(By.xpath("//input[@value='Submit']"));
        submitBtn.click();

        WebElement mssg = driver.findElement(By.xpath("//p[text()='You selected: United States of America']"));

        String mssgText = mssg.getText();
        //Assert.assertTrue(mssg.isDisplayed(),"verify that you get You selected: United States of America message");
        Assert.assertEquals(mssgText,"You selected: United States of America","verify that displayed the message");


    }
}
