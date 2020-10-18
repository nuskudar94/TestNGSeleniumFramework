package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    //Task:
    //write a static method that takes a String parameter name is browswerType
    //based on the value of the parameter
    //it will set up the browser and the method will be return chromedriver or firefoxdriver object
    //name of the method : getDriver


    public static WebDriver getDriver(String browserType){
            WebDriver driver = null;

            switch (browserType.toLowerCase()){
                case"chrome":
                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver();
                break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();

                    break;
            }
        return driver;

    }


}
