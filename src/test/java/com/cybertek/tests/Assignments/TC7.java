package com.cybertek.tests.Assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC7 {
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

        WebElement fileUpload = driver.findElement(By.xpath("//a[text()='File Upload']"));
        fileUpload.click();

        WebElement chooseFile = driver.findElement(By.name("file"));

        chooseFile.sendKeys("C:\\Users\\Bruker\\Desktop\\newCreated.txt");

        WebElement button = driver.findElement(By.cssSelector(".button"));

        button.click();

        WebElement uploaded = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        String actualSubject = uploaded.getText();

        Assert.assertEquals(actualSubject,"File Uploaded!","Verify that subject is uploaded");

        WebElement fileName = driver.findElement(By.xpath("//div[@id='uploaded-files']"));
        String fileNameActual =fileName.getText();

        Assert.assertTrue(fileName.isDisplayed(),"verify that file name is displayed");


    }

}
