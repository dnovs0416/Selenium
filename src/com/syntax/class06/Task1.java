package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    /*
    Navigate to https://syntaxprojects.com/bootstrap-iframe.php
    verify the header text Sorry, We Couldn't Find Anything For “Asksn” is displayed
    verify enroll today button is enabled
     */

    public static String url = "https://syntaxprojects.com/bootstrap-iframe.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.switchTo().frame("FrameOne");
        WebElement header = driver.findElement(By.xpath("//h1[@class = 'heading-13']"));
        System.out.println("Header text: Sorry, We Couldn't Find Anything For “Asksn” is displayed = "+header.isDisplayed());
        driver.switchTo().defaultContent();

        driver.switchTo().frame("FrameTwo");
        WebElement enrollButton = driver.findElement(By.xpath("//div[text() = 'Enroll today']"));
        System.out.println("Is enroll today button enabled = "+enrollButton.isEnabled());

        driver.quit();


    }
}
