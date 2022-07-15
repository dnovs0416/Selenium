package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task2 {
    /*
    TC 1: Amazon link count:
    Open chrome browser
    Go to “https://www.amazon.com/”
    Get all links
    Get number of links that has text
    Print to console only the links that has text
     */

    public static String url = "https://www.amazon.com/";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        int linkCounter = 0;
        for (WebElement link : allLinks) {
            String linkText = link.getText();
            String fullLink = link.getAttribute("href");
            if (!linkText.isEmpty()) {
                linkCounter++;
                System.out.println(linkText + " " + fullLink);

            }
        }
        System.out.println("Number of links = "+linkCounter);

        driver.quit();
    }
}
