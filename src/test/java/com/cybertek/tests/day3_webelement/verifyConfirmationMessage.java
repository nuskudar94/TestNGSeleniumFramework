package com.cybertek.tests.day3_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    public static void main(String[] args) {

        /*
        Verify confirmation message
-open browser
-go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
-enter any email
-verify that email is displayed in the input box
-click on Retrieve password
-verify that confirmation message says ‘Your e-mail’s been sent!’
         */

        //open chrome
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to site
        driver.get("http://practice.cybertekschool.com/forgot_password");




        // enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        String expectedEmail = "nuskudar@outlook.com";

        //sendKeys()--> send keyboard action to webelement
        emailInputBox.sendKeys(expectedEmail);

        //somehow we should get text from web elements
        //two main ways to get txt from webelements
        //1.getText()--> it will work %99 and it will return string
        //2.getAttribute("value") --> second way of getting text especially input boxes

        String actualEmail = emailInputBox.getAttribute("value");
        System.out.println("actualEmail = " + actualEmail);

        //verify that email is displayed in the input box
        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //click on retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();


        //verify that confirmation message says ‘Your e-mail’s been sent!’
        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));

        System.out.println(actualConfirmationMessage.getText()); //Your e-mail’s been sent!’

        //save actual message
        String actualMessage = actualConfirmationMessage.getText();

        //save expected message
        String expectedMessage = "Your e-mail's been sent!";

        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //close browser
        driver.quit();





    }
}