package com.cybertek.tests.Assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class myFirstHomework {
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

        WebElement regForm = driver.findElement(By.xpath("//a[.='Registration Form']"));

        regForm.click();

        WebElement birthdayBox = driver.findElement(By.xpath("//input[@name='birthday']"));

        birthdayBox.sendKeys("wrong_dob");

        WebElement actualMessage = driver.findElement(By.xpath("//small[text()='The date of birth is not valid']"));

        //System.out.println(actualMessage.getText());

       // String actMes = actualMessage.getText();

        //String expectedMessage = "The date of birth is not valid";
        //Assert.assertEquals(actMes,expectedMessage);
        Assert.assertTrue(actualMessage.isDisplayed(),"Verify that warning message is displayed");
    }


    @Test
    public void test2(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        WebElement regForm = driver.findElement(By.xpath("//a[.='Registration Form']"));

        regForm.click();

        List<WebElement> langs = driver.findElements(By.xpath("//div[@class='form-check form-check-inline']"));

        //System.out.println(langs.size());

        for (WebElement lang : langs) {
            System.out.println(lang.getText());
            //System.out.println(lang.isDisplayed());
            Assert.assertTrue(lang.isDisplayed(),"verify that languages are displayed");
        }
    }

    @Test
    public void test3(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        WebElement regForm = driver.findElement(By.xpath("//a[.='Registration Form']"));

        regForm.click();

        WebElement nameBox = driver.findElement(By.xpath("//input[@name='firstname']"));

        nameBox.sendKeys("n");

        WebElement warnMess = driver.findElement(By.xpath("//small[.='first name must be more than 2 and less than 64 characters long']"));

        String actMess = warnMess.getText();
        System.out.println(actMess);

        String expMess = "first name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(actMess,expMess);
    }

    @Test
    public void test4(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        WebElement regForm = driver.findElement(By.xpath("//a[.='Registration Form']"));

        regForm.click();

        WebElement nameBox = driver.findElement(By.xpath("//input[@name='lastname']"));

        nameBox.sendKeys("n");

        //The last name must be more than 2 and less than 64 characters long

        WebElement warnMess = driver.findElement(By.xpath("//small[.='The last name must be more than 2 and less than 64 characters long']"));

        String actMess = warnMess.getText();
        System.out.println(actMess);

        String expMess = "The last name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(actMess,expMess);
    }

    @Test
    public void test5(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        WebElement regForm = driver.findElement(By.xpath("//a[.='Registration Form']"));
        regForm.click();
        WebElement fnameBox = driver.findElement(By.xpath("//input[@name='firstname']"));

        fnameBox.sendKeys("Numan");
        WebElement lnameBox = driver.findElement(By.xpath("//input[@name='lastname']"));

        lnameBox.sendKeys("Uskudar");

        WebElement uname = driver.findElement(By.xpath("//input[@name='username']"));
        uname.sendKeys("nuskudar");

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("nuskudar@outlook.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("123456789");

        WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys("465-848-9400");

        WebElement gender = driver.findElement(By.xpath("//input[@value='male']"));
        gender.click();

        WebElement birthday = driver.findElement(By.xpath("//input[@name='birthday']"));
        birthday.sendKeys("03/01/1994");

        WebElement dropdownDept = driver.findElement(By.xpath("//select[@name='department']"));
        Select Deptdrop = new Select(dropdownDept);
        Deptdrop.selectByVisibleText("Department of Engineering");

        WebElement dropdownJob = driver.findElement(By.xpath("//select[@name='job_title']"));
        Select jobDrop = new Select(dropdownJob);
        jobDrop.selectByVisibleText("SDET");

        WebElement progLang = driver.findElement(By.xpath("//input[@value='java']"));
        progLang.click();

        WebElement signUp = driver.findElement(By.xpath("//button[@type='submit']"));
        signUp.click();

        WebElement complete = driver.findElement(By.xpath("//p[contains(text(),'registration')]"));

        String actText = complete.getText();
        Assert.assertEquals(actText,"You've successfully completed registration!","Verify that complete the reg");

   }
}
