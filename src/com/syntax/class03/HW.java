package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
    /*
    Navigate to http://syntaxprojects.com
    Click on start practicing
    click on simple form demo
    enter any text on first text box
    click on show message
    quit the browser
     */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("http://syntaxprojects.com");
        WebElement startPracticing=driver.findElement(By.xpath("//a[text() = ' Start Practising ']"));
        startPracticing.click();
        Thread.sleep(1000);
        WebElement simpleFormDemo=driver.findElement(By.xpath("//a[text() = 'Check Box Demo']/preceding-sibling::a"));
        simpleFormDemo.click();
        WebElement enterMessage=driver.findElement(By.xpath("//input[@id = 'user-message']"));
        enterMessage.sendKeys("hello");
        Thread.sleep(1000);
        WebElement showMessage=driver.findElement(By.xpath("//button[text() = 'Show Message']"));
        showMessage.click();
        Thread.sleep(1000);

        driver.quit();
    }
}
