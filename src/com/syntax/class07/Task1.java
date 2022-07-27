package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Task1 {
    /*
    Go to https://demoqa.com/browser-windows
    click on New Tab and print the text from new tab in the console
    click on New Window and print the text from new window in the console
    click on New Window Message and print the text from new window in the console
    Verify (compare) the titles for each page
    Print out the title of the all pages
     */

    public static String url = "https://demoqa.com/browser-windows";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        String mainPageHandle = driver.getWindowHandle();

        WebElement newTab = driver.findElement(By.xpath("//button[text() = 'New Tab']"));
        WebElement newWindow = driver.findElement(By.xpath("//button[text() = 'New Window']"));
        WebElement newWindowMsg = driver.findElement(By.xpath("//button[text() = 'New Window Message']"));

        newTab.click();
        newWindow.click();
        newWindowMsg.click();


        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> it = allWindowHandles.iterator();
        while (it.hasNext()) {
            String handle = it.next();
            if (!mainPageHandle.equals(handle)) {
                driver.switchTo().window(handle);
                String title = driver.getTitle();
                System.out.println(title);
            }
        }
    }
}
