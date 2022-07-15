package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    /*
    HRMS Application Negative Login:
    Open chrome browser
    Go to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
    Enter valid username
    Leave password field empty
    Click on login button
    Verify error message with text “Password cannot be empty” is displayed.
     */

    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
        WebElement errorMessage = driver.findElement(By.xpath("//span[text() = 'Password cannot be empty']"));
        String error = errorMessage.getText();

        if(errorMessage.isDisplayed()){
            if(error.equals("Password cannot be empty")){
                System.out.println("Error message is displayed");
            }else {
                System.out.println("Error message is not displayed");
            }
        }
        driver.quit();
    }
}
