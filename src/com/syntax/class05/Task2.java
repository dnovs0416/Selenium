package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task2 {
    /*
    Go to facebook sign up page
    Fill out the whole form
    Click signup
     */

    public static String url = "https://www.facebook.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement createNewAccount = driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']"));
        createNewAccount.click();
        Thread.sleep(1000);

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Peter");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Griffin");
        WebElement email = driver.findElement(By.name("reg_email__"));
        email.sendKeys("family_guy@yahoo.com");
        WebElement confirmEmail = driver.findElement(By.name("reg_email_confirmation__"));
        confirmEmail.sendKeys("family_guy@yahoo.com");
        WebElement password = driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("familyguy1234");
        WebElement monthsDD = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthsDD);
        selectMonth.selectByVisibleText("Apr");
        WebElement daysDD = driver.findElement(By.id("day"));
        Select selectDay = new Select(daysDD);
        selectDay.selectByVisibleText("16");
        WebElement yearDD = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDD);
        selectYear.selectByVisibleText("1988");
        WebElement gender = driver.findElement(By.xpath("//input[@value = '2']"));
        gender.click();
        WebElement signUp = driver.findElement(By.xpath("//button[@name = 'websubmit']"));
        signUp.click();

        Thread.sleep(5000);
        driver.quit();
    }
}
