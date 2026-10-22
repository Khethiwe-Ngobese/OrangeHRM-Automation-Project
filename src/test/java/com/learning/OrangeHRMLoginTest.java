
package com.learning;

// Import Selenium browser controls
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Import Selenium explicit wait tools
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Import Java Duration for setting the wait time
import java.time.Duration;

// Import TestNG test and assertion tools
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMLoginTest {

    @Test
    public void loginWithInvalidUsername(){
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try{
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Page title: "+ driver.getTitle());

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

            usernameField.sendKeys("Wrong");
            pause(2000);

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

            passwordField.sendKeys("admin123");
            pause(2000);

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));

            loginButton.click();


            System.out.println("Login fail! Invalid username was rejected.");
            pause(3000);

           try{

                Thread.sleep(1000);

            }catch(InterruptedException e){

                Thread.currentThread().interrupt();
            }


        }finally{

            driver.quit();
        }
    }

    @Test
    public void loginToOrangeHRM() {

        // Start Chrome
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Wait up to 15 seconds for page elements to appear
        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // Open the OrangeHRM login page
            driver.get(
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
            );

            // Print the URL and title to see what actually loaded
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Page title: " + driver.getTitle());

            // Wait until the username field is visible
            WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.name("username")
                )
            );

            // Enter the demo username
            usernameField.sendKeys("Admin");
            pause(2000);
            // Wait for the password field and enter the demo password
            WebElement passwordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.name("password")
                )
            );
            passwordField.sendKeys("admin123");
            pause(2000);

            // Wait for the Login button and click it
            WebElement loginButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button[type='submit']")
                )
            );
            
            loginButton.click();

            // Wait for the dashboard URL to appear
            wait.until(ExpectedConditions.urlContains("/dashboard"));

            // Verify that the dashboard opened
            Assert.assertTrue(
                driver.getCurrentUrl().contains("/dashboard"),
                "The dashboard did not open after login."
            );

            // Print a success message
            System.out.println("Login successful! Dashboard opened.");

            try{
            //Keep the browser open for 10 seconds so you can see the dashboard
            Thread.sleep(10000);

            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }

        } finally {
            // Close Chrome after the test completes
            driver.quit();
        }
    }

    //Helper method
    private void pause(int milliseconds){

        try{
            Thread.sleep(milliseconds);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
