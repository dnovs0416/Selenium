package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {
     /*
    navigate to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
    fill out the form
    click on register
    close the browser
     */
     public static void main(String[] args) throws InterruptedException {
         System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
         WebDriver driver=new ChromeDriver();

         driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
         WebElement firstName = driver.findElement(By.id("customer.firstName"));
         firstName.sendKeys("Homer");
         WebElement lastName = driver.findElement(By.id("customer.lastName"));
         lastName.sendKeys("Simpson");
         WebElement address = driver.findElement(By.id("customer.address.street"));
         address.sendKeys("123 Easy Street");
         WebElement city = driver.findElement(By.name("customer.address.city"));
         city.sendKeys("Springfield");
         WebElement state = driver.findElement(By.name("customer.address.state"));
         state.sendKeys("IL");
         WebElement zipcode = driver.findElement(By.id("customer.address.zipCode"));
         zipcode.sendKeys("46466");
         WebElement phoneNo = driver.findElement(By.id("customer.phoneNumber"));
         phoneNo.sendKeys("123-456-7890");
         WebElement ssn = driver.findElement(By.name("customer.ssn"));
         ssn.sendKeys("123-45-6789");
         WebElement username = driver.findElement(By.name("customer.username"));
         username.sendKeys("theSimpson");
         WebElement password = driver.findElement(By.id("customer.password"));
         password.sendKeys("password");
         WebElement confirm = driver.findElement(By.name("repeatedPassword"));
         confirm.sendKeys("password");

         driver.findElement(By.xpath("//input[@type='submit'][@value='Register']")).click();
         Thread.sleep(5000);
         driver.quit();
     }
}
