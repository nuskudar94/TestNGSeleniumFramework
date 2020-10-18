package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){
        //give a title
        extentLogger = report.createTest("Wrong Password Test");



        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter username: user1");
        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter some password");

        loginPage.loginBtn.click();
        extentLogger.info("Verify click");

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        extentLogger.pass("Test is passed");

    }

    @Test
    public void wrongUsernameTest(){
        extentLogger = report.createTest("Wrong Username Test");
        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        extentLogger.info("Enter username: user1");
        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Enter some password");
        loginPage.loginBtn.click();
        extentLogger.info("Verify click");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        extentLogger.pass("Test is passed");
    }

}
