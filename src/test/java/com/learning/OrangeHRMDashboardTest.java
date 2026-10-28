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
}
