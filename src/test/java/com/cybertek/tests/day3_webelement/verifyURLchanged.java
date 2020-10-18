package com.cybertek.tests.day3_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {

    public static void main(String[] args) {
            /*Verify URL changed
        open browser
        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        enter any email
        click on Retrieve password
        verify that url changed to http://practice.cybertekschool.com/email_sent
    */

        //open chrome
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to site
        driver.get("http://practice.cybertekschool.com/forgot_password");




        // enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        //sendKeys()--> send keyboard action to webelement
        emailInputBox.sendKeys("nuskudar@outlook.com");

        //click on retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();


        //expected url
        String expectedURL = "http://practice.cybertekschool.com/email_sent";

        String actualURL =driver.getCurrentUrl() ;

        //verify that url changed to http://practice.cybertekschool.com/email_sent

        if(expectedURL.equals(actualURL)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");

        }


    }
}
