package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import jdk.internal.access.JavaIOFileDescriptorAccess;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class hoversHW {



        WebDriver driver;



        @BeforeMethod
        public void setUp(){
            driver = WebDriverFactory.getDriver("chrome");
        }

        @AfterMethod
        public void tearDown() throws InterruptedException {
            Thread.sleep(2000);
            driver.quit();
        }

        @Test
        public void Images() throws InterruptedException {
            driver.get("http://practice.cybertekschool.com/hovers");
        List<WebElement> names = driver.findElements(By.xpath("//h5"));
        Actions actions = new Actions(driver);

        for (int i=0 ; i<names.size();i++) {
            Thread.sleep(2000);
            actions.moveToElement(names.get(i)).perform();

            Assert.assertTrue(names.get(i).isDisplayed());
        }

    }
}
