package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.id("username"));



        Assert.assertFalse(usernameInput.isDisplayed(),"verifying that inputBox is not displayed ");

        WebElement startBtn = driver.findElement(By.cssSelector("#start>button"));

        startBtn.click();

        Thread.sleep(5000);

        Assert.assertTrue(usernameInput.isDisplayed(),"verifying that inputBox is displayed ");


    }
}
