package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HW2 {
   /*
   navigate to fb.com
    click on create new account
    fill up all the textboxes
    click on sign up button
    close the pop up
    close the browser
    */
   public static void main(String[] args) throws InterruptedException {
       System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
       WebDriver driver = new ChromeDriver();
       driver.navigate().to("https://www.fb.com");
       driver.findElement(By.linkText("Create new account")).click();
       Thread.sleep(2000);
       WebElement firstName = driver.findElement(By.name("firstname"));
       firstName.sendKeys("Peter");
       WebElement lastName = driver.findElement(By.name("lastname"));
       lastName.sendKeys("Griffin");
       WebElement email = driver.findElement(By.name("reg_email__"));
       email.sendKeys("family_guy@yahoo.com");
       WebElement emailConfirm = driver.findElement(By.name("reg_email_confirmation__"));
       emailConfirm.sendKeys("family_guy@yahoo.com");
       WebElement password = driver.findElement(By.id("password_step_input"));
       password.sendKeys("password");

       driver.findElement(By.xpath("//button[@type='submit'][text()='Sign Up']")).click();
       Thread.sleep(1500);
       driver.findElement(By.xpath("//img[@class='_8idr img'][contains(@src,'https://static.xx.fbcdn.net/')]")).click();
       Thread.sleep(1000);
       driver.quit();
   }
}
