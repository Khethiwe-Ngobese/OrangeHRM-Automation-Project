package com.learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class OrangeHRMDashboardTest {
    
    @Test
    public void verifyDashboardOpensAfterLogin(){

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try{
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            System.out.println("Current URL: "+ driver.getCurrentUrl());
            System.out.println("Page title: "+ driver.getTitle());

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            usernameField.sendKeys("Admin");
            pause(2000);

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passwordField.sendKeys("admin123");
            pause(2000);

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
            loginButton.click();
            

            wait.until(ExpectedConditions.urlContains("/dashboard"));

            Assert.assertTrue(
            driver.getCurrentUrl().contains("/dashboard"), "Dashboard did not open after login"
            );

            System.out.println("Dashboard opened successfully");
            pause(5000);
            
        }finally{
            driver.quit();
        }
    }

    private void pause(int milliSeconds){
        try{
            Thread.sleep(milliSeconds);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            throw new RuntimeException();
        }
    }

    @Test
    public void verifyDashboardHeadingIsDisplayed(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try{
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            System.out.println("Current URL: "+ driver.getCurrentUrl());
            System.out.println("Page title: "+ driver.getTitle());

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            usernameField.sendKeys("Admin");
            pause(2000);

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passwordField.sendKeys("admin123");
            pause(2000);

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
            loginButton.click();
            

            WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));

            Assert.assertEquals(heading.getText(),"Dashboard","The heading should display Dashboard");

            System.out.println("The heading display Dashboard");
          

        }finally{
            driver.quit();
        }

    }

    @Test
    public void verifyTimeAtWorkWidgetIsDisplayed(){

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

        try{
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            System.out.println("Current URL: "+ driver.getCurrentUrl());
            System.out.println("Page title: "+ driver.getTitle());

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            usernameField.sendKeys("Admin");
            pause(2000);

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passwordField.sendKeys("admin123");
            pause(2000);

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
            loginButton.click();
            

            WebElement widget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Time at Work']")));
            Assert.assertTrue(widget.isDisplayed(),"The time at work widget should be display");

            System.out.println("Time at work widget is displayed");
           

        }finally{
            driver.quit();
        }
    }

    @Test
    public void verifyLeftNavigationMenuIsDisplayed(){

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try{
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            System.out.println("Current URL: "+ driver.getCurrentUrl());
            System.out.println("Page Title: "+ driver.getTitle());

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            usernameField.sendKeys("Admin");
            pause(2000);

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passwordField.sendKeys("admin123");
            pause(2000);

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
            loginButton.click();

            WebElement navigationMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.oxd-main-menu-item")));

            Assert.assertTrue(navigationMenu.isDisplayed(),"Left navigation menu should be displayed");

            System.out.println("Left navigation menu is displayed");
            

        }finally{
            driver.quit();
        }
    }

    @Test
    public void verifyNavigationToAdminModule(){

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try{

            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            System.out.println("Current URL: "+ driver.getCurrentUrl());
            System.out.println("Page Title: "+ driver.getTitle());

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            usernameField.sendKeys("Admin");
            pause(2000);

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passwordField.sendKeys("admin123");
            pause(2000);

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
            loginButton.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));

            WebElement adminMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Admin']")));
            adminMenu.click();

            WebElement adminHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Admin']")));
            pause(5000);

            Assert.assertTrue(adminHeading.isDisplayed(),"The admin page should be displayed after clicking admin");

            System.out.println("Navigation to admin module successful");
            pause(2000);

        }finally{
            driver.quit();
        }
    }
}
