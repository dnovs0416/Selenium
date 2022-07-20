package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task3 {
    /*
    Go to ebay.com
    get all the categories and print them in the console
    select Computers/Tables & Networking
    click on search
    verify the header
     */

    public static String url = "https://www.ebay.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement categoriesDD = driver.findElement(By.id("gh-cat"));
        Select select = new Select(categoriesDD);

        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            String optionText = option.getText();
            System.out.println(optionText);
        }

        select.selectByVisibleText("Computers/Tablets & Networking");
        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        Thread.sleep(1000);
        searchButton.click();
        Thread.sleep(1000);
        WebElement header = driver.findElement(By.xpath("//span[@class = 'b-pageheader__text']"));
        String headerText = header.getText();
        if (header.isDisplayed() && headerText.equals("Computers, Tablets & Network Hardware")){
            System.out.println("header is verified");
        }
        Thread.sleep(2000);
        driver.quit();

    }
}
