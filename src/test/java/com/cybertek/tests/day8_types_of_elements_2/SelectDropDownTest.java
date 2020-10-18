package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDownTest {
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

        WebElement dropDownElement = driver.findElement(By.id("state"));

        Select stateDropDown = new Select(dropDownElement);

        List<WebElement> options = stateDropDown.getOptions();

        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        //1.locate your dropdown just like any other webelement with unique locator
        WebElement dropDownElement = driver.findElement(By.id("state"));
        //2.create Select object by passing that element as a constructor
        Select stateDropDown = new Select(dropDownElement);

        //verify that first selection is Select a state
        String expectedOption = "Select a State";
        String actualOption = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");


        //HOW TO SELECT OPTIONS FROM DROPDOWN ?
        //1.SELECT USING VISIBLE TEXT
        Thread.sleep(3000);
        stateDropDown.selectByVisibleText("Virginia");

        expectedOption = "Virginia";
        actualOption = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");


        //SELECT BY INDEX
        Thread.sleep(3000);
        stateDropDown.selectByIndex(51);

        expectedOption = "Wyoming";
        actualOption = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

        //3.SELECT BY VALUE
        Thread.sleep(2000);
        stateDropDown.selectByValue("TX");

        expectedOption = "Texas";
        actualOption = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");
    }
}
