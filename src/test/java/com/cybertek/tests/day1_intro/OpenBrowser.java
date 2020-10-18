package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class OpenBrowser {

    public static void main(String[] args) {

        // we have to enter this line every time we want to open chrome
        //  to make ready for me to automation
       // WebDriverManager.chromedriver().setup();

        // driver reps one chrome browser
        //WebDriver driver = new ChromeDriver();

        // get method used for going to page
        //driver.get("https://cybertekschool.com");

        WebDriverManager.edgedriver().setup();  // to automate firefox

        WebDriver driver = new EdgeDriver();

        driver.get("https://google.com");


    }
}
