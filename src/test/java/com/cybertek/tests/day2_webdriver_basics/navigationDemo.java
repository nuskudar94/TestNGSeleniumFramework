package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigationDemo {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        // back , forward and refresh buttons on browsers

        driver.get("https://google.com");

        //navigate to another site with selenium method
        driver.navigate().to("https://facebook.com");

        Thread.sleep(3000);

        // like press back button
        driver.navigate().back();  // on google rn

        Thread.sleep(3000);

        driver.navigate().forward(); // on fb rn

        //refresh
        driver.navigate().refresh();

    }


}
