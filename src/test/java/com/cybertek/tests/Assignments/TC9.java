package com.cybertek.tests.Assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TC9 {
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
    //@DataProvider(name = "data-provider")
    //public Object[][] dataProviderMethod() {

      //  return new Object[][] { { new Integer(200),"This page returned a 200 status code" },
        //        { "data two", } };
    //}

    @Test  //(dataProvider = "data-provider")
    public void test1 () throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        WebElement statusCode = driver.findElement(By.xpath("//a[text()='Status Codes']"));
        statusCode.click();

        List<WebElement> codes =  driver.findElements(By.xpath("//div/ul/li"));
        List<WebElement> messages = driver.findElements(By.xpath("//p[contains(text(),'This page')]"));
        for (WebElement code : codes) {
            code.click();
            int x= 0;
            String text1 = code.getText();
            System.out.println(text1);

            Thread.sleep(2000);
            for (WebElement message : messages) {
                String text = message.getText();

                System.out.println(text);

                Assert.assertEquals(text,"This page returned a "+text1 +" status code","verify that message is displayed");
                driver.navigate().back();
                x++;
            }
        }




    }
}
