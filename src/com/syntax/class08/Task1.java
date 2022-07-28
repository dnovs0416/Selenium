package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Task1 {
    /*
    go to https://the-internet.herokuapp.com/dynamic_controls
    click on checkbox and click on remove
    verify the text
    click on enable verify the textbox is enabled
    enter text and click disable
    verify the textbox is disabled
     */

    public static String url = "https://the-internet.herokuapp.com/dynamic_controls";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement checkbox = driver.findElement(By.xpath("//input[@label = 'blah']"));
        checkbox.click();

        WebElement removeBtn = driver.findElement(By.xpath("//button[text() = 'Remove']"));
        removeBtn.click();

        WebElement text = driver.findElement(By.xpath("//form[@id = 'checkbox-example']/p"));
        boolean isTextVerified = text.isDisplayed();
        if (isTextVerified){
            System.out.println("Text is verified");
        }else {
            System.out.println("Text is not verified");
        }

        WebElement enableTextbox = driver.findElement(By.xpath("//button[@onclick = 'swapInput()']"));
        enableTextbox.click();
        Thread.sleep(3000);
        WebElement textbox = driver.findElement(By.xpath("//input[@type  = 'text']"));
        boolean isTextboxEnabled = textbox.isEnabled();
        if (isTextboxEnabled){
            System.out.println("Textbox is enabled");
        }else {
            System.out.println("Textbox is disabled");
        }
        textbox.sendKeys("This is enabled");
        enableTextbox.click();
        Thread.sleep(3000);
        isTextboxEnabled = textbox.isEnabled();
        if (isTextboxEnabled){
            System.out.println("Textbox is enabled");
        }else {
            System.out.println("Textbox is disabled");
        }
    }
}
