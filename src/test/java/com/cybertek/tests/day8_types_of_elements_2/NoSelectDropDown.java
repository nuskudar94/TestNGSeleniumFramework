package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropDown {

    WebDriver driver;  // then its reachable

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropDownElement = driver.findElement(By.id("dropdownMenuLink"));

        // to see available options
        dropDownElement.click();

        List<WebElement> dropDownOptions = driver.findElements(By.className("dropdown-item"));

        System.out.println("dropDownOptions.size() = " + dropDownOptions.size());
        Assert.assertEquals(dropDownOptions.size(),5,"verify that blalaa");

        //print them one by one
        for (WebElement option : dropDownOptions) {
            System.out.println(option.getText());
        }

    }
}
