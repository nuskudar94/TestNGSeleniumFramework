package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getTitleAndUrl {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        //getting title with selenium
        String title = driver.getTitle();   // alt+enter -> getting drop-down menu -> intro. local vari.
        // System.out.println(driver.getTitle());

        System.out.println("title :" +title ); //sout
        System.out.println("title = " + title); //soutv

                            // getting pages' url
        String currentUrl =driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

                            // getting source codes
        String pageSource =driver.getPageSource();
        System.out.println("pageSource = " + pageSource);
    }
}

