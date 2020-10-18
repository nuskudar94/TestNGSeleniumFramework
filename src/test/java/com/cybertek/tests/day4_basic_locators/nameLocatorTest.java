package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //maximazing  browsser to fullscreen
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullnameInput = driver.findElement(By.name("full_name"));

        fullnameInput.sendKeys("Mike Smith");

        //proper way
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("nuskudar@outlook.com");

        //lazy way
        driver.findElement(By.name("email")).sendKeys("nuskudar@outlook.com");

        //proper way
        WebElement signupButton = driver.findElement(By.name("wooden_spoon"));
        signupButton.click();

        //lazy way
        driver.findElement(By.name("wooden_spoon")).click();


        driver.quit();
    }
}
