package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    /*
    Go to https://syntaxprojects.com/javascript-alert-box-demo.php
    click on each button and handle the alert accordingly
     */

    public static String url = "https://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement simpleAlertButton = driver.findElement(By.xpath("//button[@class = 'btn btn-default']"));
        simpleAlertButton.click();
        Thread.sleep(1000);
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();

        WebElement confirmAlertButton = driver.findElement(By.xpath("//button[@onclick = 'myConfirmFunction()']"));
        confirmAlertButton.click();
        Thread.sleep(1000);
        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.accept();

        WebElement promptAlertButton = driver.findElement(By.xpath("//button[text() = 'Click for Prompt Box']"));
        promptAlertButton.click();
        Thread.sleep(1000);
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Dave");
        promptAlert.accept();
        Thread.sleep(1000);

        driver.quit();

    }
}
