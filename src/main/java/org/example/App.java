package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class App
{
    public static void main( String[] args ) throws AWTException, InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://devapp.2ndcareers.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.name("email_id")).sendKeys("employertesting@27.com");
        driver.findElement(By.name("password")).sendKeys("Dharsini@06");
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(7000);
        WebElement closeButton = driver.findElement(By.xpath("//button[text()='Close']"));


        // Click the "Close" button
        closeButton.click();
        driver.findElement(By.id("employerProfileDropdown")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("myProfile")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profilePic")));
        element.click();
//         Wait for the profile picture to be visible and clickable
        WebElement profilePic = driver.findElement(By.id("profilePic"));
        Actions actions = new Actions(driver);
        actions.moveToElement(profilePic).click().perform();


        Thread.sleep(3000);
        WebElement Upload_Profile = driver.findElement(By.xpath("//img[@id='profilePic']/parent::div[@id='employerUploadProfilePhoto']/following::label[@for='newProfilePhoto']//following::div[contains(text(),'Upload')]//br"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", Upload_Profile);
    }
}


